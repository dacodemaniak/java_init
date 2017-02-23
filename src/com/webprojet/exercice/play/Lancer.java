/**
 * 
 */
package com.webprojet.exercice.play;

import java.util.ArrayList;
import com.webprojet.exercice.play.character.Character;
/**
 * @author DaCodeManiak
 *
 */
public class Lancer {
	/**
	 * Une méthode "statique" peut être appelée sans disposer d'une instance
	 * de la classe dont elle fait partie :
	 * i.e : Lancer.hasMurder(suspects) est autorisé sans avoir un new Lancer() avant
	 * @param suspects
	 */
	public static ArrayList<Character> hasMurder(ArrayList<Character> suspects){
		if(!Lancer.checkMurder(suspects)){
			// La méthode m'indique qu'il n'y a pas de meurtrier...
			// Je vais devoir en désigner un aléatoirement...
			// en utilisant la méthode "random()" de la classe standard Math de Java
			int indice = (int) (Math.random() * (suspects.size() - 1));
			
			Character leMeurtrierAnonyme = suspects.get(indice);
			leMeurtrierAnonyme.isTheMurder(true);
			// C'est bien, j'ai défini un meurtrier, mais... il faut encore que
			// je le réinjecte dans l'ArrayList...
			suspects.set(indice, leMeurtrierAnonyme);
		}
		return suspects;
	}
	
	public static Character whoWasTheMurder(ArrayList<Character> suspects){
		for(int indice = 0; indice < suspects.size(); indice++){
			if(suspects.get(indice).isTheMurder()){
				return suspects.get(indice);
			}
		}
		return null;
	}
	
	private static boolean checkMurder(ArrayList<Character> suspects){
		boolean murder = false; // Etat relatif à la méthode : oui ou non y-a-il un meurtrier
		
		for(int indice = 0; indice < suspects.size(); indice++){
			if(((Character) suspects.get(indice)).isTheMurder()){
				murder = true;
				break;
			}
		}
		
		return murder;
	}
}
