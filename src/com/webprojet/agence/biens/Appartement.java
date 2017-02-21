/**
 * 
 */
package com.webprojet.agence.biens;

/**
 * @author DaCodeManiak
 *
 */
public class Appartement extends Bien {
	private String type;
	private boolean isACopro;
	private boolean hasAParking;
	private boolean hasABox;
	
	private final double commission = 2;
	
	/**
	 * @return the type
	 */
	public String type() {
		return this.type;
	}
	/**
	 * @param type the type to set
	 */
	public Appartement type(String type) {
		this.type = type;
		return this;
	}
	/**
	 * @return the isACopro
	 */
	public boolean isACopro() {
		return this.isACopro;
	}
	/**
	 * @param isACopro the isACopro to set
	 */
	public Appartement isACopro(boolean isACopro) {
		this.isACopro = isACopro;
		return this;
	}
	/**
	 * @return the hasAParking
	 */
	public boolean isHasAParking() {
		return this.hasAParking;
	}
	/**
	 * @param hasAParking the hasAParking to set
	 */
	public Appartement hasAParking(boolean hasAParking) {
		this.hasAParking = hasAParking;
		return this;
	}
	/**
	 * @return the hasABox
	 */
	public boolean isHasABox() {
		return this.hasABox;
	}
	/**
	 * @param hasABox the hasABox to set
	 */
	public Appartement hasABox(boolean hasABox) {
		this.hasABox = hasABox;
		return this;
	}
}
