/**
 * 
 */
package com.webprojet.agence;

import com.webprojet.agence.biens.Maison;
import com.webprojet.string.*;
import com.webprojet.string.utils.StringUtils;

/**
 * @author DaCodeManiak
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maison maison = new Maison();
		maison.description("Jolie maison arbor�e de 150m� sur un terrain de 1500m� piscinable.\n D�pendances de 300m� � rafra�chir dans un environnement calme, proche des commerces et des �tablissements scolaires.");
		
		System.out.println("Compl�te " + maison.description()); // Int�gralit� du contenu
		System.out.println("R�sum� " + maison.description(25)); // Que les 28 premiers caract�res
		
		System.out.println("Smart : " + maison.description(25, true));
		
		//System.out.println("To web (v 1) : " + maison.descriptionToWeb());
		System.out.println("To web (v 2) : " + maison.descriptionToWeb(true));
		
		System.out.println("To web (v3) " + maison.descriptionToWeb("\n", "<br>"));
		
		StringUtils chaine = new StringUtils();
		chaine.chaine = maison.description();
		System.out.println("To ce que vous voulez " + chaine.replace("\n", "<br />"));
	}

}
