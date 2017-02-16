package com.webprojet.qcm;

/**
 * Importation de la librairie des composants graphiques de Java
 */
import javax.swing.*;

public class BonjourQui {
	/**
	 * Instance de la classe Personne
	 * 	Il faudra dire quelle est son contenu... quelque part...
	 */
	private Personne personne;
	
	/**
	 * Le nom d'une personne... à voir comment le définir...
	 */
	private String nomPersonne;
		
	
	public void setPersonne(Personne aQuiJeDisBonjour){
		this.personne = aQuiJeDisBonjour;
		
		// Si je veux utiliser juste l'attribut nomPersonne
		this.nomPersonne = aQuiJeDisBonjour.getNom();
	}
	
	public void sayHello(){
		JOptionPane.showMessageDialog(null, "Bonjour " + this.personne.getNom());
	}
	
	public void sayGoodBye(){
		JOptionPane.showMessageDialog(null, "Au revoir " + this.nomPersonne);
	}
}
