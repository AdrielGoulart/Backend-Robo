package br.com.adriel.roboapirest.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.adriel.roboapirest.services.RestricoesRobo;

@SpringBootTest
public class ApiRoboTest {

	@Autowired
	private RestricoesRobo roboRestricao;

	@Test
	public void teste1ProgressaoEstado() {
		int estadoAtual = 2;
		int novoEstado = 1;

		boolean progresao = this.roboRestricao.progressaoEstado(novoEstado, estadoAtual);

		assertEquals(progresao, true);
	}

	@Test
	public void teste2ProgressaoEstado() {
		int estadoAtual = 1;
		int novoEstado = 3;

		boolean response = roboRestricao.progressaoEstado(novoEstado, estadoAtual);

		assertEquals(response, false);
	}

	@Test
	public void teste3ProgressaoEstado() {
		int estadoAtual = 2;
		int novoEstado = 1;

		boolean response = roboRestricao.progressaoEstado(novoEstado, estadoAtual);

		assertEquals(response, true);
	}

	@Test
	public void teste4ProgressaoEstado() {
		int estadoAtual = 2;
		int novoEstado = 2;

		boolean response = roboRestricao.progressaoEstado(novoEstado, estadoAtual);

		assertEquals(response, false);
	}

	@Test
	public void teste1verificaEstadoInvalido() {
		int idEnumMax = 7;
		int novoId = 2;

		boolean response = roboRestricao.verificaEstadoInvalido(novoId, idEnumMax);

		assertEquals(response, true);
	}

	@Test
	public void teste2verificaEstadoInvalido() {
		int idEnumMax = 5;
		int novoId = 0;

		boolean response = roboRestricao.verificaEstadoInvalido(novoId, idEnumMax);

		assertEquals(response, false);
	}

	@Test
	public void teste3verificaEstadoInvalido() {
		int idEnumMax = 3;
		int novoId = 2;

		boolean response = roboRestricao.verificaEstadoInvalido(novoId, idEnumMax);

		assertEquals(response, true);
	}

	@Test
	public void teste4verificaEstadoInvalido() {
		int idEnumMax = 4;
		int novoId = 4;

		boolean response = roboRestricao.verificaEstadoInvalido(novoId, idEnumMax);

		assertEquals(response, true);
	}

}
