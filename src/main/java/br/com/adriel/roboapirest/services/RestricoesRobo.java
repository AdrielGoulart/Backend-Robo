package br.com.adriel.roboapirest.services;

public class RestricoesRobo {

	public RestricoesRobo() {
		super();
	}

	public boolean verificaEstadoInvalido(int novoId, int maiorID) {
		if (novoId <= maiorID && novoId > 0) {
			return true;
		}
		return false;
	}

	public boolean progressaoEstado(int novoEstado, int estadoAtual) {
		if (novoEstado != estadoAtual) {
			if (estadoAtual + 1 == novoEstado || estadoAtual - 1 == novoEstado) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

}
