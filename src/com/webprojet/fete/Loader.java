/**
 * 
 */
package com.webprojet.fete;

import com.webprojet.fete.personne.Personne;

/**
 * @author DaCodeManiak
 *
 */
public class Loader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Instanciation de la classe Anniversaire
		 */
		Anniversaire monAnniversaire = new Anniversaire();
		
		/**
		 * Appelons quelques méthodes de la classe
		**/
		monAnniversaire
			.jourSemaine("Samedi")
			.organisateur("Jean-Luc");
		
		Personne invite_1 = new Personne();
		invite_1
			.age(50)
			.nom("Talut")
			.prenom("Jean");
		// Invitons cette nouvelle personne
		monAnniversaire.inviter(invite_1);
		
		Personne invite_2 = new Personne();
		invite_2
			.age(25)
			.nom("Talaron")
			.prenom("Delphine");
		monAnniversaire.inviter(invite_2);
		
		/**
		 * Affichons donc le résultat...
		 */
		monAnniversaire.avertir();
		


	}

}
