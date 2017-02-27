/**
 * 
 */
package com.webprojet.reservation.spectacle;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author DaCodeManiak
 * D�finition de l'interface pour la saisie des spectacles
 * Titre, Description...
 *
 */
public class SaisieSpectacle extends JPanel {
	/**
	 * D�finition des attributs du formulaire
	 */
	private JComboBox selectionType = new JComboBox(Spectacle.TYPES);
	private JTextField saisieTitre = new JTextField(30);
	private JTextArea saisieDescription = new JTextArea(5,30);
	private JFormattedTextField saisiePlaces = new JFormattedTextField("###");
	
	public SaisieSpectacle(){
		/**
		 * Premier "panel", grille de 2 lignes, 1 colonne, 5 pixels entre les composants
		 */
		JPanel panneauLabels = new JPanel(new GridLayout(4, 1, 5, 5));
		/**
		 * On ajoute des "labels" � ce panneau
		 */
		panneauLabels.add(new JLabel("Type :"));
		panneauLabels.add(new JLabel("Titre :"));
		panneauLabels.add(new JLabel("Pr�sentation :"));
		panneauLabels.add(new JLabel("Places disponibles :"));
		
		/**
		 * Construit la colonne avec les zones de saisie
		 */
		JPanel panneauSaisie = new JPanel(new GridLayout(4, 1, 5, 5));
		panneauSaisie.add(this.selectionType); // Ajoute la liste d�roulante
		panneauSaisie.add(this.saisieTitre);
		panneauSaisie.add(this.saisieDescription);
		panneauSaisie.add(this.saisiePlaces);
		
		/**
		 * ATTENTION... les panneaux doivent �tre int�gr�s dans la fen�tre
		 */
		setLayout(new BorderLayout(5,5)); // setLayout m�thode statique de awt
		add(panneauLabels, BorderLayout.WEST);
		add(panneauSaisie, BorderLayout.CENTER);
		add(new JScrollPane(this.saisieDescription), BorderLayout.SOUTH);
	}
	
	/**
	 * M�thode pour r�cup�rer la saisie utilisateur dans le champ saisieTitre
	 * @return
	 */
	public String titreSaisi(){
		return this.saisieTitre.getText();
	}
	
	public String descriptionSaisie(){
		return this.saisieDescription.getText();
	}
	
	public int placesSaisies(){
		return Integer.parseInt(this.saisiePlaces.getText());
	}
	
	public String typeSelectionne(){
		return (String) this.selectionType.getSelectedItem();
	}
}
