/**
 * 
 */
package com.webprojet.agence.vente;

import com.webprojet.agence.biens.*;
import com.webprojet.agence.personne.Personne;
import com.webprojet.agence.personne.Vendeur;

/**
 * @author DaCodeManiak
 *
 */
public class Vente {
	/**
	 * Stocke le bien qui a été vendu
	 */
	protected Bien bien; 
	
	/**
	 * Stocke la personne qui a acheté le bien...
	 */
	protected Personne acheteur;
	
	protected Vendeur negociateur;
	
	protected int prixNegocie;
	
	protected int marge;
	
	public Vente(Bien bien, Personne acheteur, int prixNegocie, Vendeur negociateur){
		this.bien = bien;
		this.acheteur = acheteur;
		this.prixNegocie = prixNegocie;
		this.negociateur = negociateur;
		
		// De mettre à jour le statut isVendu du Bien concerné
		this.bien.isVendu(true);
		
		// On peut donc calculer la commission du Vendeur
		this.negociateur.addCommission(this.calculeMarge());
	}
	
	private int calculeMarge(){
		float pourcentage = 0;
		if(this.bien instanceof Maison){
			pourcentage = (float) ((Maison) this.bien).getCommissionParDefaut();
		}
		
		this.marge = (int) this.bien.prixNetVendeur() - this.prixNegocie;

			
		return this.marge;
	}
	
	public String toString(){
		String vente = "";
		
		vente += "Vendu !\n";
		
		// Construction du message signalant la vente
		if(this.bien instanceof Appartement){
			vente += "Appartement\n";
		} else {
			vente += "Maison\n";
		}
		
		// On ajoute l'adresse du bien...
		vente += this.bien.adresse().ville() + " (" + this.bien.adresse().codePostal() + ")\n";
		
		// Affiche le prix négocié...
		vente += "Au prix de :" + this.prixNegocie + "\n";
		
		// On peut calculer la marge... de l'agence
		vente += "Marge sur la transaction : " + this.marge;
		
		// On peut aussi donc... retourner le cumul des comm du négociateur
		
		return vente;
	}
}
