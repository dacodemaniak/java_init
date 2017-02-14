/**
 * 
 */
package com.webprojet.fete;

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
		
		/**
		 * Affichons donc le résultat...
		 */
		monAnniversaire.avertir();
		


	}

}
