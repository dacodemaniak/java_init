/**
 * 
 */
package com.webprojet.resto;

import java.util.ArrayList;

/**
 * @author DaCodeManiak
 *
 */
public class Menu {
	protected ArrayList<Composition> menu;
	
	public Menu(){
		this.menu = new ArrayList<Composition>();
		
		Entree salade = new Entree("Salade César", (float) 13.50);
		
		Cafe cafeOffert = new Cafe(true);
		
		this.menu.add(salade);
		this.menu.add(cafeOffert);
	}
	
	public String toString(){
		String message = "Votre commande :\n";
		float total = 0;
		
		for(Composition plat : this.menu){
			message += plat.nom() + " : " + ((Payant) plat).getPrix() + "\n";
			total += plat.prix();
		}
		
		message += "\n\nTotal : " + total;
		return message;
	}
	
	
}
