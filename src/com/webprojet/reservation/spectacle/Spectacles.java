/**
 * 
 */
package com.webprojet.reservation.spectacle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import com.webprojet.persistence.SGBDSetup;
import com.webprojet.persistence.mysql.MySQL;
import com.webprojet.reservation.util.ReservationSetup;

/**
 * @author DaCodeManiak
 * @name Spectacles.java : Collectionne les objets de type Spectacle
 */
public class Spectacles {
	private ArrayList<Spectacle> spectacles = new ArrayList<Spectacle>();
	
	/**
	 * Constructeur qui va alimenter les données à partir de la base
	 * de données...
	 */
	public Spectacles(){
		this.getDataFromDb();
	}
	
	public DefaultTableModel hydrate(String[] tableHeaders){
		String type;
		
		DefaultTableModel modele = new DefaultTableModel(tableHeaders,0);
		
		for(Spectacle spectacle : this.spectacles){
			if(spectacle instanceof Opera){
				type = "Opéra";
			} else {
				type = "Théâtre";
			}
			modele.addRow(new String[] {type,spectacle.titre(),spectacle.description(), String.format("%d", ((Spectacle)spectacle).placesDisponibles())});
		}
		return modele;
	}
	
	public void add(Spectacle spectacle){
		// Ajoute le spectacle à la collection (ArrayList)
		this.spectacles.add(spectacle);
		
		// Utilise la méthode "persist()" pour insérer le spectacle dans la base
		spectacle.persist();
	}
	
	private void getDataFromDb(){
		/**
		 * Définition des informations de connexion...
		 */
		SGBDSetup setup = new ReservationSetup();
		
		/**
		 * Initialisation de la connexion
		 */
		MySQL base = new MySQL(setup);
		
		/**
		 * Créer la requête pour récupérer les spectacles
		 * @update Ajout de la colonne id pour pouvoir récupérer la clé primaire des spectacles
		 */
		String selectStatement = "SELECT id, titre, description, type, nbplaces FROM spectacle;";
		
		/**
		 * Essaye d'exécuter la requête...
		 */
		Object spectacle = null;
		try{
			/**
			 * Crée un objet de type Statement (phrase SQL)
			 */
			Statement select = base.get().createStatement();
			
			/**
			 * J'ai besoin d'un ResultSet pour lire les résultats
			 */
			ResultSet resultat = select.executeQuery(selectStatement);
			
			/**
			 * On boucle sur le résultat pour alimenter le ArrayList
			 */
			while(resultat.next()){
				/**
				 * ATTENTION ! utiliser .equals() pour comparer des objets de type String
				 */
				if(resultat.getString("type").equals("Opéra")){
					spectacle = new Opera();
				} else {
					spectacle = new Theatre();
				}
				// Définition du spectacle
				((Spectacle) spectacle).id(resultat.getInt("id"));
				((Spectacle)spectacle).titre(resultat.getString("titre"));
				((Spectacle)spectacle).description(resultat.getString("description"));
				((Spectacle)spectacle).placesDisponibles(resultat.getInt("nbplaces"));
				
				// On peut ajouter le spectacle à la collection
				this.spectacles.add((Spectacle)spectacle);
			}
		} catch(SQLException e){
			// Plantage dans la requête...
		} finally {
			base.disconnect();
		}
	}
	
	/**
	 * getter pour retourner la liste des spectacles
	 * @return ArrayList
	 */
	public ArrayList<Spectacle> spectacles(){
		return this.spectacles;
	}
	
	/**
	 * Méthode qui retourne si oui ou non il y a des éléments dans la collection
	 * @return boolean
	 */
	public boolean hasElements(){
		return this.spectacles.size() > 0;
		//return this.spectacles.size() > 0 ? true : false;
	}
	
	public JComboBox<String> getCombo(JComboBox<String> combo){
		String comboLigne;
		
		for(Spectacle spectacle : this.spectacles){
			if(spectacle.placesRestantes() > 0){
				if(spectacle instanceof Opera){
					comboLigne = "(Opéra) " +  spectacle.titre();
				} else {
					comboLigne = "(Théâtre) " + spectacle.titre();
				}
				comboLigne += " [" + spectacle.placesRestantes() + "]";
				
				combo.addItem(comboLigne);
			}
		}
		return combo;
	}
}
