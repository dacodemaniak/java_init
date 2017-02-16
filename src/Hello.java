/**
 * 
 */

/**
 * @author DaCodeManiak
 * Classe de base Hello : Affiche un message dans la console...
 */

public class Hello {
	
	/**
	 * Point d'entrée dans l'application Hello
	 * @param args Tableau de chaîne de caractères String[]
	 * @return void Pas de valeur de retour
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args){
		/**
		 * System est une classe de la librairie standard Java
		 * out est un attribut de la classe System
		 * println() est une méthode de l'objet référencé par "out"
		 */
		
		/**
		 * 
		 * PHP : $nom = $args[0]; echo substr($nom,0,1);
		 * PHP : if(count($args) > 0)
		 */
		String nom;
		
		if(args.length > 0)
			 nom = args[0];
		
		/**
		 * Types numériques :
		 * byte : Entier signé compris entre -128 et +127
		 * short : Entier signé compris entre -32 768 et + 32 767
		 * int : Entier signé compris entre - 2 147 483 648 et + 2 147 483 647
		 * float : Nombre à virgule flottante (32 bits)
		 * double : Nombre à virgule flottant (64 bits)
		
		byte age;
		age = 48;
		*/
		
		/**
		 * boolean : Peut prendre une valeur vraie ou fausse
		 */
		boolean majeur = true;
		
		/**
		 * Petit exercice :
		 * 	- Définir une variable de type String
		 *  - Affecter la valeur Hello [petit | grand] Java, vous avez [48] ans
		 *  - Afficher la chaîne avec la méthode System.out.println()
		**/
		
		/**
		 * Chaîne à afficher au final...
		 */
		String chaineFinale = "Hello "; // Parce que ça commencera toujours par Hello
		
		
		/*if(age > 18){
			majeur = true;
			chaineFinale += "Grand ";
		} else {
			majeur = false;
			chaineFinale += "Petit ";
		}
		
		chaineFinale += "Java. Vous avez : " + age + " ans";
		*/
		
		/**
		 * Package : javax.swing.* (Package "graphique" standard de Java)
		 * new \Symfony\Components\....
		 * Type : JOptionPane => Classe spécifique de ce package
		 * Méthode showMessageDialog(parentContainer null, String chaine);
		 */
		javax.swing.JOptionPane.showMessageDialog(null, chaineFinale);
		//System.out.println(chaineFinale);
		
		/**
		 * C'est un caractère unique... qui peut être aussi un caractère Unicode
		
		char euro = '\u20ac'; // Code Unicode pour le signe €
		
		if(majeur){
			System.out.println("Hello Grand Java");
		} else {
			System.out.println("Hello Petit Java");
		}
		
		System.out.println("Facile de définir le signe € avec un Unicode : " + euro);
		 */
	}
	
	/*
	private void setAge(byte age){
		this.age = age;
	}
	*/
	
}
