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
public class HelloEn extends Hello{
	
	public void sayHello(){
		JOptionPane.showMessageDialog(null, "Welcome " + this.personne.getIdentite("nomprenom"));
	}
}
