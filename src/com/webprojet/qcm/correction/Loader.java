/**
 * 
 */
package com.webprojet.qcm.correction;

/**
 * Importons toutes les classes du package
 */
import com.webprojet.qcm.*;

/**
 * @author DaCodeManiak
 *
 */
public class Loader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Personne quidam = new Personne("Aubert");
		quidam.setPrenom("Jean-Luc");
		quidam.setAge(48);
		
		Hello bonjour = new Hello();
		bonjour.setPersonne(quidam);
		bonjour.sayHello("en");
		
		
		Hello bonjourFr = new Hello();
		bonjourFr.setPersonne(quidam);
		bonjourFr.sayHello("fr");
		
		Hello bonjourEn = new Hello();
		bonjourEn.setPersonne(quidam);
		bonjourEn.sayHello("es");

	}

}
