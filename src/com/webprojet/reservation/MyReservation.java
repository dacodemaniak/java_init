/**
 * 
 */
package com.webprojet.reservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.webprojet.reservation.spectacle.Opera;
import com.webprojet.reservation.spectacle.SaisieSpectacle;
import com.webprojet.reservation.spectacle.Spectacle;
import com.webprojet.reservation.spectacle.Theatre;

/**
 * @author DaCodeManiak
 * La définition de l'interface générale de l'application de gestion des Réservations
 *
 */
public class MyReservation {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Fenêtre principale de l'application...
		 */
		final JFrame fenetre = new JFrame("Réservations");
		
		/**
		 * Construction d'un tableau reprenant les titres des spectacles créés
		 *	- Un tableau de chaînes consistuant les colonnes du JTable
		 *	- un modèle DefaultTableModel à partir de ces colonnes
		 *	- le tableau lui-même
		 */
		String[] tableHeaders = {"Type", "Titre", "Description", "Nb. Places"};
		final DefaultTableModel modele = new DefaultTableModel(tableHeaders,0);
		JTable spectacles = new JTable(modele);
		
		/**
		 * Il faut ajouter notre tableau à la fenêtre elle-même
		**/
		fenetre.getContentPane().add(new JScrollPane(spectacles));
		
		/**
		 * Ajoutons une barre de menu : Fichier... par exemple
		 */
		JMenuBar menu = new JMenuBar();
		
		/**
		 * Ajoutons quelques menus à cette barre de menu
		 */
		JMenu menuFichier = new JMenu("Fichier");
		menu.add(menuFichier);
		
		/**
		 * Ajoutons quelques items au menu Fichier
		 */
		JMenuItem itemSpectacle = new JMenuItem("Nouveau spectacle", 'S');
		menuFichier.add(itemSpectacle);
		
		JMenuItem itemQuitter = new JMenuItem("Quitter", 'Q');
		menuFichier.add(itemQuitter);
		
		
		/**
		 * Il faut définir désormais quels sont les "listeners" à créer
		 * et quelles doivent être les actions à traiter lorsque l'événement
		 * surviendra sur l'élément "écouté"
		 *	1. Le plus facile, on va écouter l'option Quitter du menu Fichier
		 *		et lorsque cette option sera sélectionnée (actionPerformed)
		 *		on quittera l'application !
		 */
		itemQuitter.addActionListener(new ActionListener(){
				/**
				 * Implémentation de la méthode actionPerformed() définie dans
				 * l'interface ActionListener
				 */
				public void actionPerformed(ActionEvent event){
					// Si tu cliques sur l'option Quitter... on termine l'application
					System.exit(0);
				}
		});
		
		/**
		 * Le codage de l'option Nouveau Spectacle...
		 * On informe Java qu'on veut qu'il écoute ce qui se passe sur cette option
		 * 	et on définit ce qui doit se passer si l'action est définie
		 * 	L'utilisateur a cliqué sur l'option du menu concernée
		 */
		itemSpectacle.addActionListener(new ActionListener(){
				// Implémentation de la méthode actionPerformed définie dans l'interface
				public void actionPerformed(ActionEvent event){
					// Instanciation du formulaire de saisie des spectacles
					SaisieSpectacle formulaire = new SaisieSpectacle();
					
					// On récupère la réponse utilisateur au dialogue créé
					int responseUtilisateur = JOptionPane.showConfirmDialog(fenetre, 
							formulaire,
							"Nouveau Spectacle",
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.PLAIN_MESSAGE
					);
					
					// En fonction de la réponse utilisateur...
					if(responseUtilisateur == JOptionPane.OK_OPTION){
						Object spectacle = null;
						String type;
						
						// Intégrer le choix fait par l'utilisateur dans le combo
						if(formulaire.typeSelectionne().equals("Opéra")){
							spectacle = new Opera();
							type = "Opéra";
						} else {
							spectacle = new Theatre();
							type = "Théâtre";
						}
						
						((Spectacle) spectacle).titre(formulaire.titreSaisi())
							.description(formulaire.descriptionSaisie())
							.placesDisponibles(formulaire.placesSaisies());
						
						// Il faudrait arriver à l'afficher dans le tableau maintenant
						modele.addRow(new String[] {type, ((Spectacle)spectacle).titre(), ((Spectacle)spectacle).description(), String.format("%d", ((Spectacle)spectacle).placesDisponibles())});
							
					}
				}
			}
		);
		/**
		 * On n'oublie pas d'ajouter aussi à la fenêtre notre barre de menu
		 */
		fenetre.setJMenuBar(menu);
		
		fenetre.setSize(1024, 768);
		fenetre.setVisible(true);
	}

}
