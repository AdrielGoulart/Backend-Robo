package br.com.adriel.roboapirest.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adriel.roboapirest.classes.Braco;
import br.com.adriel.roboapirest.classes.Cabeca;
import br.com.adriel.roboapirest.classes.Robo;
import br.com.adriel.roboapirest.enums.braco.Cotovelo;
import br.com.adriel.roboapirest.enums.braco.Pulso;
import br.com.adriel.roboapirest.enums.cabeca.Inclinacao;
import br.com.adriel.roboapirest.enums.cabeca.Rotacao;
import br.com.adriel.roboapirest.enums.util.Mensagem;
import br.com.adriel.roboapirest.response.RoboResponse;
import br.com.adriel.roboapirest.services.RestricoesRobo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class ApiRobo {

	private Braco bracoEsquerdo = new Braco();
	private Braco bracoDireito = new Braco();
	private Cabeca cabeca = new Cabeca();
	private Robo robo = new Robo(cabeca, bracoEsquerdo, bracoDireito);
	private RestricoesRobo restricao = new RestricoesRobo();

	@GetMapping("/robo-inicializacao")
	public ResponseEntity<RoboResponse<Robo>> getRoboInicial() {
		RoboResponse<Robo> response = new RoboResponse<>(true, this.robo, "funfo");

		return new ResponseEntity<RoboResponse<Robo>>(response, HttpStatus.OK);
	}

	// Esse aqui é só um teste
	@PutMapping("/braco-direito/{idFront}/{side}")
	public ResponseEntity<RoboResponse<Robo>> changeCotoveloState(@PathVariable Integer idFront,
			@PathVariable String side) {

		this.bracoDireito.setIdCotovelo(idFront);
		this.robo.setBracoDireito(this.bracoDireito);
		RoboResponse<Robo> response = new RoboResponse<>(true, this.robo, "Carregado com sucesso!");

		return new ResponseEntity<RoboResponse<Robo>>(response, HttpStatus.OK);
	}

	@PutMapping("/braco-estado-cotovelo/{idCotovelo}/{ladoBraco}")
	public ResponseEntity<RoboResponse<Braco>> mudaEstadoCotovelo(@PathVariable Integer idCotovelo,
			@PathVariable String ladoBraco) {
		RoboResponse<Braco> response = new RoboResponse<>();
		if (!restricao.verificaEstadoInvalido(idCotovelo, Cotovelo.FORTEMENTE_CONTRAIDO.id)) {
			response = new RoboResponse<>(false, null, Mensagem.ERRO.getMensagem());
		} else if (ladoBraco.equalsIgnoreCase("direito")) {
			if (restricao.progressaoEstado(idCotovelo, bracoDireito.getIdCotovelo())) {
				bracoDireito.setIdCotovelo(idCotovelo);
				response = new RoboResponse<>(true, bracoDireito, Mensagem.SUCESSO.getMensagem());
			} else {
				response = new RoboResponse<>(false, null, Mensagem.PROGRESSAO_ERRO.getMensagem());
			}
		} else if (ladoBraco.equalsIgnoreCase("esquerdo")) {
			if (restricao.progressaoEstado(idCotovelo, bracoEsquerdo.getIdCotovelo())) {
				bracoEsquerdo.setIdCotovelo(idCotovelo);
				response = new RoboResponse<>(true, bracoEsquerdo, Mensagem.SUCESSO.getMensagem());
			} else {
				response = new RoboResponse<>(false, null, Mensagem.PROGRESSAO_ERRO.getMensagem());
			}
		}

		return new ResponseEntity<RoboResponse<Braco>>(response, HttpStatus.OK);
	}

	@PutMapping("/braco-estado-pulso/{idPulso}/{ladoPulso}")
	public ResponseEntity<RoboResponse<Braco>> mudaEstadoPulso(@PathVariable Integer idPulso,
			@PathVariable String ladoPulso) {

		RoboResponse<Braco> response = new RoboResponse<>();

		if (!restricao.verificaEstadoInvalido(idPulso, Pulso.ROTACAO_PARA_180.id)) {
			response = new RoboResponse<>(false, null, Mensagem.ERRO.getMensagem());
		} else if (ladoPulso.equalsIgnoreCase("direito")) {
			if (bracoDireito.getIdCotovelo() == Cotovelo.FORTEMENTE_CONTRAIDO.id) {
				if (restricao.progressaoEstado(idPulso, bracoDireito.getIdPulso())) {
					bracoDireito.setIdPulso(idPulso);
					response = new RoboResponse<>(true, bracoDireito, Mensagem.SUCESSO.getMensagem());
				} else {
					response = new RoboResponse<>(false, null, Mensagem.PROGRESSAO_ERRO.getMensagem());
				}
			} else {
				response = new RoboResponse<>(false, null, Mensagem.ERRO_PULSO.getMensagem());
			}
		} else if (ladoPulso.equalsIgnoreCase("esquerdo")) {
			if (bracoEsquerdo.getIdCotovelo() == Cotovelo.FORTEMENTE_CONTRAIDO.id) {
				if (restricao.progressaoEstado(idPulso, bracoEsquerdo.getIdPulso())) {
					bracoEsquerdo.setIdPulso(idPulso);
					response = new RoboResponse<>(true, bracoEsquerdo, Mensagem.SUCESSO.getMensagem());
				} else {
					response = new RoboResponse<>(false, null, Mensagem.PROGRESSAO_ERRO.getMensagem());
				}
			} else {
				response = new RoboResponse<>(false, null, Mensagem.ERRO_PULSO.getMensagem());
			}
		}

		return new ResponseEntity<RoboResponse<Braco>>(response, HttpStatus.OK);
	}

	@PutMapping("/cabeca-estado-rotacao/{idRotacao}")
	public ResponseEntity<RoboResponse<Cabeca>> mudaRotacaoCabeca(@PathVariable Integer idRotacao) {
		RoboResponse<Cabeca> response = new RoboResponse<>();

		if (!restricao.verificaEstadoInvalido(idRotacao, Rotacao.ROTACAO_PARA_90.id)) {
			response = new RoboResponse<>(false, null, Mensagem.ERRO.getMensagem());
		} else if (cabeca.getIdInclinacao() == Inclinacao.INCLINACAO_PARA_BAIXO.id) {
			response = new RoboResponse<>(false, null, Mensagem.ERRO_ROTACIONAR_CABECA.getMensagem());
		} else {
			if (restricao.progressaoEstado(idRotacao, cabeca.getIdRotacao())) {
				cabeca.setIdRotacao(idRotacao);
				response = new RoboResponse<>(true, cabeca, Mensagem.SUCESSO.getMensagem());
			} else {
				response = new RoboResponse<>(false, null, Mensagem.PROGRESSAO_ERRO.getMensagem());
			}
		}

		return new ResponseEntity<RoboResponse<Cabeca>>(response, HttpStatus.OK);
	}

	@PutMapping("/cabeca-estado-inclinacao/{idInclinacao}")
	public ResponseEntity<RoboResponse<Cabeca>> mudaInclinacaoCabeca(@PathVariable Integer idInclinacao) {
		RoboResponse<Cabeca> response = new RoboResponse<>();

		if (!restricao.verificaEstadoInvalido(idInclinacao, Inclinacao.INCLINACAO_PARA_BAIXO.id)) {
			response = new RoboResponse<>(false, null, Mensagem.ERRO.getMensagem());
		} else if (restricao.progressaoEstado(idInclinacao, cabeca.getIdInclinacao())) {
				cabeca.setIdInclinacao(idInclinacao);
				response = new RoboResponse<>(true, cabeca, Mensagem.SUCESSO.getMensagem());
			} else {
				response = new RoboResponse<>(false, null, Mensagem.PROGRESSAO_ERRO.getMensagem());
			}

		return new ResponseEntity<RoboResponse<Cabeca>>(response, HttpStatus.OK);
	}

}
