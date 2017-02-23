/**
 * 
 */
package com.webprojet.geometrie;

/**
 * @author DaCodeManiak
 *
 */
public abstract class Figure {
	private String couleur;
	
	public Figure(String couleur){
		this.couleur = couleur;
	}
	
	public Figure couleur(String couleur){
		this.couleur = couleur;
		return this;
	}
	
	public String couleur(){
		return this.couleur;
	}
	
	public abstract float getSurface();
	
	public String toString(){
		return "La figure de couleur " + this.couleur + " a une surface de " + getSurface();
	}
}
