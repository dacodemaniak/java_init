package com.webprojet.agence.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import com.webprojet.agence.adresse.Adresse;
import com.webprojet.agence.biens.Appartement;
import com.webprojet.agence.biens.Maison;
import com.webprojet.agence.biens.Bien;
import com.webprojet.agence.personne.Personne;

public class Fixtures {
	protected ArrayList<Personne> personnes;
	protected ArrayList<Bien> biens;
	protected ArrayList<Adresse> adresses;

	
	public Fixtures(){
		this.personnes = new ArrayList<Personne>();
		this.biens = new ArrayList<Bien>();
		this.adresses = new ArrayList<Adresse>();
		
		this.hydrateAdresses();
		this.hydratePersonnes();
		this.hydrateBiens();
	}
	
	public Adresse getAdresse(int indice){
		if(indice > (this.adresses.size() - 1)){
			return this.adresses.get(0);
		}
		return this.adresses.get(indice);
	}
	
	public Personne getPersonne(int indice){
		if(indice > (this.personnes.size()) - 1){
			return this.personnes.get(0);
		}
		return this.personnes.get(indice);
	}
	
	public Bien getBien(int indice){
		if(indice > (this.biens.size() - 1)){
			return this.biens.get(0);
		}
		return this.biens.get(indice);
	}
	
	private void hydrateAdresses(){
		Adresse adresse = new Adresse();
		
		adresse
			.codePostal("31000")
			.numRue("15")
			.nomRue("de l'Aigle")
			.ville("Toulouse");
		this.adresses.add(adresse);
		
		adresse = new Adresse();
		adresse
			.codePostal("31000")
			.numRue("220")
			.nomRue("de l'Aigle")
			.cplRue("Quartier Est")
			.ville("Toulouse");
		this.adresses.add(adresse);
		
		adresse = new Adresse();
		adresse
			.codePostal("09100")
			.numRue("1")
			.nomRue("de Trémège")
			.cplRue("Hameau de Gerbet")
			.ville("Pamiers");
		this.adresses.add(adresse);
		
		adresse = new Adresse();
		adresse
			.codePostal("31150")
			.numRue("21")
			.nomRue("Allée de Xeraco")
			.ville("Saint-Jory");
		this.adresses.add(adresse);
	}
	
	private void hydratePersonnes(){
		Personne personne = new Personne();
		
		personne
			.nom("Dupont")
			.prenom("Paul");
		this.personnes.add(personne);
		
		personne = new Personne();
		personne
			.nom("Durant")
			.prenom("Pierre");
		this.personnes.add(personne);
		
		personne = new Personne();
		personne
			.nom("Aubert")
			.prenom("Jean-Luc");
		this.personnes.add(personne);
	}
	
	private void hydrateBiens(){
		Appartement appart = new Appartement();
		appart
			.anneeConstruction(this.setDate(1996, 5, 20))
			.surface(50)
			.prixDeVente(75000)
			.prixNetVendeur(70000)
			.vendeur(this.personnes.get(0))
			.adresse(this.adresses.get(0));
		
		appart
			.isACopro(true)
			.hasABox(true)
			.hasAParking(true)
			.type("F2");
		this.biens.add((Bien) appart);
		
		Maison maison = new Maison();
		maison
			.anneeConstruction(this.setDate(2011, 7, 1))
			.surface(150)
			.prixDeVente(275000)
			.prixNetVendeur(270000)
			.vendeur(this.personnes.get(1))
			.adresse(this.adresses.get(1));	
		maison
			.mitoyenne(false)
			.surface(700);
		this.biens.add((Bien) maison);
		
		maison = new Maison();
		maison
			.anneeConstruction(this.setDate(2007, 1, 31))
			.surface(196)
			.prixDeVente(250000)
			.prixNetVendeur(230000)
			.vendeur(this.personnes.get(2))
			.adresse(this.adresses.get(2));	
		maison
			.mitoyenne(false)
			.surface(1500);
		this.biens.add((Bien) maison);
		
		appart = new Appartement();
		appart
			.anneeConstruction(this.setDate(2016, 11, 1))
			.surface(75)
			.prixDeVente(150000)
			.prixNetVendeur(148000)
			.vendeur(this.personnes.get(1))
			.adresse(this.adresses.get(3));

		appart
			.isACopro(false)
			.hasABox(true)
			.hasAParking(true)
			.type("F4");
		this.biens.add((Bien) appart);
	}
	
	private GregorianCalendar setDate(int year, int month, int day){
		GregorianCalendar date = new GregorianCalendar();
		
		date.set(GregorianCalendar.YEAR, year);
		date.set(GregorianCalendar.MONTH, (month - 1));
		date.set(GregorianCalendar.DATE, day);
		
		return date;
	}
}
