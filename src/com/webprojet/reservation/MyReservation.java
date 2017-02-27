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
 * La d�finition de l'interface g�n�rale de l'application de gestion des R�servations
 *
 */
public class MyReservation {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Fen�tre principale de l'application...
		 */
		final JFrame fenetre = new JFrame("R�servations");
		
		/**
		 * Construction d'un tableau reprenant les titres des spectacles cr��s
		 *	- Un tableau de cha�nes consistuant les colonnes du JTable
		 *	- un mod�le DefaultTableModel � partir de ces colonnes
		 *	- le tableau lui-m�me
		 */
		String[] tableHeaders = {"Type", "Titre", "Description", "Nb. Places"};
		final DefaultTableModel modele = new DefaultTableModel(tableHeaders,0);
		JTable spectacles = new JTable(modele);
		
		/**
		 * Il faut ajouter notre tableau � la fen�tre elle-m�me
		**/
		fenetre.getContentPane().add(new JScrollPane(spectacles));
		
		/**
		 * Ajoutons une barre de menu : Fichier... par exemple
		 */
		JMenuBar menu = new JMenuBar();
		
		/**
		 * Ajoutons quelques menus � cette barre de menu
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
		 * Il faut d�finir d�sormais quels sont les "listeners" � cr�er
		 * et quelles doivent �tre les actions � traiter lorsque l'�v�nement
		 * surviendra sur l'�l�ment "�cout�"
		 *	1. Le plus facile, on va �couter l'option Quitter du menu Fichier
		 *		et lorsque cette option sera s�lectionn�e (actionPerformed)
		 *		on quittera l'application !
		 */
		itemQuitter.addActionListener(new ActionListener(){
				/**
				 * Impl�mentation de la m�thode actionPerformed() d�finie dans
				 * l'interface ActionListener
				 */
				public void actionPerformed(ActionEvent event){
					// Si tu cliques sur l'option Quitter... on termine l'application
					System.exit(0);
				}
		});
		
		/**
		 * Le codage de l'option Nouveau Spectacle...
		 * On informe Java qu'on veut qu'il �coute ce qui se passe sur cette option
		 * 	et on d�finit ce qui doit se passer si l'action est d�finie
		 * 	L'utilisateur a cliqu� sur l'option du menu concern�e
		 */
		itemSpectacle.addActionListener(new ActionListener(){
				// Impl�mentation de la m�thode actionPerformed d�finie dans l'interface
				public void actionPerformed(ActionEvent event){
					// Instanciation du formulaire de saisie des spectacles
					SaisieSpectacle formulaire = new SaisieSpectacle();
					
					// On r�cup�re la r�ponse utilisateur au dialogue cr��
					int responseUtilisateur = JOptionPane.showConfirmDialog(fenetre, 
							formulaire,
							"Nouveau Spectacle",
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.PLAIN_MESSAGE
					);
					
					// En fonction de la r�ponse utilisateur...
					if(responseUtilisateur == JOptionPane.OK_OPTION){
						Object spectacle = null;
						String type;
						
						// Int�grer le choix fait par l'utilisateur dans le combo
						if(formulaire.typeSelectionne().equals("Op�ra")){
							spectacle = new Opera();
							type = "Op�ra";
						} else {
							spectacle = new Theatre();
							type = "Th��tre";
						}
						
						((Spectacle) spectacle).titre(formulaire.titreSaisi())
							.description(formulaire.descriptionSaisie())
							.placesDisponibles(formulaire.placesSaisies());
						
						// Il faudrait arriver � l'afficher dans le tableau maintenant
						modele.addRow(new String[] {type, ((Spectacle)spectacle).titre(), ((Spectacle)spectacle).description(), String.format("%d", ((Spectacle)spectacle).placesDisponibles())});
							
					}
				}
			}
		);
		/**
		 * On n'oublie pas d'ajouter aussi � la fen�tre notre barre de menu
		 */
		fenetre.setJMenuBar(menu);
		
		fenetre.setSize(1024, 768);
		fenetre.setVisible(true);
	}

}
