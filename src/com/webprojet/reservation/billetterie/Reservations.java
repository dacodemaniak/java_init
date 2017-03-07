/**
 * 
 */
package com.webprojet.reservation.billetterie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.webprojet.persistence.mysql.MySQL;
import com.webprojet.reservation.spectacle.Opera;
import com.webprojet.reservation.spectacle.Spectacle;
import com.webprojet.reservation.spectacle.Theatre;
import com.webprojet.reservation.spectateur.Personne;
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
	
	/**
	 * Ajoute une réservation à la liste des réservations
	 * @param reservation
	 */
	public void add(Reservation reservation){
		this.reservations.add(reservation);
	}
	
	public DefaultTableModel hydrate(String[] tableHeaders){
		DefaultTableModel modele = new DefaultTableModel(tableHeaders,0);
		
		for(Reservation reservation : this.reservations){
			modele.addRow(new String[] {reservation.getSpectacle().titre(),reservation.getPersonne().personneName()});
		}
		return modele;
	}
	
	private void getDataFromDb(){
		MySQL base = new MySQL(new ReservationSetup());
		
		String sqlStatement = "SELECT s.titre AS titre, s.type AS type, p.prenom AS prenom, p.nom AS nom FROM spectacle as s INNER JOIN reservation as r ON s.id = r.id_spectacle INNER JOIN personnes_reservations as pr ON r.id = pr.id_reservation INNER JOIN personne as p ON pr.id_personne = p.id WHERE pr.is_acheteur = 1 ORDER BY s.titre;";
		
		try{
			/**
			 * Crée un objet de type Statement (phrase SQL)
			 */
			Statement select = base.get().createStatement();
			
			/**
			 * J'ai besoin d'un ResultSet pour lire les résultats
			 */
			ResultSet resultat = select.executeQuery(sqlStatement);
			
			Object spectacle = null;
			Personne personne = null;
			Reservation reservation = null;
			
			while(resultat.next()){
				// 1. Instancier un spectacle
				if(resultat.getString("type").equals("Opéra")){
					spectacle = new Opera();
				} else {
					spectacle = new Theatre();
				}
				// Définition du spectacle
				((Spectacle)spectacle).titre(resultat.getString("titre"));

				// 2. Instancier une personne
				personne = new Personne(resultat.getString("nom"), resultat.getString("prenom"), null, null);
				// 3. Instancier une réservation
				reservation = new Reservation((Spectacle) spectacle, personne);
				
				//4. Ajouter la réservation à la collection
				this.reservations.add(reservation);
			}
			
		} catch(SQLException e){
			System.out.println("Erreur [" + e.getErrorCode() + "] : " + e.getMessage());
		}
		
		
	}
}
