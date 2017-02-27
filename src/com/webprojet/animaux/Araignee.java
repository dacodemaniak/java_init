package com.webprojet.animaux;

public class Araignee extends Insecte implements AnimalDeCompagnie{
	public final int nbPattes = 8;
	private String genre;
	
	public Araignee(){
		this.typeAlimentation = this.alimentations.get("insectivore");
		this.modeDeplacement = this.deplacements.get("marche");
		this.genre = Animal.genre.get("sauvage");
	}
	
	/**
	 * La m�thode toString() peut (et doit) �tre @override pour permettre un affichage
	 * personnalis� des informations relatives � un objet :
	 * System.out.println(monObjet)
	 */
	public String toString(){
		String araignee = "<html><h1>Une araign�e</h1><ul>";
		araignee += "<li>Nb Pattes : " + this.nbPattes 	+ "</li>" +
				"<li>Alimentation : " + this.typeAlimentation + "</li>" +
				"<li>D�placement : " + this.modeDeplacement + "</li>" +
				"<li>Genre : " + this.genre + "</li>" +
				"</ul></html>";
		return araignee;
	}

	@Override
	public boolean isAnimalDeCompagnie() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAnimalDangereux() {
		// TODO Auto-generated method stub
		return true;
	}	
}
