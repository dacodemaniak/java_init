/**
 * 
 */
package com.webprojet.exercice.play.character;

/**
 * @author DaCodeManiak
 *
 */
public abstract class Character {
	protected String nom;
	protected char sexe;
	protected String couleur;
	
	protected boolean isTheMurder;
	
	private static final char MALE = 'M';
	private static final char FEMALE = 'F';
	private static final String[] COLORS = {"Moutarde","Pervenche",
	                                                 "Olive", "Blanc", "Noir"};
	                                                 
	public Character nom(String nom){
		this.nom = nom;
		return this;
	}
	public String nom(){
		return this.nom;
	}
	
	/**
	 * Définit le sexe du personnage... On doit s'assurer que le sexe ne peut être
	 * que M ou F, en outre, si le paramètre sexe n'est pas conforme on détermine
	 * qu'il s'agit d'un F par défaut.
	 * @param sexe
	 * @return
	 */
	public Character sexe(char sexe){
		if(sexe == Character.MALE || sexe == Character.FEMALE){
			this.sexe = sexe;
		} else {
			this.sexe = Character.FEMALE; // PHP <=> self::$VAR
		}
		return this;
	}
	
	/**
	 * Doit récupérer le sexe du personnage...
	 * Mais... Si le sexe n'a jamais été défini ? on doit faire quoi ?
	 * @return
	 */
	public char sexe(){
		return (this.sexe == '\u0000' ? Character.FEMALE : this.sexe);
	}
	
	/**
	 * La couleur ne peut être qu'une des couleurs définies dans la constante
	 * colors, si le paramètre transmis ne fait pas partie du tableau, on définit
	 * arbitrairement que c'est la première couleur définie dans le tableau
	 * ATTENTION la comparaison des types String ne peut se faire que par un equals
	 * @param couleur
	 * @return
	 */
	public Character couleur(String couleur){
		// Variable de contrôle de présence de l'élément couleur dans le tableau colors
		boolean inArray = false;
		
		for(int indice=0; indice < Character.COLORS.length; indice++){
			if(couleur.toLowerCase().equals(Character.COLORS[indice].toLowerCase())){
				inArray = true; // On a trouvé une correspondance
				this.couleur = Character.COLORS[indice];
				break; // On sort de la boucle... on a trouvé une correspondance
			}
		}
		
		// Sortie de boucle... on va vérifier la valeur de inArray
		if(!inArray){
			this.couleur = Character.COLORS[0];
		}
		
		return this;
	}
	
	public String couleur(){
		return this.couleur;
	}
	
	/**
	 * La méthode isTheMurder(boolean murder) DOIT IMPERATIVEMENT être
	 * codée dans toutes les classes Filles de la classe Character
	 * @param murder
	 * @return
	 */
	abstract public Character isTheMurder(boolean murder);
	
	public boolean isTheMurder(){
		return this.isTheMurder;
	}
	
}
