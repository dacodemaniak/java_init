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
public class Balade {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Balade en Mobylette
		Mobylette mob = new Mobylette();
		mob.conducteur("Aubert", "Jean-Luc");
		mob.balade(true); // Va m'afficher une boîte de dialogue
		
		// Autre balade en Mobylette avec une Personne cette fois
		Personne conducteur = new Personne(65, "Martin", "Circus");
		Mobylette mobGeniale = new Mobylette();
		mobGeniale.nbPlaces(2);
		mobGeniale.conducteur(conducteur);
		String message = mobGeniale.balade();
		JOptionPane.showMessageDialog(null, message);
		
		// Troisième balade... encore une autre personne crée on the fly
		Mobylette meule = new Mobylette();
		meule.conducteur(new Personne(70, "Renaud", "Sechan"));
		JOptionPane.showMessageDialog(null, meule.balade());

	}

}
