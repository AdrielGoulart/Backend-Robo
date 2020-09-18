package br.com.adriel.roboapirest.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Robo {

	@JsonProperty(value = "Cabeca")
	private Cabeca cabeca;
	@JsonProperty(value = "BracoEsquerdo")
	private Braco bracoEsquerdo;
	@JsonProperty(value = "BracoDireito")
	private Braco bracoDireito;

	public Robo() {
		// TODO Auto-generated constructor stub
	}

	public Robo(Cabeca cabeca, Braco bracoEsquerdo, Braco bracoDireito) {
		this.cabeca = cabeca;
		this.bracoEsquerdo = bracoEsquerdo;
		this.bracoDireito = bracoDireito;
	}

	public Cabeca getCabeca() {
		return cabeca;
	}

	public void setCabeca(Cabeca cabeca) {
		this.cabeca = cabeca;
	}

	public Braco getBracoEsquerdo() {
		return bracoEsquerdo;
	}

	public void setBracoEsquerdo(Braco bracoEsquerdo) {
		this.bracoEsquerdo = bracoEsquerdo;
	}

	public Braco getBracoDireito() {
		return bracoDireito;
	}

	public void setBracoDireito(Braco bracoDireito) {
		this.bracoDireito = bracoDireito;
	}

}
