package br.com.adriel.roboapirest.classes;

import br.com.adriel.roboapirest.enums.braco.Cotovelo;
import br.com.adriel.roboapirest.enums.braco.Pulso;

public class Braco {
	
	private int idPulso;
	private int idCotovelo;
	
	public Braco() {
		this.idPulso = Pulso.EM_REPOUSO.id;
		this.idCotovelo = Cotovelo.EM_REPOUSO.id;
	}
	
	public Braco(int idPulso, int idCotovelo) {
		this.idPulso = idPulso;
		this.idCotovelo = idCotovelo;
	}
	
	
	public int getIdPulso() {
		return idPulso;
	}
	
	public void setIdPulso(int idPulso) {
		this.idPulso = idPulso;
	}
	
	public int getIdCotovelo() {
		return idCotovelo;
	}
	
	public void setIdCotovelo(int idCotovelo) {
		this.idCotovelo = idCotovelo;
	}

}
