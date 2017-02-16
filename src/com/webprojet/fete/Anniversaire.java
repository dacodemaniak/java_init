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
	 * @var type String par d�faut, un anniversaire...
	 */
	private String type = "Anniversaire";
	
	
	/**
	 * Retourne la valeur de l'attribut priv� "type" de la classe Anniversaire
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
		
		// Ajoutons les invit�s � notre anniversaire
		message += "\nLes invit�s sont :\n";
		
		// On boucle sur le ArrayList personnes
		for(int i=0; i < this.personnes.size(); i++){
			message += this.personnes.get(i).getNom() + " " + this.personnes.get(i).getPrenom() + "\n";
		}
		JOptionPane.showMessageDialog(null, message);
	}
}
