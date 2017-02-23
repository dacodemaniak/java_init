import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author DaCodeManiak
 *
 */
public class Glossaire {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String classe = "Ensemble d'attributs et de méthodes décrivant le schéma d'un objet";
		String methode = "Une fonction spécifique à un objet destiné à traiter une série d'instruction";
		
		String attribut = "Une information spécifique pour un objet d'une classe donnée.";
		
		String abstraction = "Mécanisme qui interdit l'instanciation d'un objet d'une classe mais qui permet de regrouper attributs et méthodes communs dans les classes filles";
		
		// Instanciation d'un tableau stockant les définitions recherchées
		ArrayList<String> recherches = new ArrayList<String>();
		
		// La définition d'un HashMap respose sur la création d'un objet de la classe HashMap
		HashMap<String,String> glossaire = new HashMap<String,String>();
		
		// Ranger des informations dans un HashMap
		glossaire.put("classe", classe);
		glossaire.put("methode", methode);
		glossaire.put("attribut", attribut);
		glossaire.put("abstraction", abstraction);
		glossaire.put("propriete", attribut);

		// Ajoutons une nouvelle définition, par le biais d'un dialogue
		String cle = JOptionPane.showInputDialog("Nouveau mot :");
		String def = JOptionPane.showInputDialog("Définition pour le mot " + cle + " :");
		glossaire.put(cle, def);
		
		// Initialisation d'une variable pour répéter l'interrogation jusqu'à ce que... l'utilisateur annule le dialogue de saisie
		boolean next = true;
		
		// On va interroger l'utilisateur jusqu'à ce qu'il s'arrête
		while(next){
			// Répondons aux questions de l'utilisateur de l'application
			String recherche = JOptionPane.showInputDialog("Quelle définition souhaitez-vous ?");
			
			// En plus, on stocke l'information dans le tableau "recherches"
			recherches.add(recherche);
			
			if(recherche != null){
				// L'utilisateur a bien saisi un terme...
				// Pour récupérer une information, on interroge le HashMap avec sa clé
				String definition = glossaire.get(recherche);
				
				// A-t-on trouvé une définition pour ce qui a été demandé ?
				if(definition != null){
					JOptionPane.showMessageDialog(null, definition, "Définition", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Désolé, nous n'avons trouvé aucune définition pour " + recherche, "Aucune définition", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				next = false;
			}
		}
		// Je peux donc afficher l'ensemble des recherches effectuées
		String message = "";
		for(String cherche : recherches){ // en PHP foreach($recherches as $recherche)
			message += cherche + "\n";
		}
		JOptionPane.showMessageDialog(null, message);
	}

}
