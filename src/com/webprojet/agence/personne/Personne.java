/**
 * 
 */
package com.webprojet.agence.personne;

/**
 * @author DaCodeManiak
 *
 */
public class Personne {
	protected String nom;
	protected String prenom;
	/**
	 * @return the nom
	 */
	public String nom() {
		return this.nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public Personne nom(String nom) {
		this.nom = nom;
		return this;
	}
	/**
	 * @return the prenom
	 */
	public String prenom() {
		return this.prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public Personne prenom(String prenom) {
		this.prenom = prenom;
		return this;
	}
	
}
