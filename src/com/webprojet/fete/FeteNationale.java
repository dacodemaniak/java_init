/**
 * 
 */
package com.webprojet.fete;

import javax.swing.*;

/**
 * @author DaCodeManiak
 *
 */
public class FeteNationale extends Fete {
	private String type = "F�te Nationale";
	
	public FeteNationale(String jour, String organisateur){
		this.jourSemaine = jour + " 14 juillet";
		this.organisateur = organisateur;
	}
	
	public String type(){
		return this.type;
	}
	
	public void avertir(){
		JOptionPane.showMessageDialog(null,
				this.type + "\n" + this.jourSemaine + " by " + this.organisateur
		);
	}
}
