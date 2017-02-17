/**
 * 
 */
package com.webprojet.qcm.correction;

/**
 * Importons toutes les classes du package
 */
import com.webprojet.qcm.*;
import com.webprojet.qcm.correction.lang.*;

/**
 * @author DaCodeManiak
 *
 */
public class Loader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String lng;
		Hello bonjour;
		
		Personne quidam = new Personne("Aubert");
		quidam.setPrenom("Jean-Luc");
		quidam.setAge(48);
		
		if(args.length == 0){
			lng = "en";
		} else {
			lng = args[0];
		}
		LangChooser lang = new LangChooser(lng);
		
		bonjour = lang.sayHello();
		bonjour.setPersonne(quidam);
		bonjour.sayHello();
	}

}
