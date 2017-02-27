package com.webprojet.animaux;

public abstract class Canide extends Animal {
	public final int nbPattes = 4;
	
	public Canide(){
		this.typeAlimentation = this.alimentations.get("carnivore");
		this.modeDeplacement = this.deplacements.get("marche");
		
		this.typeAlimentation = this.modes.get("alimentations").get("carnivore");
		this.modeDeplacement = this.modes.get("deplacements").get("marche");
		
	}
}
