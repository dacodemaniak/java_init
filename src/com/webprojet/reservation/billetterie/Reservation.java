/**
 * 
 */
package com.webprojet.reservation.billetterie;

import com.webprojet.reservation.spectacle.Spectacle;
import com.webprojet.reservation.spectateur.Personne;

/**
 * @author DaCodeManiak
 *
 */
public class Reservation {
	/**
	 * Num�ro d'une r�servation : r�f�rence � imprimer...
	 */
	private String numero;
	
	/**
	 * L'objet repr�sentant le spectacle concern� par la r�servation
	 */
	private Spectacle spectacle; 
	
	/**
	 * L'objet repr�sentant la personne qui fait la r�servation
	 */
	private Personne acheteur;
	
	public Reservation(Spectacle spectacle, Personne acheteur){
		this.spectacle = spectacle;
		this.acheteur = acheteur;
	}
	
	public boolean addPersonne(Personne personne){
		if(this.spectacle.placesRestantes() > 0){
			// C'est bon on peut ajouter la personne au spectacle
			this.spectacle.hydrate(personne);
			return true;
		}
		return false;
	}
	
	
	
}
