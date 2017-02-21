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
	
	public void newDate(){
		GregorianCalendar dateRef = new GregorianCalendar();
		if(this.simpleDate.before(dateRef)){
			// Il faut que j'ajoute une année...
			int anneeProchaine = dateRef.get(GregorianCalendar.YEAR);
			anneeProchaine++;
			this.simpleDate.set(GregorianCalendar.YEAR, anneeProchaine);
			// Ne pas oublier de ré-affecter l'attribut Date date
			this.date = this.simpleDate.getTime();
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
		return 0;
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
