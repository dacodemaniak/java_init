/**
 * 
 */
package com.webprojet.qcm.correction.lang;

import javax.swing.*;

import com.webprojet.qcm.correction.*;

/**
 * @author DaCodeManiak
 *
 */
public class HelloFr extends Hello{
	
	public void sayHello(){
		JOptionPane.showMessageDialog(null, "Bonjour " + this.personne.getIdentite("nomprenom"));
	}
}
