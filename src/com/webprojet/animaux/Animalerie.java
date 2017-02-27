/**
 * 
 */
package com.webprojet.animaux;

import javax.swing.JOptionPane;

/**
 * @author DaCodeManiak
 *
 */
public class Animalerie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Créons un gentil chien
		Chien monChien = new Chien();
		monChien.race("Beauceron");
		JOptionPane.showMessageDialog(null, monChien, "Mon chien", JOptionPane.PLAIN_MESSAGE);
		
		Araignee epeire = new Araignee();
		JOptionPane.showMessageDialog(null, epeire, "Araignée", JOptionPane.PLAIN_MESSAGE);
		
		System.out.println(monChien.isAnimalDeCompagnie() ? "Animal de compagnie" : "Pas un animal de compagnie");
	}

}
