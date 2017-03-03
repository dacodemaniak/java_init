/**
 * 
 */
package com.webprojet.reservation.spectacle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.webprojet.persistence.mysql.MySQL;
import com.webprojet.reservation.spectateur.*;
import com.webprojet.reservation.util.ReservationSetup;

/**
 * @author DaCodeManiak
 * @name Spectacle
 * 	Classe abstraite purement didactique, pour r�visions
 *
 */
public abstract class Spectacle {
	protected int id;
	protected String titre;
	protected String description;
	protected int placesDisponibles;
	
	/**
	 * Principe d'une requête préparée :
	 * 	Définition d'une requête avec des "trous" qui seront remplis
	 * 	au moment de l'exécution de la requête
	 */
	private PreparedStatement insert;
	
	private String queryInsert = "INSERT INTO spectacle (type,titre,description,nbplaces) VALUES (?,?,?,?)";
	
	/**
	 * Collection des spectateurs pour un spectacle
	 */
	protected ArrayList<Personne> spectateurs;
	
	/**
	 * Définit les différents types de spectacles
	 */
	public static final String[] TYPES = {"Opéra", "Théâtre"};
	
	public Spectacle(){
		this.spectateurs = new ArrayList<Personne>();
	}
	
	public int id(){
		return this.id;
	}
	
	public void id(int id){
		this.id = id;
	}
	
	/**
	 * @return the titre
	 */
	public String titre() {
		return this.titre;
	}
	/**
	 * @param titre the titre to set
	 */
	public Spectacle titre(String titre) {
		this.titre = titre;
		return this;
	}
	/**
	 * @return the description
	 */
	public String description() {
		return this.description;
	}
	/**
	 * @param description the description to set
	 */
	public Spectacle description(String description) {
		this.description = description;
		return this;
	}
	/**
	 * @return the placesDisponibles
	 */
	public int placesDisponibles() {
		return this.placesDisponibles;
	}
	/**
	 * @param placesDisponibles the placesDisponibles to set
	 */
	public Spectacle placesDisponibles(int placesDisponibles) {
		this.placesDisponibles = placesDisponibles;
		return this;
	}
	
	public void hydrate(Personne personne){
		this.spectateurs.add(personne);
	}
	
	public int placesRestantes(){
		return this.placesDisponibles - this.spectateurs.size();
	}
	
	/**
	 * Génère et exécute une requête de création / mise à jour d'une ligne dans la table
	 * spectacle.
	 */
	public void persist(){
		String type;
		
		// Instancier la connexion à la base de donnée...
		MySQL base = new MySQL(new ReservationSetup());
		
		// Récupérer une instance de requête préparée
		try{
			this.insert = base.get().prepareStatement(this.queryInsert);
			
			// On détermine le type de spectacle à partir de l'instance de l'objet courant
			if(this instanceof Opera){
				type = "Opéra";
			} else {
				type = "Théâtre";
			}
			
			// Il faut juste remplacer les ? par les valeurs concernées
			this.insert.setString(1, type);
			this.insert.setString(2, this.titre);
			this.insert.setString(3, this.description);
			this.insert.setInt(4, this.placesDisponibles);
			
			// On peut donc utiliser la méthode executeUpdate()
			this.insert.executeUpdate();
		} catch(SQLException e){
			// Il y aura eu un problème de traitement de la requête...
			e.printStackTrace();
		} finally {
			base.disconnect();
		}
	}
	
	/**
	 * Méthode publique statique (peut être appelée sans instance)
	 * @param userSelect Chaîne de caractère sélectionnée par l'utilisateur
	 * @return Spectacle
	 */
	public static Spectacle get(String userSelect){
		Object leSpectacle = null;
		
		PreparedStatement select;
		
		String sql = "SELECT id,type,titre,description,nbplaces FROM spectacle WHERE  CONCAT('(',type,') ',titre,' [',nbplaces, ']') = ?;";
		
		// Récupérer une instance de requête préparée
		MySQL base = new MySQL(new ReservationSetup());
		try{
			select = base.get().prepareStatement(sql);
			select.setString(1, userSelect);
			ResultSet resultat = select.executeQuery();
			resultat.next(); // On ne devrait avoir qu'un seul résultat
			if(resultat.getString("type").equals("Opéra")){
				leSpectacle = new Opera();
			} else {
				leSpectacle = new Theatre();
			}
			// On alimente l'objet
			((Spectacle) leSpectacle).titre(resultat.getString("titre"));
			((Spectacle) leSpectacle).description(resultat.getString("description"));
			((Spectacle) leSpectacle).placesDisponibles(resultat.getInt("nbplaces"));
			((Spectacle) leSpectacle).id(resultat.getInt("id"));
			
		} catch(SQLException e){
			// Normalement rien à faire ici, on devrait tout avoir...
		} finally {
			base.disconnect(); // On n'oublie pas...
		}
		
		return (Spectacle) leSpectacle;
	}
	
}
