package com.webprojet.qcm.correction;

import javax.swing.*;

public class HelloEn extends Hello {
	public void sayHello(){
		JOptionPane.showMessageDialog(null, "Welcome " + this.personne.getIdentite("nomprenom"));
	}
}
