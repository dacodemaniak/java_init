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
import com.webprojet.reservation.spectacle.Spectacles;
import com.webprojet.reservation.spectacle.Theatre;
import com.webprojet.reservation.spectateur.SaisieAcheteur;

/**
 * @author DaCodeManiak
 * La d�finition de l'interface g�n�rale de l'application de gestion des R�servations
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
		 * Définit la collection des spectacles créés
		 */
		Spectacles programmation = new Spectacles();
		
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
		
		/**
		 * Ajoutons l'option de menu pour créer une nouvelle réservation
		 * 	ATTENTION, ça ne sert à rien de positionner cette option si
		 * 	pour l'instant il n'y a pas de spectacles
		 *  Pour être plus "user friendly", peut être créer l'option mais ne pas
		 *  l'activer...
		 */
		JMenuItem itemReservation = new JMenuItem("Nouvelle réservation", 'R');
		itemReservation.setEnabled(programmation.hasElements());
		menuFichier.add(itemReservation);
		
		JMenuItem itemQuitter = new JMenuItem("Quitter", 'Q');
		menuFichier.add(itemQuitter);
		
		
		/**
		 * Il faut définir désormais quels sont les "listeners" à créer
		 * et quelles doivent être les actions à traiter lorsque l'événement
		 * surviendra sur l'élément écouté
		 *	1. Le plus facile, on va écouter l'option Quitter du menu Fichier
		 *		et lorsque cette option sera sélectionnée (actionPerformed)
		 *		on quittera l'application !
		 */
		itemQuitter.addActionListener(new ActionListener(){
				/**
				 * Implémentation de la méthode actionPerformed() définie
				 * l'interface ActionListener
				 */
				public void actionPerformed(ActionEvent event){
					// Si tu cliques sur l'option Quitter... on termine l'application
					System.exit(0);
				}
		});
		
		itemReservation.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				// Instancie l'objet Acheteur
				SaisieAcheteur acheteur = new SaisieAcheteur();
				acheteur.programmation(programmation);
				
				// Réponse de l'utilisateur
				int response = JOptionPane.showConfirmDialog(
						fenetre, // Pour pouvoir ouvrir la boîte au milieu de la fenêtre principale 
						acheteur.process(), // Création du formulaire
						"Nouvelle réservation", // Titre de la boîte de dialogue
						JOptionPane.OK_CANCEL_OPTION, // Boutons à afficher
						JOptionPane.PLAIN_MESSAGE // Aucune icône dans le dialogue
				);
				// En fonction de cette réponse...
				if(response == JOptionPane.OK_OPTION){
					// L'utilisateur a validé... on fait quoi ?
					JOptionPane.showMessageDialog(fenetre, "Oki, on est sorti !");
				}
			}
		});
		/**
		 * Le codage de l'option Nouveau Spectacle...
		 * On informe Java qu'on veut qu'il �coute ce qui se passe sur cette option
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
						
						// En plus, ajouter le nouveau spectacle à la collection des spectacles
						programmation.spectacles().add((Spectacle) spectacle);
						
						// C'est bon, on devrait réactiver l'option
						itemReservation.setEnabled(programmation.hasElements());
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
