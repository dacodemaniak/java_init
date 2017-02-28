/**
 * 
 */
package com.webprojet.reservation.spectateur;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author DaCodeManiak
 *
 */
public class SaisieAcheteur extends SaisiePersonne {

	/**
	 * 
	 */
	protected JTextField saisieEmail = new JTextField(30);
	protected JTextArea saisieAdresse = new JTextArea(5,30);
	
	public SaisieAcheteur() {
		// Redéfinir le tableau des labels
		this.labels = new String[]{"Nom", "Prénom", "Email", "Adresse"};
		
	}

	public SaisieAcheteur process(){
		this.makeForm();
		return this;
	}
	
	/**
	 * @return the saisieEmail
	 */
	public String getSaisieEmail() {
		return this.saisieEmail.getText();
	}

	/**
	 * @return the saisieAdresse
	 */
	public String getSaisieAdresse() {
		return this.saisieAdresse.getText();
	}

	/**
	 * Méthode protégée pour pouvoir être réécrite dans les classes filles
	 */
	protected void makeInputs(){
		/**
		 * Le mot-clé super fait référence à la classe parente
		 * En PHP c'est "parent::"
		 * super.methode() => ça fait appel à la méthode "methode()" de la classe parente
		 * En PHP : parent::methode() fait appel à la méthode "methode()" de la classe parente
		 * Java : super() => constructeur de la classe parente
		 * PHP : parent::__construct() => constructeur de la classe parente
		 */
		super.makeInputs(); // Appelle la méthode parente...
		
		// On ajoute les deux champs dans la grille
		this.divField.add(this.saisieEmail);
		this.divField.add(this.saisieAdresse);
	}

	/* (non-Javadoc)
	 * @see com.webprojet.reservation.spectateur.SaisiePersonne#makeForm()
	 */
	@Override
	protected void makeForm() {
		// TODO Auto-generated method stub
		super.makeForm();
		
		// Ajoute le champ de saisie de l'adresse dans un ScrollPane
		add(new JScrollPane(this.saisieAdresse), BorderLayout.SOUTH);
	}
	
	

}
