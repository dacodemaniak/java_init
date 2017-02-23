/**
 * 
 */
package com.webprojet.resto;

import java.util.GregorianCalendar;

/**
 * @author DaCodeManiak
 *
 */
public class Entree extends Composition implements Payant {
	
	public Entree(String nom, float prix){
		this.nom = nom;
		this.prix = prix;
	}
	
	public void majoration(){
		GregorianCalendar pm = new GregorianCalendar();
		
		int hour = pm.get(GregorianCalendar.HOUR);
		int amOrPm = pm.get(GregorianCalendar.AM_PM);
		
		if(hour > 2 && amOrPm == GregorianCalendar.PM){
			// On applique une majoration de n%
			this.prix = this.prix + ((this.prix * 15) / 100);
		}
	}
	
	public float getPrix(){
		this.majoration();
		return this.prix;
	}
	
	
}
