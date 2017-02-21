/**
 * 
 */
package com.webprojet.agence;

import java.util.GregorianCalendar;

import com.webprojet.agence.personne.Vendeur;
import com.webprojet.agence.utils.Fixtures;
import com.webprojet.agence.vente.Vente;
import com.webprojet.agence.view.Listing;
import com.webprojet.agence.visite.Visite;
import com.webprojet.agence.visite.Visites;

/**
 * @author DaCodeManiak
 *
 */
public class Agence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Définit les données dont j'ai besoin... (Personnes, Adresses, Biens)
		Fixtures datas = new Fixtures();
		
		// Organisons quelques visites, dans une collection...
		Visites visites = new Visites();
		
		// Visite 1
		Visite visite = new Visite(new GregorianCalendar(), datas.getBien(0), datas.getPersonne(1));
		visites.add(visite);
		
		// Visite 2 : raccourci...
		visites.add(new Visite(new GregorianCalendar(), datas.getBien(1), datas.getPersonne(3)));
		
		// Et si on affichait les visites du coup...
		Listing listing = new Listing();
		listing.visites(visites);
		listing.showListing();
		
		// Faisons une jolie vente...
		Vendeur vendeur = new Vendeur(3.25);
		vendeur.nom("Cro")
			.prenom("Ernest");
		Vente vente = new Vente(datas.getBien(2), datas.getPersonne(1), 175000, vendeur);
		System.out.println(vente.toString());
		
	}

}
