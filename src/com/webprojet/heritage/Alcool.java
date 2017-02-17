package com.webprojet.heritage;

public class Alcool extends Boisson {
	private float degre;
	
	public float getDegre() {
		return degre;
	}

	public void setDegre(float degre) {
		this.degre = degre;
	}

	public Alcool(String nom, float prix) {
		super(nom, prix);
		// TODO Auto-generated constructor stub
	}

	public Alcool() {
		// TODO Auto-generated constructor stub
	}

	public Alcool(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}


}
