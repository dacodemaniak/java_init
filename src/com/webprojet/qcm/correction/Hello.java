/**
 * 
 */
package com.webprojet.qcm.correction;

/**
 * @author DaCodeManiak
 *
 */
import javax.swing.*;
import com.webprojet.qcm.*;
import com.webprojet.qcm.correction.*;

public class Hello {
	protected Personne personne;
	
	public Hello(){

	}
	
	public void setPersonne(Personne personne){
		this.personne = personne;
		System.out.println(this.personne.getNom() + "\n" + this.personne.getPrenom());
	}
	
	public Personne getPersonne(){
		return this.personne;
	}
	
	public void sayHello(){
		JOptionPane.showMessageDialog(null, this.personne.getIdentite());
	}

}
