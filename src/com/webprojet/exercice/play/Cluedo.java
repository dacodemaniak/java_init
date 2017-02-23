/**
 * 
 */
package com.webprojet.exercice.play;

import java.util.ArrayList;

import com.webprojet.exercice.play.character.Character;
import com.webprojet.exercice.play.character.Suspect;
import com.webprojet.exercice.play.*;

/**
 * @author DaCodeManiak
 *
 */
public class Cluedo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Character> suspects = new ArrayList<Character>();
		
		Suspect colonel = new Suspect(suspects); // On lui passe la liste des suspects
		colonel.nom("Colonel Moutarde")
			.couleur("Moutarde")
			.sexe('M')
			.isTheMurder(false);
		colonel.addSuspect();
		
		Suspect pervenche = new Suspect("Mme Pervenche", 'F', "Pervenche", suspects);
		pervenche.isTheMurder(false);
		pervenche.addSuspect();
		
		Suspect leblanc = new Suspect("M. Leblanc", 'M', "Blanc", suspects);
		leblanc.isTheMurder(false);
		leblanc.addSuspect();
		
		// On va pouvoir jouer... maintenant, mais... il faut aussi déterminer
		// s'il y a un meurtrier, et si ce n'est pas le cas, en désigner un
		// aléatoirement.
		Lancer.hasMurder(suspects);
		
		// Qui était donc le meurtrier ?
		Character theMurderWas = Lancer.whoWasTheMurder(suspects);
		System.out.println("Le meurtrier était : " + theMurderWas.nom());
	}

}
