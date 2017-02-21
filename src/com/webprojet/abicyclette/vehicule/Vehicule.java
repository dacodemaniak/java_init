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
	 * Nombre de roues du véhicule concret
	 */
	protected int roues;
	
	/**
	 * Energie utilisée pour faire bouger le véhicule
	 */
	protected String carburant;
	
	/**
	 * Capacité maximale du véhicule, conducteur compris
	 */
	protected int nbPlaces;
	

	
	/**
	 * Affecte à l'attribut protégé "roues" la valeur du paramètre roue
	 * @param roues
	 * @return Instance de l'objet Vehicule (ou d'une de ses filles) pour pouvoir chaîner les méthodes
	 */
	public Vehicule roues(int roues){
		this.roues = roues;
		return this;
	}
	
	/**
	 * Retourne le nombre de roues du véhicule
	 * @return int Valeur de l'attribut protégé "roues"
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
