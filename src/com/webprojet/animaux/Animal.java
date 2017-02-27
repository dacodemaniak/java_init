/**
 * 
 */
package com.webprojet.animaux;

import java.util.HashMap;

/**
 * @author DaCodeManiak
 *
 */
public abstract class Animal {
	protected String modeDeplacement;
	protected String typeAlimentation;
	
	protected HashMap<String,String> deplacements;
	protected HashMap<String,String> alimentations;
	protected HashMap<String,HashMap<String,String>> modes;
	
	public static final HashMap<String,String> genre = createGenre();
	
	
	public Animal(){
		this.deplacements = new HashMap<String,String>();
		this.deplacements.put("marche", "Marcher");
		this.deplacements.put("course", "Courir");
		this.deplacements.put("rampe", "Ramper");
		this.deplacements.put("vole", "Voler");
		this.deplacements.put("nage", "Nager");
		
		this.alimentations = new HashMap<String,String>();
		this.alimentations.put("herbivore", "Herbivore");
		this.alimentations.put("carnivore", "Carnivore");
		this.alimentations.put("omnivore", "Omnivore");
		this.alimentations.put("insectivore", "Insectivore");
		
		this.modes = new HashMap<String,HashMap<String,String>>();
		this.modes.put("deplacements", this.deplacements);
		this.modes.put("alimentations", this.alimentations);
	}
	
	private static HashMap<String,String> createGenre(){
		HashMap<String,String> genre = new HashMap<String,String>();
		genre.put("compagnie", "Animal de compagnie");
		genre.put("sauvage", "Animal sauvage");
		
		return genre;
	};
}
