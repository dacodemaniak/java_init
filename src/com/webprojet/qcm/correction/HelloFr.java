/**
 * 
 */
package com.webprojet.qcm.correction;

import javax.swing.*;

/**
 * @author DaCodeManiak
 *
 */
public class HelloFr extends Hello{
	
	public void sayHello(){
		JOptionPane.showMessageDialog(null, "Bonjour " + this.personne.getIdentite("nomprenom"));
	}
}
