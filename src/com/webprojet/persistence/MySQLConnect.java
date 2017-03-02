/**
 * 
 */
package com.webprojet.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author DaCodeManiak
 *
 */
public class MySQLConnect {
	private static final String user = "resa_db_user";
	private static final String password = "Re5@DM1n";
	private static final String uri = "jdbc:mysql://127.0.0.1:3306/reservation";
	
	private Connection connexion = null;
	
	public MySQLConnect(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connexion = DriverManager.getConnection(
					MySQLConnect.uri,
					MySQLConnect.user,
					MySQLConnect.password
			);
		} catch(SQLException e){
			e.printStackTrace();
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public Connection connexion(){
		return this.connexion;
	}
	
	public void disconnect(){
		if(this.connexion != null){
			try {
				this.connexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
