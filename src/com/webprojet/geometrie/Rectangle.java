/**
 * 
 */
package com.webprojet.geometrie;

/**
 * @author DaCodeManiak
 *
 */
public class Rectangle extends Figure {
	protected float longueur;
	protected float largeur;
	
	public Rectangle(float longueur, float largeur, String couleur){
		super(couleur);
		
		this.longueur = longueur;
		this.largeur = largeur;
		 // ou appeler explicitement this.couleur(couleur)
	}
	
	public float getSurface(){
		return this.longueur * this.largeur;
	}
}
