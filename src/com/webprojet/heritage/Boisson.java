/**
 * 
 */
package com.webprojet.heritage;

/**
 * @author DaCodeManiak
 *
 */
public class Boisson {
	/**
	 * Prix des boissons
	 */
	protected float prix;
	
	protected String nom;
	
	/**
	 * Constructeur de la classe Boisson
	 * @param nom
	 * @param prix
	 */
	public Boisson(String nom, float prix){
		this.prix = prix;
		this.nom = nom;
	}
	
	public Boisson(){}
	
	public Boisson(String nom){
		this.nom = nom;
		this.prix = (float) 1.25;
	}
	
	/**
	 * Détermine la valeur de l'attribut "prix" de l'instance de Boisson
	 * <=> setter
	 * @param prix (float : nombre à virgule flottante)
	 * @return Boisson (l'instance courante de la classe Boisson)
	 * @usage Boisson vodka = new Boisson();
	 * 	vodka
	 * 		.prix(2.15)
	 * 		.nom("Vodka");
	 */
	public Boisson prix(float prix){
		this.prix = prix;
		return this;
	}
	
	/**
	 * Retourne la valeur de l'attribut "prix" de l'instance courante de Boisson
	 * <=> getter
	 * @return float
	 */
	public float prix(){
		return this.prix;
	}
	
	public Boisson nom(String nom){
		this.nom = nom;
		return this;
	}
	
	/**
	 * Retourne le nom de la boisson
	 * @return String
	 */
	public String nom(){
		return this.nom;
	}
}
