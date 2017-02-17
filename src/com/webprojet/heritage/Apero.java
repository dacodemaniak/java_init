/**
 * Exploration des conversions de types (casting) Java
 */
package com.webprojet.heritage;

/**
 * @author DaCodeManiak
 *
 */
public class Apero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Alcool biere = new Alcool("Despe", (float) 5);
		biere.setDegre((float) 3.5);
		
		NoAlcool paf = new NoAlcool("Schweppes", (float) 2.50);
		paf.setSucree(true);
		
		Boisson teqpaf = new Boisson();
		teqpaf.prix((float) 5);
		teqpaf.nom("Tequila Paf");
		
		// Si je veux le prix de la Tequila Paf, je peux...
		System.out.println("Prix : " + teqpaf.prix());
		
		// On peut définir une variable (ou un attribut) dont le type est de la superclass
		Boisson boisson; // Anonyme, mais de type Boisson
		boisson = (Boisson) biere; // Casting de la variable teqpaf en Boisson
		System.out.println("Prix de " + boisson.nom() + " : " + boisson.prix());
		
		/**
		 * Exemple de casting avec des types simples :
		 * On ne peut pas ranger un "double" dans un "float" à moins de
		 * caster la variable pour qu'elle corresponde au type voulu.
		 */
		float unFloat;
		double unDouble;
		
		unDouble = 12.52;
		unFloat = (float) unDouble;
		
		/*
		Boisson autreBoisson;
		autreBoisson = (Boisson) paf;
		System.out.println("Le " + autreBoisson.nom() +  " ne peut pas retourner le " + autreBoisson.getDegre());
		*/
	}

}
