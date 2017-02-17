package com.webprojet.heritage;

import static javax.swing.JOptionPane.*;

public class AfficherBoisson {
	public static void afficherBoisson(Boisson boisson){
		String message;
		
		message = "Nom : " + boisson.nom() + "\n";
		message += "Prix : " + boisson.prix();
		
		showMessageDialog(null, message);
	}
}
