package br.com.adriel.roboapirest.enums.cabeca;

public enum Rotacao {
	
	ROTACAO_PARA_MENOS_90(1), ROTACAO_PARA_MENOS_45(2), 
	EM_REPOUSO(3), ROTACAO_PARA_45(4), ROTACAO_PARA_90(5);
	
	Rotacao(int id){
		this.id = id;
	}
	
	public int id; 
	
	
}
