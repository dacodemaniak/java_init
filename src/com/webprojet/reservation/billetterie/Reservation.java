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
			resa.setDate(2, (Date) new GregorianCalendar().getTime());
			resa.setInt(3, this.spectacle.id());
			
			resa.executeUpdate(); // Crée réellement la réservation
			
			int id = this.getLastId(base);
			
			// Faire persister l'acheteur...
			// Récupérer son identifiant
			
			// Faire persister la table d'association "personnes_reservations"
			
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
}
