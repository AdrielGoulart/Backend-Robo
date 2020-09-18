package br.com.adriel.roboapirest.classes;

import br.com.adriel.roboapirest.enums.cabeca.Inclinacao;
import br.com.adriel.roboapirest.enums.cabeca.Rotacao;

public class Cabeca {

	private int idRotacao;
	private int idInclinacao;

	public Cabeca() {
		this.idRotacao = Rotacao.EM_REPOUSO.id;
		this.idInclinacao = Inclinacao.EM_REPOUSO.id;
	}

	public Cabeca(int idRotacao, int idInclinacao) {
		this.idRotacao = idRotacao;
		this.idInclinacao = idInclinacao;
	}

	public int getIdRotacao() {
		return idRotacao;
	}

	public void setIdRotacao(int idRotacao) {
		this.idRotacao = idRotacao;
	}

	public int getIdInclinacao() {
		return idInclinacao;
	}

	public void setIdInclinacao(int idInclinacao) {
		this.idInclinacao = idInclinacao;
	}

}
