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
	protected boolean isVendu = false;
	protected String description;
	
	/**
	 * Définir une constante qui contiendra le point de suite...
	 */
	private final String CHAINE_SUITE = "[+]";
	
	public boolean isVendu(){
		return this.isVendu;
	}
	
	public Bien isVendu(boolean isVendu){
		this.isVendu = isVendu;
		return this;
	}
	
	public Bien description(String description){
		this.description = description;
		return this;
	}
	
	public String description(){
		return this.description;
	}
	
	/**
	 * Retourne la description du bien tronquée à "maxLength" caractères
	 * 	si nécessaire.
	 * @param maxLength int Longueur de la chaîne à retourner
	 * @return String
	 */
	public String description(int maxLength){
		if(this.description.length() <= maxLength){
			return this.description;
		}
		
		// La longueur de la description dépasse "maxLength" caractères...
		return this.description.substring(0, maxLength) + "...";
		
		/**
		 * if(strlen($this->description) <= $maxLength){
		 * 	return $this->description;
		 * }
		 * return substr($this->description,0, $maxLength);
		 */
	}
	
	public String description(int maxLength, boolean smart){
		if(this.description.length() <= maxLength){
			return this.description();
		}
		
		// Trouver le dernier blanc typographique juste avant le maxLength
		char spacer = ' ';
		
		int indiceBlancTypo = this.description.lastIndexOf(spacer, maxLength);
		
		// Y-a-t-il donc un espace dans le scope défini ?
		if(indiceBlancTypo == -1){
			return this.description.substring(0, maxLength - CHAINE_SUITE.length()) + CHAINE_SUITE;
		}
		
		return this.description.substring(0, indiceBlancTypo) + CHAINE_SUITE;
	}
	
	public String descriptionToWeb(){
		String webString = "";
		
		for(int indice = this.description.indexOf('\n'); // D'où on part
				indice != -1; // Quand est-ce qu'on s'arrête
				indice = this.description.indexOf('\n', indice + 1) // Comment j'incrémente l'indice
		){
			webString = webString.substring(0, indice) + "<br>" + webString.substring(indice + 1);
		}
		return webString == "" ? this.description : webString;
	}
	
	public String descriptionToWeb(boolean stepByStep){
		String webString = "";
		String lineFeed = "\n";
		
		if(this.description.contains("\n")){
			for(int indice = 0; indice < this.description.length(); indice++){
				if(lineFeed.equals(this.description.substring(indice,indice+1))){
					webString += "<br>";
					indice++;
				} else {
					webString += this.description.substring(indice, indice+1);
				}
			}
		} else {
			webString = this.description;
		}
		return webString;
	}
	
	public String descriptionToWeb(String search, String replace){
		return this.description.replaceAll(search, replace);
	}
	
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
