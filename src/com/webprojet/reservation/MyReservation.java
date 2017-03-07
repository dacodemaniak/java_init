/**
 * 
 */
package com.webprojet.reservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.webprojet.persistence.mysql.MySQL;
import com.webprojet.reservation.billetterie.Reservation;
import com.webprojet.reservation.billetterie.Reservations;
import com.webprojet.reservation.spectacle.Opera;
import com.webprojet.reservation.spectacle.SaisieSpectacle;
import com.webprojet.reservation.spectacle.Spectacle;
import com.webprojet.reservation.spectacle.Spectacles;
import com.webprojet.reservation.spectacle.Theatre;
import com.webprojet.reservation.spectateur.Personne;
import com.webprojet.reservation.spectateur.SaisieAcheteur;
import com.webprojet.reservation.util.ReservationSetup;

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
		 * On peut utiliser la base de données "reservation"
		 */
		ReservationSetup setup = new ReservationSetup();
		
		MySQL base = new MySQL(setup);
		
		/**
		 * On arrête tout ici si on n'a pas réussi à se connecter
		 */
		if(base.get() == null){
			System.exit(0);
		}
		
		/**
		 * Définit la collection des spectacles créés
		 */
		Spectacles programmation = new Spectacles();
		
		/**
		 * Définit la collection des réservations réalisées
		 */
		Reservations reservations = new Reservations();
		
		/**
		 * Construction d'un tableau reprenant les titres des spectacles créés
		 *	- Un tableau de chaînes consistuant les colonnes du JTable
		 *	- un modèle DefaultTableModel à partir de ces colonnes
		 *	- le tableau lui-même
		 */
		String[] tableHeaders = {"Type", "Titre", "Description", "Nb. Places"};
		final DefaultTableModel modele = programmation.hydrate(tableHeaders);
		
		/**
		 * Construire un tableau avec les réservations existantes...
		 * - Nom du spectacle, Nom et prénom de l'acheteur
		**/
		String[] resaHeaders = {"Spectacle", "Acheteur"};
		final DefaultTableModel resaModele = reservations.hydrate(resaHeaders);
		
		/**
		 * A implémenter ce week-end...
		String[] resaHeaders = {"Nom", "Prénom", "Places", "Spectacle"};
		final DefaultTableModel resa = Reservations.hydrate(resaHeaders);
		**/
		JTable spectacles = new JTable(modele);
		JTable tabResa = new JTable(resaModele);
		
		/**
		 * Définition des composants affichés
		 */
		final JScrollPane componentSpectacle = new JScrollPane(spectacles);
		final JScrollPane componentReservation = new JScrollPane(tabResa);
		
		/**
		 * Il faut ajouter notre tableau à la fenêtre elle-même
		**/
		componentSpectacle.setSize(1024, 768);
		componentSpectacle.setVisible(true);
		fenetre.getContentPane().add(componentSpectacle);
		
		/**
		 * Ajouter aussi le tableau des réservations à la fenêtre
		 */
		componentReservation.setVisible(false);
		fenetre.getContentPane().add(componentReservation);
		
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
					base.disconnect(); // On coupe aussi la connexion
					System.exit(0);
				}
		});
		
		itemReservation.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				/**
				 * switch des composants affichés
				 */
				componentSpectacle.setVisible(false); // Masquer le tableau des spectacles
				
				componentReservation.setSize(1024,768);
				componentReservation.setVisible(true);
				
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
					//1. Créons une nouvelle réservation... dans la base de données
					// ATTENTION, on doit pouvoir récupérer l'id du spectacle à partir
					// de la chaîne de caractères...
					
					// Création de l'instance d'une Personne : acheteur à partir des informations saisies par l'utilisateur
					Personne personne = new Personne(
							acheteur.getSaisieNom(),
							acheteur.getSaisiePrenom(),
							acheteur.getSaisieEmail(),
							acheteur.getSaisieAdresse()
					);
					// En plus, c'est lui l'acheteur...
					personne.isAcheteur(true);
					
					// Il faut que je récupère une instance du spectacle concerné...
					Spectacle spectacle = Spectacle.get(acheteur.getSelectionSpectacle());
					Reservation reservation = new Reservation(spectacle, personne);
					
					// On peut faire persister tout ce beau monde...
					reservation.persist();
					
					// Ajouter la réservation à la liste des réservations
					reservations.add(reservation);
					
					// Ajoute les informations au composant Tableau
					resaModele.addRow(new String[] {reservation.getSpectacle().titre(), reservation.getPersonne().personneName()});
					// L'utilisateur a validé... on fait quoi ?
					JOptionPane.showMessageDialog(fenetre, "La réservation a bien été créée");
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
					/**
					 * Switcher l'affichage des tableaux...
					 */
					componentReservation.setVisible(false);
					componentSpectacle.setSize(1024, 768);
					componentSpectacle.setVisible(true);
					
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
						//programmation.spectacles().add((Spectacle) spectacle);
						
						// New Way...
						programmation.add((Spectacle) spectacle);
						
						// Ce qui serait bien... serait aussi de l'insérer en base de données
						
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
