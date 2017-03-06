/**
 * 
 */
package com.webprojet.reservation.billetterie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.webprojet.persistence.mysql.MySQL;
import com.webprojet.reservation.util.ReservationSetup;

/**
 * @author DaCodeManiak
 *
 */
public class Reservations {
	private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	
	public Reservations(){
		this.getDataFromDb();
	}
	
	private void getDataFromDb(){
		MySQL base = new MySQL(new ReservationSetup());
		
		String sqlStatement = "SELECT s.titre as titre,CONCAT(p.prenom, ' ', p.nom) as acheteur FROM spectacle as s INNER JOIN reservation as r ON s.id = r.id_spectacle INNER JOIN personnes_reservations as pr ON r.id = pr.id_reservation INNER JOIN personne as p ON pr.id_personne = p.id WHERE pr.is_acheteur = 1 ORDER BY s.titre;";
		
		try{
			/**
			 * Crée un objet de type Statement (phrase SQL)
			 */
			Statement select = base.get().createStatement();
			
			/**
			 * J'ai besoin d'un ResultSet pour lire les résultats
			 */
			ResultSet resultat = select.executeQuery(sqlStatement);
			
			while(resultat.next()){
				// Que fait-on ici ?
			}
			
		} catch(SQLException e){
			System.out.println("Erreur [" + e.getErrorCode() + "] : " + e.getMessage());
		}
		
		
	}
}
