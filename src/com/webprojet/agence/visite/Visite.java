package com.webprojet.agence.visite;

import java.util.GregorianCalendar;

import com.webprojet.agence.biens.Appartement;
import com.webprojet.agence.biens.Bien;
import com.webprojet.agence.biens.Maison;
import com.webprojet.agence.personne.Personne;

public class Visite {
	protected GregorianCalendar date;
	protected Personne personne;
	protected Bien bien;
	
	public Visite(GregorianCalendar date, Bien bien, Personne personne){
		this.date = date;
		this.bien = bien;
		this.personne = personne;
	}
	
	public String date(){
		return this.date.get(GregorianCalendar.DATE) 
				+ "/" 
				+ (this.date.get(GregorianCalendar.MONTH) + 1)
				+ "/"
				+ this.date.get(GregorianCalendar.YEAR);
	}
	
	public String getPersonne(){
		return this.personne.nom() + " " + this.personne.prenom();
	}
	
	public String getBien(){
		String type;
		
		if(this.bien instanceof Appartement){
			type = "Appartement : " + ((Appartement) this.bien).type();
		} else {
			type = "Maison " + ((Maison) this.bien).terrain();
		}
		
		return type + " : " + this.bien.adresse().ville();
	}
}
