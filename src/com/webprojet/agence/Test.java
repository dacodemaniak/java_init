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
		maison.description("Jolie maison arborée de 150m² sur un terrain de 1500m² piscinable.\n Dépendances de 300m² à rafraîchir dans un environnement calme, proche des commerces et des établissements scolaires.");
		
		System.out.println("Complète " + maison.description()); // Intégralité du contenu
		System.out.println("Résumé " + maison.description(25)); // Que les 28 premiers caractères
		
		System.out.println("Smart : " + maison.description(25, true));
		
		//System.out.println("To web (v 1) : " + maison.descriptionToWeb());
		System.out.println("To web (v 2) : " + maison.descriptionToWeb(true));
		
		System.out.println("To web (v3) " + maison.descriptionToWeb("\n", "<br>"));
		
		StringUtils chaine = new StringUtils();
		chaine.chaine = maison.description();
		System.out.println("To ce que vous voulez " + chaine.replace("\n", "<br />"));
	}

}
