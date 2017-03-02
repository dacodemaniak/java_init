/**
 * 
 */
package com.webprojet.persistence.mysql;

import com.webprojet.persistence.DbConnect;
import com.webprojet.persistence.SGBDSetup;

/**
 * @author DaCodeManiak
 *
 */
public class MySQL extends DbConnect {
	/**
	 * Constructeur de la classe MySQL
	 */
	public MySQL(SGBDSetup setup){
		/**
		 * Conserve les informations de connexion...
		 */
		this.serverSetup = setup;
		
		/**
		 * On peut terminer la chaîne de connexion
		 */
		this.dsn = "jdbc:" + this.serverSetup.serverType() + "://" + this.serverSetup.serverHost();
		
		/**
		 * On vérifie si le port a été défini et on l'ajoute le cas échéant
		 */
		if(this.serverSetup.serverPort() != null){
			this.dsn += ":" + this.serverSetup.serverPort();
		}
		
		/**
		 * Puis le nom de la base à laquelle je veux me connecter
		 */
		this.dsn += "/" + this.serverSetup.dbName();
		
		/**
		 * Définition du driver à utiliser pour se connecter
		 */
		this.driver = "com." + this.serverSetup.serverType() + ".jdbc.Driver";
		
		/**
		 * Essayons donc concrètement de se connecter en appelant la méthode connect() de la classe parente.
		 */
		super.connect();
	}
}
