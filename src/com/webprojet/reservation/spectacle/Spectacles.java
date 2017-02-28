/**
 * 
 */
package com.webprojet.reservation.spectacle;

import java.util.ArrayList;

import javax.swing.JComboBox;

/**
 * @author DaCodeManiak
 * @name Spectacles.java : Collectionne les objets de type Spectacle
 */
public class Spectacles {
	private ArrayList<Spectacle> spectacles = new ArrayList<Spectacle>();
	
	/**
	 * getter pour retourner la liste des spectacles
	 * @return ArrayList
	 */
	public ArrayList<Spectacle> spectacles(){
		return this.spectacles;
	}
	
	/**
	 * Méthode qui retourne si oui ou non il y a des éléments dans la collection
	 * @return boolean
	 */
	public boolean hasElements(){
		return this.spectacles.size() > 0;
		//return this.spectacles.size() > 0 ? true : false;
	}
	
	public JComboBox<String> getCombo(JComboBox<String> combo){
		String comboLigne;
		
		for(Spectacle spectacle : this.spectacles){
			if(spectacle.placesRestantes() > 0){
				if(spectacle instanceof Opera){
					comboLigne = "(Opéra) " +  spectacle.titre();
				} else {
					comboLigne = "(Théâtre) " + spectacle.titre();
				}
				comboLigne += " [" + spectacle.placesRestantes() + "]";
				
				combo.addItem(comboLigne);
			}
		}
		return combo;
	}
}
