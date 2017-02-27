/**
 * 
 */
package com.webprojet.animaux;

/**
 * @author DaCodeManiak
 *
 */
public class Chien extends Canide implements AnimalDeCompagnie {

	/**
	 * 
	 */
	private String race;
	private String genre;
	
	public Chien() {
		super(); // Sinon, on ne saura pas le mode de d�placement, ni l'alimentation
		this.genre = Animal.genre.get("compagnie");
	}
	
	/**
	 * @setter D�finit la valeur de l'attribut race de la classe Chien
	 * @param race
	 * @return
	 */
	public Chien race(String race){
		this.race = race;
		return this;
	}
	
	public String race(){
		return this.race;
	}
	
	/**
	 * La m�thode toString() peut (et doit) �tre @override pour permettre un affichage
	 * personnalis� des informations relatives � un objet :
	 * System.out.println(monObjet)
	 */
	public String toString(){
		String monChien = "<html><h1>Mon chien</h1><ul>";
		monChien += "<li>Race :" + this.race + "</li>" +
				"<li>Nb Pattes : " + this.nbPattes 	+ "</li>" +
				"<li>Alimentation : " + this.typeAlimentation + "</li>" +
				"<li>D�placement : " + this.modeDeplacement + "</li>" +
				"<li>Type : " + this.genre + "</li>" +
				"</ul></html>";
		return monChien;
	}

	@Override
	public boolean isAnimalDeCompagnie() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public boolean isAnimalDeCompagnie(char x){
		if(x == 'O' || x == 'o' || x == 'y' || x == 'Y'){
			return true;
		}
		return false;
	}
	public char animalDeCompagnie(){
		return isAnimalDeCompagnie() ? 'O' : 'N'; 
	}
	public boolean isAnimalDangereux(){
		return false;
	}

}
