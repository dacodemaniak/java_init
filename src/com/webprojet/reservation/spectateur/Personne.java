/**
 * 
 */
package com.webprojet.reservation.spectateur;

/**
 * @author DaCodeManiak
 * @name Personne
 * D�finition de l'ensemble des personnes qui seront concern�es (ou non) par un spectacle
 *
 */
public class Personne implements Acheteur{
	protected String nom;
	protected String prenom;
	protected String email;
	protected String adresse;
	
	protected boolean isAcheteur;
	
	public Personne(String nom, String prenom, String email, String adresse){
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		
		this.isAcheteur = false;
	}
	
	public String toString(){
		String unePersonne;
		
		unePersonne = this.prenom + " " + this.nom + "\n" +
				this.adresse + "\n" +
				this.email;
		
		return unePersonne;
	}
	
	/**
	 * Implémentation des méthodes de l'interface Acheteur
	 */
	public Personne isAcheteur(boolean isAcheteur){
		this.isAcheteur = isAcheteur;
		return this;
	}
	
	public boolean isAcheteur(){
		return this.isAcheteur;
	}
}
