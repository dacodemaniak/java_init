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
		String classe = "Ensemble d'attributs et de m�thodes d�crivant le sch�ma d'un objet";
		String methode = "Une fonction sp�cifique � un objet destin� � traiter une s�rie d'instruction";
		
		String attribut = "Une information sp�cifique pour un objet d'une classe donn�e.";
		
		String abstraction = "M�canisme qui interdit l'instanciation d'un objet d'une classe mais qui permet de regrouper attributs et m�thodes communs dans les classes filles";
		
		// Instanciation d'un tableau stockant les d�finitions recherch�es
		ArrayList<String> recherches = new ArrayList<String>();
		
		// La d�finition d'un HashMap respose sur la cr�ation d'un objet de la classe HashMap
		HashMap<String,String> glossaire = new HashMap<String,String>();
		
		// Ranger des informations dans un HashMap
		glossaire.put("classe", classe);
		glossaire.put("methode", methode);
		glossaire.put("attribut", attribut);
		glossaire.put("abstraction", abstraction);
		glossaire.put("propriete", attribut);

		// Ajoutons une nouvelle d�finition, par le biais d'un dialogue
		String cle = JOptionPane.showInputDialog("Nouveau mot :");
		String def = JOptionPane.showInputDialog("D�finition pour le mot " + cle + " :");
		glossaire.put(cle, def);
		
		// Initialisation d'une variable pour r�p�ter l'interrogation jusqu'� ce que... l'utilisateur annule le dialogue de saisie
		boolean next = true;
		
		// On va interroger l'utilisateur jusqu'� ce qu'il s'arr�te
		while(next){
			// R�pondons aux questions de l'utilisateur de l'application
			String recherche = JOptionPane.showInputDialog("Quelle d�finition souhaitez-vous ?");
			
			// En plus, on stocke l'information dans le tableau "recherches"
			recherches.add(recherche);
			
			if(recherche != null){
				// L'utilisateur a bien saisi un terme...
				// Pour r�cup�rer une information, on interroge le HashMap avec sa cl�
				String definition = glossaire.get(recherche);
				
				// A-t-on trouv� une d�finition pour ce qui a �t� demand� ?
				if(definition != null){
					JOptionPane.showMessageDialog(null, definition, "D�finition", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "D�sol�, nous n'avons trouv� aucune d�finition pour " + recherche, "Aucune d�finition", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				next = false;
			}
		}
		// Je peux donc afficher l'ensemble des recherches effectu�es
		String message = "";
		for(String cherche : recherches){ // en PHP foreach($recherches as $recherche)
			message += cherche + "\n";
		}
		JOptionPane.showMessageDialog(null, message);
	}

}
