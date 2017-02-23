package com.webprojet.geometrie;

public class Cercle extends Figure {
	private float rayon;
	
	public Cercle(float rayon, String couleur){
		super(couleur);
		
		this.rayon = rayon;
	}
	
	public float getSurface(){
		return (float)Math.PI * this.rayon * this.rayon;
	}
}
