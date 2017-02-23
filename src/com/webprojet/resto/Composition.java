/**
 * 
 */
package com.webprojet.resto;

/**
 * @author DaCodeManiak
 *
 */
public abstract class Composition implements NomAccess {
	protected float prix;
	protected String nom;
	
	public Composition prix(float prix){
		this.prix = prix;
		return this;
	}
	
	public float prix(){
		return this.prix;
	}
	
	public String nom(){
		return this.nom;
	}
	
	public Composition nom(String nom){
		this.nom = nom;
		return this;
	}
	
	public abstract void majoration();
}
