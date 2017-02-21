/**
 * 
 */
package com.webprojet.agence.biens;

/**
 * @author DaCodeManiak
 *
 */
public class Maison extends Bien {
	private double terrain;
	private boolean isMitoyenne;
	
	private final double commission = 2.5;
	
	/**
	 * @return the terrain
	 */
	public double terrain() {
		return this.terrain;
	}
	
	public double getCommissionParDefaut(){
		return this.commission;
	}
	
	/**
	 * @param terrain the terrain to set
	 */
	public Maison terrain(double terrain) {
		this.terrain = terrain;
		return this;
	}
	/**
	 * @return the isMitoyenne
	 */
	public boolean isMitoyenne() {
		return this.isMitoyenne;
	}
	/**
	 * @param isMitoyenne the isMitoyenne to set
	 */
	public Maison mitoyenne(boolean isMitoyenne) {
		this.isMitoyenne = isMitoyenne;
		return this;
	}
	
	
}
