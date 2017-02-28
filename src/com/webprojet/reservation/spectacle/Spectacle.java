/**
 * 
 */
package com.webprojet.reservation.spectacle;

import java.util.ArrayList;
import com.webprojet.reservation.spectateur.*;

/**
 * @author DaCodeManiak
 * @name Spectacle
 * 	Classe abstraite purement didactique, pour r�visions
 *
 */
public abstract class Spectacle {
	protected String titre;
	protected String description;
	protected int placesDisponibles;
	
	/**
	 * Collection des spectateurs pour un spectacle
	 */
	protected ArrayList<Personne> spectateurs;
	
	/**
	 * D�finition des diff�rents types de spectacle...
	 */
	public static final String[] TYPES = {"Opéra", "Théâtre"};
	
	public Spectacle(){
		this.spectateurs = new ArrayList<Personne>();
	}
	
	/**
	 * @return the titre
	 */
	public String titre() {
		return this.titre;
	}
	/**
	 * @param titre the titre to set
	 */
	public Spectacle titre(String titre) {
		this.titre = titre;
		return this;
	}
	/**
	 * @return the description
	 */
	public String description() {
		return this.description;
	}
	/**
	 * @param description the description to set
	 */
	public Spectacle description(String description) {
		this.description = description;
		return this;
	}
	/**
	 * @return the placesDisponibles
	 */
	public int placesDisponibles() {
		return this.placesDisponibles;
	}
	/**
	 * @param placesDisponibles the placesDisponibles to set
	 */
	public Spectacle placesDisponibles(int placesDisponibles) {
		this.placesDisponibles = placesDisponibles;
		return this;
	}
	
	public void hydrate(Personne personne){
		this.spectateurs.add(personne);
	}
	
	public int placesRestantes(){
		return this.placesDisponibles - this.spectateurs.size();
	}
	
}
