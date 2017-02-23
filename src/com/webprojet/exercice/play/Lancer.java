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
	 * Une m�thode "statique" peut �tre appel�e sans disposer d'une instance
	 * de la classe dont elle fait partie :
	 * i.e : Lancer.hasMurder(suspects) est autoris� sans avoir un new Lancer() avant
	 * @param suspects
	 */
	public static ArrayList<Character> hasMurder(ArrayList<Character> suspects){
		if(!Lancer.checkMurder(suspects)){
			// La m�thode m'indique qu'il n'y a pas de meurtrier...
			// Je vais devoir en d�signer un al�atoirement...
			// en utilisant la m�thode "random()" de la classe standard Math de Java
			int indice = (int) (Math.random() * (suspects.size() - 1));
			
			Character leMeurtrierAnonyme = suspects.get(indice);
			leMeurtrierAnonyme.isTheMurder(true);
			// C'est bien, j'ai d�fini un meurtrier, mais... il faut encore que
			// je le r�injecte dans l'ArrayList...
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
		boolean murder = false; // Etat relatif � la m�thode : oui ou non y-a-il un meurtrier
		
		for(int indice = 0; indice < suspects.size(); indice++){
			if(((Character) suspects.get(indice)).isTheMurder()){
				murder = true;
				break;
			}
		}
		
		return murder;
	}
}
