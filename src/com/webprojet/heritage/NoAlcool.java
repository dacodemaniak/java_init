/**
 * 
 */
package com.webprojet.heritage;

/**
 * @author DaCodeManiak
 *
 */
public class NoAlcool extends Boisson {
	/**
	 * Définit s'il s'agit d'une boisson sucrée ou pas
	 */
	private boolean sucree;
	
	public NoAlcool(String nom, float prix){
		super(nom, prix); // super <=> parent:: de PHP, appelle le constructeur de la classe parente
	}
	
	public NoAlcool(){
		super();
	}
	
	public NoAlcool(String nom){
		super(nom);
	}
	
	public NoAlcool(String nom, float prix, boolean sucree){
		super(nom, prix);
		this.sucree = sucree;
	}
	
	public boolean isSucree() {
		return sucree;
	}

	public void setSucree(boolean sucree) {
		this.sucree = sucree;
	}
}
