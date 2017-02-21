/**
 * 
 */
package com.webprojet.abicyclette.vehicule;

/**
 * @author DaCodeManiak
 *
 */
public class Vehicule {
	/**
	 * Nombre de roues du v�hicule concret
	 */
	protected int roues;
	
	/**
	 * Energie utilis�e pour faire bouger le v�hicule
	 */
	protected String carburant;
	
	/**
	 * Capacit� maximale du v�hicule, conducteur compris
	 */
	protected int nbPlaces;
	

	
	/**
	 * Affecte � l'attribut prot�g� "roues" la valeur du param�tre roue
	 * @param roues
	 * @return Instance de l'objet Vehicule (ou d'une de ses filles) pour pouvoir cha�ner les m�thodes
	 */
	public Vehicule roues(int roues){
		this.roues = roues;
		return this;
	}
	
	/**
	 * Retourne le nombre de roues du v�hicule
	 * @return int Valeur de l'attribut prot�g� "roues"
	 */
	public int roues(){
		return this.roues;
	}
	
	public Vehicule carburant(String carburant){
		this.carburant = carburant;
		return this;
	}
	public String carburant(){
		return this.carburant;
	}
	
	public Vehicule nbPlaces(int nbPlaces){
		this.nbPlaces = nbPlaces;
		return this;
	}
	public int nbPlaces(){
		return this.nbPlaces;
	}
}
