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
	
	/**
	 * @overriding Boisson.prix(float prix) Red�finition de m�thode
	 * La m�thode dans la classe fille porte le m�me nom, et dispose des m�mes param�tres
	 */
	public Boisson prix(float prix){
		this.prix = (float) (prix * 1.5);
		return this;
	}
	
	/**
	 * @overloading Surcharge de m�thode, m�me nom, mais des param�tres diff�rents
	 * @param prix
	 * @param majoration
	 * @return
	 */
	public Boisson prix(float prix, float majoration){
		this.prix = (float) (prix * majoration);
		return this;
	}

}
