/**
 * 
 */

/**
 * @author DaCodeManiak
 *
 */
public class Fete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * On d�finit deux variables de type Personne (@see Personne.java)
		 * invite_[n] sont des r�f�rences de type Personne et sont une instance d'un objet Personne
		 */
		Personne invite_1 = new Personne();
		Personne invite_2 = new Personne();
		Personne invite_3 = new Personne();
		Personne invite_4 = new Personne();
		
		/**
		 * Avec un constructeur
		 */
		Personne casper = new Personne();
		
		/**
		 * Avec un autre constructeur
		 */
		Personne bond = new Personne(77, "Bond", "James");
		bond.nom("Bond, James Bond");
		/**
		 * D�finit les attributs pour invite_1
		 * Casting de variable : Permet de convertir un type en un autre type compatible. Par ex. : 48 est consid�r� par d�faut comme �tant un entier, la m�thode setAge() attend un byte, on doit donc "caster" la valeur en (byte) pour qu'elle soit accept�e dans la m�thode.
		 */
		invite_1.setAge((byte) 48);
		invite_1.setNom("Aubert");
		invite_1.setPrenom("Jean-Luc");
		
		/**
		 * D�finit les attributs pour invite_2
		 */
		invite_2.setAge((byte) 25);
		invite_2.setNom("Talaron");
		invite_2.setPrenom("Delphine");
		
		invite_3.setAge((byte) 32);
		invite_3.nom("Talut"); // La m�thode nom() avec un param�tre <=> setNom()
		invite_3.setPrenom("Jean");
		
		// D�finition de la r�f�rence � l'objet invite_4
		invite_4
			.nom("Durant")
			.prenom("Paul")
			.age(50);
		
		// Utilisons les "getters" pour afficher une belle bo�te de dialogue
		String messageFinal;
		
		messageFinal = "Bienvenue � ma f�te ! \nLes invit�s sont :";
		messageFinal += invite_1.getPrenom() + " " + invite_1.getNom() + "\n";
		messageFinal += invite_2.getPrenom() + " " + invite_2.getNom() + "\n";
		messageFinal += invite_3.getPrenom() + " " + invite_3.nom() + "\n";
		messageFinal += "Guest : " + casper.nom() + " " + casper.prenom() + "\n";
		messageFinal += invite_4.prenom() + " " + invite_4.nom() +  "\n";
		javax.swing.JOptionPane.showMessageDialog(null, messageFinal);
	}

}
