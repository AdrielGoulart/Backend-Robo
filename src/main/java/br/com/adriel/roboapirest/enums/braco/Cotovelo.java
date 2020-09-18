package br.com.adriel.roboapirest.enums.braco;

public enum Cotovelo {
		
	EM_REPOUSO(1), LEVEMENTE_CONTRAIDO(2), 
	CONTRAIDO(3), FORTEMENTE_CONTRAIDO(4);
	
	Cotovelo(int id){
		this.id = id;
	}
	
	public int id; 
	
}
