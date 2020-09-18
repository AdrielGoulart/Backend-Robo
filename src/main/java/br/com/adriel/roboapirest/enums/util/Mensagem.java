package br.com.adriel.roboapirest.enums.util;

public enum Mensagem {

	ERRO("Mundança de estado inválida"),
	PROGRESSAO_ERRO("Erro ao realizar a progressão de estados. A progressão requer que "
			+ "sempre siga a ordem crescente ou decrescente, por exemplo, a partir do estado 4, pode-se ir para os estados 3 ou 5, nunca pulando um estado"),
	SUCESSO("Mudança de estado realizada"),
	ERRO_PULSO("Erro! só pode movimentar o Pulso caso o Cotovelo esteja Fortemente Contraído."),
	ERRO_ROTACIONAR_CABECA("Erro! só é possível Rotacionar a Cabeça caso sua Inclinação não esteja em estado Para Baixo.");

	Mensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	private String mensagem;

	public String getMensagem() {
		return this.mensagem;
	}

}
