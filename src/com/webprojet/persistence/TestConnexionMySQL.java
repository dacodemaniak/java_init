/**
 * 
 */
package com.webprojet.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * @author DaCodeManiak
 * 	Test de connexion à la base de données reservation du serveur MySQL local
 *
 */
public class TestConnexionMySQL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Définissons le dsn (Data Service Name) JDBC
		String dsn = "jdbc:mysql://127.0.0.1/reservation";
		
		// Une chaîne pour le login de l'utilisateur de base de données
		String user = "resa_db_user";
		
		// Une chaîne pour le mot de passe...
		String password = "Re5@DM1n";
		
		// Une variable pour stocker l'instance de connexion
		Connection dbConnect = null;
		
		// On va essayer de se connecter au serveur et à la base de données
		try{
			// Chargement du driver mysql
			Class.forName("com.mysql.jdbc.Driver");
			
			// Récupération de l'instance de connexion
			dbConnect = DriverManager.getConnection(dsn, user, password);
			
		} catch(ClassNotFoundException error){
			JOptionPane.showMessageDialog(null, "Le driver com.mysql.jdbc.Driver n'a pas pu être trouvé !");
			error.printStackTrace(); // Affiche la pile des appels
		} catch(SQLException error){
			JOptionPane.showMessageDialog(null, "La connexion avec " + dsn + " a échoué.\nLes paramètres passés :\nUtilisateur : " + user + "\nMot de passe : " + password);
			error.printStackTrace();
		} finally { // A la fin de l'exécution...
			try{
				if(dbConnect != null){
					JOptionPane.showMessageDialog(null, "Welcome to MySQL in Java");
				}
				dbConnect.close(); // Met fin à la connexion...
			} catch(SQLException error){
				JOptionPane.showMessageDialog(null, "Fermeture de la connexion impossible : cause probable, la connexion n'a pas réussi en amont");
			}
		}
	}

}
