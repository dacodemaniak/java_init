/**
 * 
 */
package com.webprojet.persistence.test;

import javax.swing.JOptionPane;

import com.webprojet.persistence.MySQLConnect;

/**
 * @author DaCodeManiak
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MySQLConnect connexion = new MySQLConnect();
		if(connexion.connexion() == null){
			JOptionPane.showMessageDialog(null, "Connexion MySQL impossible");
		} else {
			JOptionPane.showMessageDialog(null, "Hello MySQL");
		}
		
		connexion.disconnect();
	}

}
