/**
 * 
 */
package com.webprojet.reservation.spectateur;

import javax.swing.JOptionPane;

/**
 * @author DaCodeManiak
 * Affiche le formulaire de saisie d'un spectacle dans un dialogue
 *
 */
public class NewPersonne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Instancie un nouveau formulaire pour la saisie de la d�finition
		 * d'un spectacle (titre, description)
		 */
		SaisiePersonne formulaire = new SaisiePersonne();
		
		int reponseUtilisateur = JOptionPane.showConfirmDialog(
				null, formulaire.process(), "Accompagnant",JOptionPane.PLAIN_MESSAGE
			);
		if(reponseUtilisateur == JOptionPane.OK_OPTION){
			// L'utilisateur a cliqué sur le bouton OK, on affiche juste les données
			// saisies par l'utilisateur
			JOptionPane.showMessageDialog(null, "Accompagnant : " +
					formulaire.getSaisieNom() + "\n" +
					formulaire.getSaisiePrenom() + "\n"
			);
			
		}
		
		// Saisie d'un acheteur
		SaisieAcheteur formAcheteur = new SaisieAcheteur();
		reponseUtilisateur = JOptionPane.showConfirmDialog(
				null, formAcheteur.process(), "Acheteur",JOptionPane.PLAIN_MESSAGE
			);
		if(reponseUtilisateur == JOptionPane.OK_OPTION){
			// L'utilisateur a cliqué sur le bouton OK, on affiche juste les données
			// saisies par l'utilisateur
			JOptionPane.showMessageDialog(null, "Acheteur : " +
					formAcheteur.getSaisieNom() + "\n" +
					formAcheteur.getSaisiePrenom() + "\n" +
					formAcheteur.getSaisieEmail() + "\n" +
					formAcheteur.getSaisieAdresse()
			);
			
			System.exit(0); // On stoppe la machine virtuelle ici... pour l'instant
		}		
	}

}
