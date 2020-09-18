package br.com.adriel.roboapirest.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoboResponse<E> {

	@JsonProperty(value = "Sucesso")
	private boolean sucesso;
	@JsonProperty(value = "Data")
	private E data;
	@JsonProperty(value = "Mensagem")
	private String mensagem;

	public RoboResponse() {
		super();
	}

	public RoboResponse(boolean sucesso, E data, String mensagem) {
		super();
		this.sucesso = sucesso;
		this.data = data;
		this.mensagem = mensagem;
	}

	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
