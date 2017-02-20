/**
 * 
 */
package com.webprojet.agence.biens;

import java.util.Date;
import java.util.GregorianCalendar;

import com.webprojet.agence.adresse.Adresse;
import com.webprojet.agence.personne.Personne;

/**
 * @author DaCodeManiak
 *
 */
public class Bien {
	protected double prixNetVendeur;
	protected double prixDeVente;
	protected Adresse adresse;
	protected Personne vendeur;
	protected float surface;
	protected GregorianCalendar anneeConstruction;
	/**
	 * @return the prixNetVendeur
	 */
	public double prixNetVendeur() {
		return this.prixNetVendeur;
	}
	/**
	 * @param prixNetVendeur the prixNetVendeur to set
	 */
	public Bien prixNetVendeur(double prixNetVendeur) {
		this.prixNetVendeur = prixNetVendeur;
		return this;
	}
	/**
	 * @return the prixDeVente
	 */
	public double prixDeVente() {
		return this.prixDeVente;
	}
	/**
	 * @param prixDeVente the prixDeVente to set
	 */
	public Bien prixDeVente(double prixDeVente) {
		this.prixDeVente = prixDeVente;
		return this;
	}
	/**
	 * @return the adresse
	 */
	public Adresse adresse() {
		return this.adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public Bien adresse(Adresse adresse) {
		this.adresse = adresse;
		return this;
	}
	/**
	 * @return the vendeur
	 */
	public Personne vendeur() {
		return this.vendeur;
	}
	/**
	 * @param vendeur the vendeur to set
	 */
	public Bien vendeur(Personne vendeur) {
		this.vendeur = vendeur;
		return this;
	}
	/**
	 * @return the surface
	 */
	public float surface() {
		return this.surface;
	}
	/**
	 * @param surface the surface to set
	 */
	public Bien surface(float surface) {
		this.surface = surface;
		return this;
	}
	/**
	 * @return the anneeConstruction
	 */
	public GregorianCalendar anneeConstruction() {
		return this.anneeConstruction;
	}
	/**
	 * @param anneeConstruction the anneeConstruction to set
	 */
	public Bien anneeConstruction(GregorianCalendar anneeConstruction) {
		this.anneeConstruction = anneeConstruction;
		return this;
	}
	
	
}
