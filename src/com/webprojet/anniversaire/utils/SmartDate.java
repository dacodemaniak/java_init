/**
 * 
 */
package com.webprojet.anniversaire.utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author DaCodeManiak
 * 	Service de conversion et de traitement des dates...
 *
 */
public class SmartDate {
	private DateFormat dateFormat;
	private Date date;
	private GregorianCalendar simpleDate;
	private int nbJoursRestants;
	
	public SmartDate(GregorianCalendar date){
		this.simpleDate = date;
		
		// Par défaut, on utilisera un format DateFormat.FULL
		this.dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		
		// Dans la foulée, autant que je puisse "convertir" simpleDate en Date
		this.date = this.simpleDate.getTime();
	}
	
	public void setLocale(String code){
		Locale.setDefault(new Locale(code, code.toUpperCase()));
	}
	
	public Date getDate(){
		return this.date;
	}
	
	/**
	 * La méthode "equals" existe dans toutes les classes Java et peut être
	 * redéfinie...
	 * @param date
	 * @return
	 */
	public boolean equals(SmartDate date){
		return (this.simpleDate.get(GregorianCalendar.DAY_OF_YEAR) - date.get(GregorianCalendar.DAY_OF_YEAR) == 0) ? true : false;
	}
	
	public int nbJoursRestants(){
		return this.nbJoursRestants;
	}
	
	/**
	 * Calcule la date du prochain anniversaire et définit le nombre de jours
	 * restants.
	 */
	public void newDate(){
		GregorianCalendar dateRef = new GregorianCalendar();
		if(this.simpleDate.before(dateRef)){
			// Il faut que j'ajoute une année...
			int anneeProchaine = dateRef.get(GregorianCalendar.YEAR);
			anneeProchaine++;
			this.simpleDate.set(GregorianCalendar.YEAR, anneeProchaine);
			// Ne pas oublier de ré-affecter l'attribut Date date
			this.date = this.simpleDate.getTime();
			
			// Détermine le nombre de jours restants par le calcul suivant :
			// Nombre de jours restants jusqu'au 31 déc. de l'année N
			// + Nombre de jours entre le début de l'année suivante et l'anniversaire
			int untilDec31 = 0;
			
			GregorianCalendar nextDec31 = new GregorianCalendar(
					dateRef.get(GregorianCalendar.YEAR),
					GregorianCalendar.DECEMBER,
					31
			);
			// Au final, on fait le calcul...
			this.nbJoursRestants = this.simpleDate.get(GregorianCalendar.DAY_OF_YEAR)
					+ (nextDec31.get(GregorianCalendar.DAY_OF_YEAR)
							- dateRef.get(GregorianCalendar.DAY_OF_YEAR)
			);
		} else {
			// Détermine le nombre de jours restants, simplement
			this.nbJoursRestants = this.simpleDate.get(GregorianCalendar.DAY_OF_YEAR) - dateRef.get(GregorianCalendar.DAY_OF_YEAR);
		}
	}
	
	public void newDate(boolean shorter){
		if(this.simpleDate.before(new GregorianCalendar())){
			int anneeProchaine = this.simpleDate.get(GregorianCalendar.YEAR) + 1;
			this.simpleDate.set(GregorianCalendar.YEAR, anneeProchaine);
			this.date = this.simpleDate.getTime();
		}
	}
	
	/**
	 * Doit retourner le nombre de jours à attendre avant mon anniversaire
	 * ATTENTION aux années bissextiles...
	 * @return
	 */
	public int attendre(){
		return this.nbJoursRestants;
	}
	
	/**
	 * Retourne la date dans un format "humain"
	 * @return
	 */
	public String humanizeDate(){
		return this.dateFormat.format(this.date);
	}

	public int get(int what) {
		return this.simpleDate.get(what);
	}
	
}
