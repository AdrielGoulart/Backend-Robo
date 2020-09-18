package br.com.adriel.roboapirest.enums.cabeca;

public enum Inclinacao {
   INCLINACAO_PARA_CIMA(1), EM_REPOUSO(2), INCLINACAO_PARA_BAIXO(3);
	
	Inclinacao(int id){
		this.id = id;
	}
	
	public int id;
	
}
