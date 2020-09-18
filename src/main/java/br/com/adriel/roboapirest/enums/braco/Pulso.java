package br.com.adriel.roboapirest.enums.braco;

public enum Pulso {
	
	ROTACAO_PARA_MENOS_90(1), ROTACAO_PARA_MENOS_45(2), 
	EM_REPOUSO(3), ROTACAO_PARA_45(4), ROTACAO_PARA_90(5), 
	ROTACAO_PARA_135(6), ROTACAO_PARA_180(7);
	
	Pulso(int id){
		this.id = id;
	}
	
	public int id;

}
