/**
 * 
 */
package com.webprojet.reservation.billetterie;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import com.webprojet.persistence.mysql.MySQL;
import com.webprojet.reservation.spectacle.Spectacle;
import com.webprojet.reservation.spectateur.Personne;
import com.webprojet.reservation.util.ReservationSetup;

/**
 * @author DaCodeManiak
 *
 */
public class Reservation {
	/**
	 * Numéro de réservation
	 */
	private String numero;
	
	/**
	 * L'objet représentant le spectacle concerné par la réservation
	 */
	private Spectacle spectacle; 
	
	/**
	 * L'objet représentant la personne qui fait la réservation
	 */
	private Personne acheteur;
	
	public Reservation(Spectacle spectacle, Personne acheteur){
		this.spectacle = spectacle;
		this.acheteur = acheteur;
	}
	
	public Spectacle getSpectacle(){
		return this.spectacle;
	}
	
	public Personne getPersonne(){
		return this.acheteur;
	}
	
	public boolean addPersonne(Personne personne){
		if(this.spectacle.placesRestantes() > 0){
			// C'est bon on peut ajouter la personne au spectacle
			this.spectacle.hydrate(personne);
			return true;
		}
		return false;
	}
	
	public void persist(){
		MySQL base = new MySQL(new ReservationSetup());
		
		try{
			PreparedStatement resa = base.get().prepareStatement("INSERT INTO reservation (numero,date,id_spectacle) VALUES (?,?,?);");
			resa.setString(1, "0001");
			// Récupération de la date du jour...
			java.util.Date today = new java.util.Date(); // Récupère la date du jour...
			java.sql.Date sqlDate = new java.sql.Date(today.getTime()); // Formate au format SQL
			resa.setDate(2, sqlDate);
			resa.setInt(3, this.spectacle.id());
			
			resa.executeUpdate(); // Crée réellement la réservation
			
			// Récupère le dernier identifiant de la table reservation
			/**
			 * Obsolète... @see MySQL::getLastId(String tableName)
			
			int idReservation = this.getLastId(base);
			 */
			int idReservation = base.getLastId("reservation");
			
			// Faire persister l'acheteur...
			int idAcheteur = this.acheteur.persist();
			
			// Faire persister la table d'association "personnes_reservations"
			this.persistTableAsso(idAcheteur, idReservation, 1, base);
			
		} catch(SQLException e){
			// En espérant qu'il n'y ait pas d'erreurs...
		}
	}
	
	private int getLastId(MySQL base){
		int lastId = 1;
		try {
			PreparedStatement last = base.get().prepareStatement("SELECT id FROM reservation ORDER BY id DESC LIMIT 0,1;");
			ResultSet resultat = last.executeQuery();
			resultat.next();
			lastId = resultat.getInt("id");
		} catch(SQLException e){
			// Normalement pas d'exception...
		}
		return lastId;
	}
	
	public void persistTableAsso(int idAcheteur, int idReservation, int isAcheteur, MySQL base){
		try {
			PreparedStatement insert = base.get().prepareStatement("INSERT INTO personnes_reservations (id_personne,id_reservation,is_acheteur) VALUES (?, ?, ?);");
			insert.setInt(1, idAcheteur);
			insert.setInt(2, idReservation);
			insert.setInt(3, isAcheteur);
			
			insert.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
