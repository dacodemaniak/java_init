/**
 * 
 */
package com.webprojet.persistence.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.webprojet.persistence.mysql.MySQL;

/**
 * @author DaCodeManiak
 *	Teste le package de connexion à une base de données
 */
public class TestReservation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Une instance de configuration de connexion
		 */
		ReservationSetup setup = new ReservationSetup();
		
		MySQL base = new MySQL(setup);
		
		if(base.get() != null){
			JOptionPane.showMessageDialog(null, "C'est okay, on peut bosser avec la base \"reservation\"");
			
			// Pour pouvoir "jouer" avec la base de données
			//	On doit récupérer une instance de requête (Statement)
			// et demander à cette instance d'exécuter la requête
			String password = TestReservation.getMD5("admin","NimDA");
			String sqlStatement = "INSERT INTO utilisateur (nom,login,pass,salt) VALUES ('Administrateur', 'admin','" + password + "', 'NimDA');";
			/** En PHP
			 * $sqlStatement = "INSERT INTO utilisateur (nom,login,pass,salt) VALUES ('Jean-Luc Aubert','jean-luc','" . md5("NimDAadminNimDA") . "','NimDA');";
			 */
			String selectStatement = "SELECT id, titre, description FROM spectacle;";
			try{
				Statement query = base.get().createStatement();
				// Exécuter la requête elle-même
				query.executeUpdate(sqlStatement);
				
			} catch(SQLException e){
				JOptionPane.showMessageDialog(null,
						"Une erreur est survenue dans la requête : \n" +
						sqlStatement
				);
			}
			
			// Pour récupérer les informations :
			// une requête de type SELECT
			// Un objet de type Statement
			// Une méthode executeQuery sur l'objet Statement
			try{
				Statement select = base.get().createStatement();
				ResultSet jeuResultat = select.executeQuery(selectStatement); // Exécution de la requête, maintenant, bouclons sur le jeu de résultat
				String resultat = "Table spectacle : \n";
				while(jeuResultat.next()){
					resultat += jeuResultat.getString("titre") + "\n";
				}
				// En fin de boucle... on affiche le tout
				JOptionPane.showMessageDialog(null, resultat);
				
			} catch(SQLException e){
				JOptionPane.showMessageDialog(null,
						"Une erreur est survenue dans la requête : \n" +
						selectStatement
				);				
			}
			base.disconnect();
		}
	}
	
	/**
	 * Méthode d'encryptage en MD5
	 */
	private static String getMD5(String password, String salt){
		/**
		 * Génère le mot de passe final à encrypter... sel + mot de passe + sel
		 */
		String finalPassword = salt+password+salt;
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			/**
			 * Encrypte la chaîne octet par octet
			 */
			md.update(finalPassword.getBytes());
			byte[] digest = md.digest(); // Récupère le résultat
			
			/**
			 * Convertir le tableau d'octets en hexa pour stockage en base
			 */
			StringBuffer sb = new StringBuffer();
			/**
			 * On boucle sur chaque octet pour le convertir en hexa (0 .. f)
			 */
			for(byte b : digest){
				sb.append(String.format("%02x", b & 0xff));
			}
			
			/**
			 * On retourne la chaîne cryptée au format Hexadécimal
			 */
			return sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
