/**
 * 
 */
package com.webprojet.anniversaire;

import javax.swing.JOptionPane;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author DaCodeManiak
 *
 */
public class Anniversaire {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String date = JOptionPane.showInputDialog("Date d'anniversaire (jj/mm) :");
		System.out.println("Jour et mois : " + date);
		
		// Question ? Comment passer d'une cha�ne de caract�res � une date ?
		int positionSlash = date.indexOf('/');
		String jour = date.substring(0, positionSlash);
		String mois = date.substring(positionSlash + 1);
		
		// On d�termine la date du jour...
		GregorianCalendar dateDuJour = new GregorianCalendar();
		// Afficher la date du jour... (21 1 2017)
		System.out.println(dateDuJour.get(GregorianCalendar.DAY_OF_MONTH) + 
		"-" + (dateDuJour.get(GregorianCalendar.MONTH) + 1) + "-" + dateDuJour.get(GregorianCalendar.YEAR));
		
		// On d�termine � partir de l�, la date d'anniversaire pour l'ann�e courante
		GregorianCalendar anniversaire = new GregorianCalendar(
			dateDuJour.get(GregorianCalendar.YEAR), // Ann�e courante
			Integer.parseInt(mois) - 1, // Attention, les mois Java commencent � 0
			Integer.parseInt(jour) // le jour saisi par l'utilisateur
		);
		System.out.println("Date d'anniversaire : " +
			anniversaire.get(GregorianCalendar.DAY_OF_MONTH) + "-" +
			(anniversaire.get(GregorianCalendar.MONTH) + 1) + "-" +
			anniversaire.get(GregorianCalendar.YEAR)
		);
		
		// Est-ce que la diff�rence de jours entre les deux dates est �gale � 0 ?
		int joursRestant = anniversaire.get(GregorianCalendar.DAY_OF_YEAR) - dateDuJour.get(GregorianCalendar.DAY_OF_YEAR);
		
		if(joursRestant == 0){
			System.out.println("Bon anniversaire !!!");
		} else {
			System.out.println("Il va falloir patienter avant votre anniversaire");
			if(anniversaire.before(dateDuJour)){
				// L'anniversaire est d�j� pass�, donc... on se retrouve l'ann�e prochaine
				anniversaire.set(GregorianCalendar.YEAR, (dateDuJour.get(GregorianCalendar.YEAR) + 1));
			}
			// Si vous voulez afficher en Anglais, ou en Allemand... ou en Vietnamien
			Locale.setDefault(new Locale("fr", "FR"));
			
			// On d�finit comment on veut "rendre" la date du prochain anniversaire
			DateFormat formatDate = DateFormat.getDateInstance(DateFormat.FULL);
			// Malheureusement, DateFormat ne peut s'appliquer qu'� un type Date
			// Il faut donc d�finir un nouvel objet de type Date � partir de la date d'anniversaire (m�thode getTime())
			Date dateProchainAnniversaire = anniversaire.getTime();
			// Il faut que je puisse r�cup�rer (et afficher) en clair, la date du prochain anniversaire

			String happyNextBirthday = formatDate.format(dateProchainAnniversaire);
			// On peut d�sormais afficher facilement la date du prochain anniversaire
			System.out.println("... qui aura lieu pr�cis�ment le " + happyNextBirthday);
		}
		
	}

}
