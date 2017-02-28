/**
 * 
 */
package com.webprojet.reservation.spectateur;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

/**
 * @author DaCodeManiak
 * Classe parente pour la saisie des personnes...
 * Classe fille sera SaisieAcheteur (avec email et adresse en plus)...
 *
 */
public class SaisiePersonne extends JPanel {
	/**
	 * Attribut protégé pour pouvoir être aussi disponible
	 * dans les classes filles.
	 */
	protected JTextField saisieNom = new JTextField(30);
	protected JTextField saisiePrenom = new JTextField(30);
	
	/**
	 * Définit les attributs pour les zones de stockage des composants
	 */
	protected JPanel divLabel;
	protected JPanel divField;
	
	protected String[] labels = {"Nom", "Prénom"};
	
	/**
	 * Pour faciliter la conception dynamique de la grille de saisie
	 * en fonction du nombre de champs à afficher
	 */
	protected GridLayout grille;
	
	public SaisiePersonne(){
		
	}
	
	/**
	 * Cette méthode fait le job, après que tout ait été initialisé !
	 * @return
	 */
	public SaisiePersonne process(){
		this.makeForm();
		return this;
	}
	
	/**
	 * @return the saisieNom
	 */
	public String getSaisieNom() {
		return this.saisieNom.getText();
	}

	/**
	 * @return the saisiePrenom
	 */
	public String getSaisiePrenom() {
		return this.saisiePrenom.getText();
	}

	/**
	 * Méthode protégée qui permet de définir le formulaire dans son intégralité
	 */
	protected void makeForm(){
		this.makeLabels(); // Sinon, pas de labels...
		this.makeInputs(); // Sinon, pas de champs
		
		setLayout(new BorderLayout(5,5)); // setLayout méthode statique de awt
		add(this.divLabel, BorderLayout.WEST);
		add(this.divField, BorderLayout.CENTER);		
	}
	
	/**
	 * Fabrique les labels en fonction de ce qui existe dans l'attribut labels
	 */
	private void makeLabels(){
		this.grille = new GridLayout(this.labels.length, 1, 5, 5);
		this.divLabel = new JPanel(this.grille);
		
		// On peut donc "ajouter" les labels en fonction du tableau des labels
		for(int indice = 0; indice < this.labels.length; indice++){
			this.divLabel.add(new JLabel(this.labels[indice]));
		}
	}
	
	/**
	 * Méthode protégée pour pouvoir être réécrite dans les classes filles
	 */
	protected void makeInputs(){
		this.grille = new GridLayout(this.labels.length, 1, 5, 5);
		this.divField = new JPanel(this.grille);
		
		// On ajoute les champs dans la grille
		this.divField.add(this.saisieNom);
		this.divField.add(this.saisiePrenom);
	}
	
}
