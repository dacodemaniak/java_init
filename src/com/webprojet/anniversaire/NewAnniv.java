/**
 * 
 */
package com.webprojet.anniversaire;

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import com.webprojet.anniversaire.utils.SmartDate;

/**
 * @author DaCodeManiak
 *
 */
public class NewAnniv {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String date = JOptionPane.showInputDialog("Date d'anniversaire (jj/mm) :");
		
		// Découpe la chaîne pour récupérer le jour et le mois
		int positionSlash = date.indexOf('/');
		String jour = date.substring(0, positionSlash);
		String mois = date.substring(positionSlash + 1);
		
		// On détermine la date du jour...
		SmartDate dateDuJour = new SmartDate(new GregorianCalendar());
		//dateDuJour.setLocale("en");
		System.out.println("Date du jour : " + dateDuJour.humanizeDate());
		
		// A partir de la saisie utilisateur, on détermine la date d'anniversaire
		SmartDate anniversaire = new SmartDate(new GregorianCalendar(
				dateDuJour.get(GregorianCalendar.YEAR), // Année courante
				Integer.parseInt(mois) - 1, // Attention, les mois Java commencent à 0
				Integer.parseInt(jour)) // le jour saisi par l'utilisateur
			);
		System.out.println("Anniversaire : " + anniversaire.humanizeDate());
		
		// Juste pour comparer :
		System.out.println("Jour : " + dateDuJour.get(GregorianCalendar.MILLISECOND));
		System.out.println("Anniversaire : " + anniversaire.get(GregorianCalendar.MILLISECOND));
		
		// Comparaison de deux objets de même type...
		if(anniversaire.equals(dateDuJour)){
			System.out.println("Excellent anniversaire !!!");
		} else {
			System.out.println("Il va falloir attendre un peu...");
			// Demander à recalculer la prochaine date d'anniversaire... le cas échéant
			anniversaire.newDate(true);
			
			System.out.println("... jusqsu'au : " + anniversaire.humanizeDate());
		}
	}

}
