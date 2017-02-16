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
	 * Tableau des personnes invit�es � l'instance courante de la f�te
	 */
	protected ArrayList<Personne> personnes;
	
	public Fete(){
		this.personnes = new ArrayList<Personne>();
	}
	
	/**
	 * D�finit le nom de l'organisateur
	 * @param organisateur String
	 * @return com.webprojet.fete.Fete
	 */
	public Fete organisateur(String organisateur){
		this.organisateur = organisateur;
		return this;
	}
	
	/**
	 * Retourne le nom de l'organisateur de la f�te
	 * @return String
	 */
	public String organisateur(){
		return this.organisateur;
	}
	
	/**
	 * D�finit le jour de la semaine pour la f�te
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
