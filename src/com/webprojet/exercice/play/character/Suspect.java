/**
 * 
 */
package com.webprojet.exercice.play.character;

import java.util.ArrayList;

/**
 * @author DaCodeManiak
 *
 */
public class Suspect extends Character {
	private ArrayList<Character> suspects;
	
	public Suspect(String nom, char sexe, String couleur, ArrayList<Character> suspects){
		this.nom = nom;
		this.sexe(sexe);
		this.couleur(couleur);
		this.suspects = suspects;
	}
	
	public Suspect(ArrayList<Character> suspects){
		this.suspects = suspects;
	}
	
	public ArrayList<Character> addSuspect(){
		this.suspects.add(this);
		return this.suspects;
	}

	@Override
	public Character isTheMurder(boolean murder) {
		boolean oneMurder = false;
		
		// On ne traite que si le paramètre murder est à true
		if(murder){
			for(int indice = 0; indice < this.suspects.size(); indice++){
				if(((Character) this.suspects.get(indice)).isTheMurder){
					oneMurder = true; // J'ai déjà un meurtrier...
					break;
				}
			}
			// Sortie de boucle... s'il n'y a pas de meurtrier, c'est okay
			if(!oneMurder){
				this.isTheMurder = true;
			} else {
				this.isTheMurder = false; // On ne peut pas avoir deux meurtriers
			}
		} else {
			this.isTheMurder = murder; // Seule valeur qui reste : false
		}
		
		return this;
	}
}
