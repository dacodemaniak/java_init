/**
 * 
 */
package com.webprojet.heritage;

import java.util.ArrayList;

/**
 * @author DaCodeManiak
 *
 */
public class Stock {
	/**
	 * Attribut stock de type ArrayList qui stockera toutes mes bouteilles
	 */
	private ArrayList stock;
	
	
	/**
	 * Retourne le stock défini par la méthode "hydrate()"
	 * @return ArrayList
	 */
	public ArrayList getStock(){
		return this.stock;
	}
	/**
	 * Méthode qui va me permettre d'alimenter l'attribut "stock"
	 */
	public void hydrate(){
		stock = new ArrayList();
		
		Alcool vin = new Alcool("Saint-Emilion", (float) 100);
		vin.setDegre((float) 13.5);
		
		this.stock.add(vin);
		
		Alcool biere = new Alcool("Grimbergen", (float) 1.5);
		biere.setDegre((float) 5.5);
		
		this.stock.add(biere);
		
		NoAlcool orangina = new NoAlcool("Orangina", (float) 0.8);
		orangina.setSucree(true);
		
		this.stock.add(orangina);
		
		NoAlcool volvic = new NoAlcool("Eau de Volvic", (float) 0.5);
		volvic.setSucree(false);
		
		this.stock.add(volvic);
		
		Alcool vodka = new Alcool();
		vodka
			.prix((float) 50.80)
			.nom("Vodka");
	}
}
