package com.webprojet.resto;

public class Cafe extends Composition implements Payant {
	protected boolean avecSucre;
	
	
	public Cafe(boolean avecSucre){
		this.prix = 2;
		this.nom = "Expresso";
		this.avecSucre = avecSucre;
	}

	@Override
	public void majoration() {
		if(this.avecSucre)
			this.prix += 0.05; // Le café est offert par la maison
	}
	
	public float getPrix(){
		this.majoration();
		return this.prix;
	}
	
	
}
