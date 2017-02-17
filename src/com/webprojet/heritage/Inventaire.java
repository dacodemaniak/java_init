/**
 * La classe Inventaire va calculer le prix total de notre stock de boissons
 */
package com.webprojet.heritage;

import java.util.ArrayList;

public class Inventaire {

	public static void main(String[] args) {
		/**
		 * On d�finit une variable de type ArrayList <=> tableau
		 */
		ArrayList stock;
		
		/**
		 * Cr�e un objet monStock de type Stock pour pouvoir r�cup�rer toutes mes boissons
		 */
		Stock monStock = new Stock();
		monStock.hydrate(); // J'ai r�cup�r� mon stock de boissons
		// R�cup�rons le stock...
		stock = monStock.getStock();
		
		// Essayons de calculer le prix du stock
		float prixTotal;
		prixTotal = 0;
		
		for(int i=0; i < stock.size(); i++){
			Boisson boisson = (Boisson) stock.get(i); // Je r�cup�re l'objet que je caste directement en type Boisson (donc peu importe si c'est un Alcool, un NoAlcool)
			prixTotal += boisson.prix();
		}
		
		// En fin de parcours... Le prix total est donc de...
		System.out.println("Mon stock est valoris� � " + prixTotal + " �");
	}

}
