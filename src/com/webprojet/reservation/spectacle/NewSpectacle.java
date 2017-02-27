/**
 * 
 */
package com.webprojet.reservation.spectacle;

import javax.swing.JOptionPane;

/**
 * @author DaCodeManiak
 * Affiche le formulaire de saisie d'un spectacle dans un dialogue
 *
 */
public class NewSpectacle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Instancie un nouveau formulaire pour la saisie de la définition
		 * d'un spectacle (titre, description)
		 */
		SaisieSpectacle formulaire = new SaisieSpectacle();
		
		int reponseUtilisateur = JOptionPane.showConfirmDialog(
				null, formulaire, "Spectacle",JOptionPane.PLAIN_MESSAGE
			);
		if(reponseUtilisateur == JOptionPane.OK_OPTION){
			// L'utilisateur a cliqué sur le bouton OK, on affiche juste les données
			// saisies par l'utilisateur
			JOptionPane.showMessageDialog(null, "Spectacle : " +
					formulaire.titreSaisi() + "\n" +
					formulaire.descriptionSaisie() + "\n" +
					formulaire.placesSaisies()
			);
			
			System.exit(0); // On stoppe la machine virtuelle ici... pour l'instant
		}

	}

}
