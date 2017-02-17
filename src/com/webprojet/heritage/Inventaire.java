/**
 * La classe Inventaire va calculer le prix total de notre stock de boissons
 */
package com.webprojet.heritage;

import java.util.ArrayList;

public class Inventaire {

	public static void main(String[] args) {
		/**
		 * On définit une variable de type ArrayList <=> tableau
		 */
		ArrayList stock;
		
		/**
		 * Crée un objet monStock de type Stock pour pouvoir récupérer toutes mes boissons
		 */
		Stock monStock = new Stock();
		monStock.hydrate(); // J'ai récupéré mon stock de boissons
		// Récupérons le stock...
		stock = monStock.getStock();
		
		// Essayons de calculer le prix du stock
		float prixTotal;
		prixTotal = 0;
		
		for(int i=0; i < stock.size(); i++){
			Boisson boisson = (Boisson) stock.get(i); // Je récupère l'objet que je caste directement en type Boisson (donc peu importe si c'est un Alcool, un NoAlcool)
			prixTotal += boisson.prix();
		}
		
		// En fin de parcours... Le prix total est donc de...
		System.out.println("Mon stock est valorisé à " + prixTotal + " €");
	}

}
