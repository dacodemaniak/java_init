/**
 * 
 */
package com.webprojet.reservation.spectateur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.webprojet.persistence.mysql.MySQL;
import com.webprojet.reservation.util.ReservationSetup;

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

	public int persist() {
		/**
		 * Identifiant résultant de la requête d'insertion
		 */
		int id = 1;
		
		// Connexion à la base de données
		MySQL base = new MySQL(new ReservationSetup());
		
		// Définir la requête d'insertion elle-même
		String statement = "INSERT INTO personne (nom,prenom,email,adresse) VALUES (?,?,?,?);";
		
		// Préparer la requête d'insertion...
		try{
			PreparedStatement insert = base.get().prepareStatement(statement);
			// On remplace les ? par les valeurs elles-mêmes
			insert.setString(1, this.nom);
			insert.setString(2, this.prenom);
			insert.setString(3, this.email);
			insert.setString(4, this.adresse);
			// Exécute la requête...
			insert.executeUpdate();
			// Récupère le dernier identifiant créé
			id = base.getLastId("personne");
			
		} catch(SQLException e){
			// Normalement, pas de problème à prévoir...
		}
		return id; // Retourne l'identifiant de la nouvelle ligne de la table personne
	}
	
	public String personneName(){
		return this.prenom + " " + this.nom;
	}
	
	/**
	 * Retourne le dernier identifiant de la table personne...
	 * @deprecated Voir la méthode com.webprojet.persistence.DbConnect.getLastId()
	 * @param base
	 * @return
	 */
	private int getLastId(MySQL base){
		int lastId = 1;
		try {
			PreparedStatement last = base.get().prepareStatement("SELECT id FROM personne ORDER BY id DESC LIMIT 0,1;");
			ResultSet resultat = last.executeQuery();
			resultat.next(); // Charger la seule et unique ligne...
			lastId = resultat.getInt("id");
		} catch(SQLException e){
			// Normalement pas d'exception...
		}
		return lastId;		
	}
}
