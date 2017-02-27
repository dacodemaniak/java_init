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
	 * Numéro d'une réservation : référence à imprimer...
	 */
	private String numero;
	
	/**
	 * L'objet représentant le spectacle concerné par la réservation
	 */
	private Spectacle spectacle; 
	
	/**
	 * L'objet représentant la personne qui fait la réservation
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
