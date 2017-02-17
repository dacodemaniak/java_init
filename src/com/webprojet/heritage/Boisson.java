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
	
	protected String contenant;
	
	/**
	 * Un attribut "final" doit être initialisé, et ne pourra plus être modifié
	 */
	protected final String reference;
	
	/**
	 * Constructeur de la classe Boisson
	 * @param nom
	 * @param prix
	 */
	public Boisson(String nom, float prix){
		this.prix = prix;
		this.nom = nom;
		this.reference = "Boisson";
	}
	
	public Boisson(){
		this.reference = "Boisson";
	}
	
	public Boisson(String nom){
		this.nom = nom;
		this.prix = (float) 1.25;
		this.reference = "Boisson";
	}
	
	public Boisson setContenant(String contenant){
		/*
		switch(contenant){
		case Contenants.BOTTLE:
			this.contenant = "Bouteille";
			break;
		case Contenants.MAGNUM:
			this.contenant = "Magnum";
			break;
		case Contenants.BALTHAZAR:
			this.contenant = "Balthazar";
			break;
		case Contenants.NABU:
			this.contenant = "Nabuchodonosor";
			break;
		case Contenants.JEROBOAM:
			this.contenant = "Jeroboam";
			break;
		default:
			this.contenant = "Bouteille";
			break;
		}
		*/
		this.contenant = contenant;
		
		return this;
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
	
	/**
	 * final indique que la méthode concernée ne pourra pas être réécrite dans les classes filles
	 * @param nom
	 * @return
	 */
	public final Boisson nom(String nom){
		this.nom = nom;
		return this;
	}
	
	/**
	 * Retourne le nom de la boisson
	 * @return String
	 */
	public final String nom(){
		return this.nom;
	}
}
