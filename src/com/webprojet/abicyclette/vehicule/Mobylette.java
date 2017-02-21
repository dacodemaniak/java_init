/**
 * 
 */
package com.webprojet.abicyclette.vehicule;

import javax.swing.JOptionPane;

import com.webprojet.fete.personne.Personne;

/**
 * @author DaCodeManiak
 *
 */
public class Mobylette extends Vehicule {
	/**
	 * Parce qu'un véhicule, même la Google Car, a un conducteur et un seul...
	 */
	private Personne conducteur;
	
	public Mobylette() {
		// Initialiser quelques attributs de la classe parente
		this.carburant = "Mélange 2 ou 4%";
		this.nbPlaces = 1;
		this.roues = 2;
	}
	
	public Vehicule conducteur(Personne conducteur){
		this.conducteur = conducteur;
		return this;
	}
	
	public Personne conducteur(){
		return this.conducteur;
	}
	
	public Vehicule conducteur(String nom, String prenom, int age){
		this.conducteur = new Personne();
		conducteur.nom(nom)
			.prenom(prenom)
			.age(age);
		
		return this;
	}
	
	public Vehicule conducteur(String nom, String prenom){
		this.conducteur = new Personne();
		conducteur.nom(nom)
			.prenom(prenom);
		
		return this;
	}
	
	public String balade(){
		return "Balade en Mobylette : " + 
				this.conducteur.nom() + 
				" " + 
				this.conducteur.prenom() + 
				" [" + this.nbPlaces + " " + this.carburant + " " + this.roues + "]";
	}
	
	public void balade(boolean toDialog){
		JOptionPane.showMessageDialog(null,
			"Balade en Mobylette : " + this.conducteur.nom() + " " + this.conducteur.prenom()				
		);
	}

}
