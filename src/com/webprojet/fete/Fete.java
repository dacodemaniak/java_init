/**
 * 
 */
package com.webprojet.fete;

import java.util.ArrayList;

import com.webprojet.fete.personne.Personne;

/**
 * @author DaCodeManiak
 *
 */
public class Fete {
	/**
	 * @var organisateur String Nom de l'organisateur
	 */
	protected String organisateur;
	
	/**
	 * @var jourSemaine String jour de la semaine
	 */
	protected String jourSemaine;
	
	/**
	 * Tableau des personnes invitées à l'instance courante de la fête
	 */
	protected ArrayList<Personne> personnes;
	
	public Fete(){
		this.personnes = new ArrayList<Personne>();
	}
	
	/**
	 * Définit le nom de l'organisateur
	 * @param organisateur String
	 * @return com.webprojet.fete.Fete
	 */
	public Fete organisateur(String organisateur){
		this.organisateur = organisateur;
		return this;
	}
	
	/**
	 * Retourne le nom de l'organisateur de la fête
	 * @return String
	 */
	public String organisateur(){
		return this.organisateur;
	}
	
	/**
	 * Définit le jour de la semaine pour la fête
	 * @param jourSemaine
	 * @return com.webprojet.fete.Fete
	 */
	public Fete jourSemaine(String jourSemaine){
		this.jourSemaine = jourSemaine;
		return this;
	}
	
	/**
	 * Retourne le jour de la semaine
	 * @return String
	 */
	public String jourSemaine(){
		return this.jourSemaine;
	}
	
	public void inviter(Personne invite){
		this.personnes.add(invite);
	}
	
}
