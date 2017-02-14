package com.webprojet.fete;

/**
 * Importation des classes que je vais utiliser
**/
import javax.swing.*; // Toutes les classes du package javax.swing

/**
 * @author DaCodeManiak
 *
 */
public class Anniversaire extends Fete {
	/**
	 * @var type String par défaut, un anniversaire...
	 */
	private String type = "Anniversaire";
	
	/**
	 * Retourne la valeur de l'attribut privé "type" de la classe Anniversaire
	 * @return
	 */
	public String type(){
		return this.type;
	}
	
	public void avertir(){
		String message;
		
		message = this.type + " ! \n";
		message += "Il aura lieu " + this.jourSemaine + "\n";
		message += "Organisateur : " + this.organisateur;
		
		JOptionPane.showMessageDialog(null, message);
	}
}
