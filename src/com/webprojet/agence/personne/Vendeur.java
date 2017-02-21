/**
 * 
 */
package com.webprojet.agence.personne;

/**
 * @author DaCodeManiak
 *
 */
public class Vendeur extends Personne {
	
	/**
	 * Le cumul des commissions du vendeur
	 */
	protected double commission;
	
	/**
	 * Pourcentage de commission pour ce vendeur
	 */
	protected float pourcentage;
	
	public Vendeur(double pourcentage){
		this.pourcentage = (float) pourcentage;
	}
	
	public double getPourcentage(){
		return this.pourcentage;
	}
	
	public void addCommission(int marge){
		this.commission += ((marge * this.pourcentage) / 100);
	}
	
	public double comm(){
		return this.commission;
	}

}
