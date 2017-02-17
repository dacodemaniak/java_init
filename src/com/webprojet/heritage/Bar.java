/**
 * 
 */
package com.webprojet.heritage;

/**
 * @author DaCodeManiak
 *
 */
public class Bar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NoAlcool eau = new NoAlcool();
		
		// On peut utiliser les m�thodes de la classe "parente" de NoAlcool
		eau.prix((float) 2.50)
			.nom("Perrier");
		eau.setSucree(false);
		
		// On peut appeler la m�thode statique afficherBoisson() directement
		// Equivalent en PHP de dbConfig::getUser()
		AfficherBoisson.afficherBoisson((Boisson) eau);
		
		System.out.println("Vous avez command� :\n" + eau.nom() + "\n" + "Ca vous fera " + eau.prix() + " �");
		
		NoAlcool pepsi = new NoAlcool("Pepsi Cola");
		pepsi.setContenant(Contenants.NABU);
		// Plutot que... pepsi.setContenant("Nabu...zut je ne sais plus");
		System.out.println("Vous avez command� :\n" + pepsi.nom() + "\n" + "Ca vous fera " + pepsi.prix() + " �");
		
		NoAlcool orangina = new NoAlcool("Orangina Sanguine", (float) 3.00);
		orangina.setContenant(Contenants.BALTHAZAR);
		System.out.println("Vous avez command� :\n" + orangina.nom() + "\n" + "Ca vous fera " + orangina.prix() + " �");
		
		NoAlcool vittel = new NoAlcool("Vittel", (float) 3.00, false);
		vittel.setContenant(Contenants.BOTTLE);
		System.out.println("Vous avez command� :\n" + vittel.nom() + "\n" + "Ca vous fera " + vittel.prix() + " �\n" + (vittel.isSucree() ? " sucr�e" : " non sucr�e"));
		
		double rayon;
		rayon = 20 * Contenants.PI;
	}

}
