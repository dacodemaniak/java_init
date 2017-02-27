/**
 * 
 */
package com.webprojet.animaux;

/**
 * @author DaCodeManiak
 *
 */
public class Loup extends Canide implements AnimalDeCompagnie {
	private String race;
	private String typeAnimal;
	
	/**
	 * 
	 */
	public Loup() {
		super(); // Sinon, on ne saura pas le mode de d�placement, ni l'alimentation
		this.animalDangereux = 
	}
	
	/**
	 * @setter D�finit la valeur de l'attribut race de la classe Chien
	 * @param race
	 * @return
	 */
	public Loup race(String race){
		this.race = race;
		return this;
	}
	
	public String race(){
		return this.race;
	}
	
	public boolean isAnimalDeCompagnie(){
		return false;
	}
	
	public boolean isAnimalDangereux(){
		return true;
	}

}
