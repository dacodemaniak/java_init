/**
 * 
 */
package com.webprojet.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * @author DaCodeManiak
 * @name DbConnect.java Abstraction permettant de définir les attributs communs aux différentes connexion
 *
 */
public abstract class DbConnect implements Connect{
	/**
	 * Chaîne de connexion JDBC
	 */
	protected String dsn;
	
	/**
	 * Driver à charger pour pouvoir établir la connexion au serveur de bases de données concerné.
	 */
	protected String driver;
	
	/**
	 * Le type SGBDSetup doit contenir les informations de connexion au serveur de base de données :
	 * - Nom de la base,
	 * - Nom de l'utilisateur
	 * - Mot de passe
	 * - Adresse du serveur
	 * - Port sur lequel écoute le serveur
	 * - Type de serveur lui-même (mysql, postgresql, oracle, sqlserver...)
	 */
	protected SGBDSetup serverSetup;
	
	/**
	 * Stocke l'instance de connection courante
	 */
	private Connection connection = null;
	
	/**
	 * Essaye d'établir la connexion au serveur spécifié et à la base de données concernée
	 */
	public void connect(){
		try{
			/**
			 * Charge la classe du driver spécifique
			 * @see Constructeur des classes filles
			 */
			Class.forName(this.driver);
			
			/**
			 * Tente d'établir la connexion
			 */
			this.connection = DriverManager.getConnection(this.dsn, this.serverSetup.userName(), this.serverSetup.userPassword());
		} catch(ClassNotFoundException e){
			/**
			 * Le Driver this.driver n'a pas été trouvé
			 */
			JOptionPane.showMessageDialog(null, 
					"Driver non trouvé !\n Vérifiez la chaîne : \n +"
					+ this.driver);
		} catch(SQLException e){
			/**
			 * La méthode getConnection() a échoué
			 */
			JOptionPane.showMessageDialog(null, 
					"La connexion au serveur : " + this.serverSetup.serverType() + " a échoué !\n Vérifiez les informations fournies : \n Base de données : " + this.serverSetup.dbName() + "\n Utilisateur : " + this.serverSetup.userName() + "\n Mot de passe : " + this.serverSetup.userPassword());
		}
	}
	
	public void disconnect(){
		try{
			this.connection.close();
		} catch(SQLException e){
			// Il n'y a rien à faire ici... parce que la méthode close() n'aboutit pas si et seulement si this.connection est nul
		}
	}
	
	public Connection get(){
		return this.connection;
	}
	
	public int getLastId(String tableName){
		int lastId = 1;
		
		try{
			PreparedStatement last = this.connection.prepareStatement("SELECT id FROM " + tableName + " ORDER BY id DESC LIMIT 0,1;");
			ResultSet resultat = last.executeQuery();
			resultat.next();
			lastId = resultat.getInt("id");
		} catch(SQLException e){
			System.out.println("Erreur : " + e.getErrorCode() + " => " + e.getMessage());
		}
		
		return lastId;
	}
	
	public int getLastId(String tableName, String primaryKeyName){
		int lastId = 1;
		
		try{
			PreparedStatement last = this.connection.prepareStatement("SELECT " + primaryKeyName + " FROM " + tableName + " ORDER BY " + primaryKeyName + " DESC LIMIT 0,1;");
			ResultSet resultat = last.executeQuery();
			resultat.next();
			lastId = resultat.getInt(primaryKeyName);
		} catch(SQLException e){
			System.out.println("Erreur : " + e.getErrorCode() + " => " + e.getMessage());
		}
		
		return lastId;		
	}
}
