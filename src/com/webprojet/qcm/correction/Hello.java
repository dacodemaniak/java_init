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
	
	public void sayHello(String lang){
		switch(lang){
		case "fr":
			HelloFr bonjour = new HelloFr();
			bonjour.setPersonne(this.personne);
			bonjour.sayHello();
		break;
		
		case "en":
			HelloEn welcome = new HelloEn();
			welcome.setPersonne(this.personne);
			welcome.sayHello();
		break;
		
		default:
			HelloFr fallback = new HelloFr();
			fallback.setPersonne(this.personne);
			fallback.sayHello();
		break;
	}
		/*
		switch(lang){
			case "fr":
				JOptionPane.showMessageDialog(null, "Bonjour " + this.personne.getIdentite());
			break;
			
			case "en":
				JOptionPane.showMessageDialog(null, "Welcome " + this.personne.getIdentite());
			break;
			
			case "es":
				JOptionPane.showMessageDialog(null, "Hola " + this.personne.getIdentite());
			break;
			
			default:
				JOptionPane.showMessageDialog(null, "Bonjour " + this.personne.getIdentite());
			break;
		}
			*/
	}

}
