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
	 * D�finit le sexe du personnage... On doit s'assurer que le sexe ne peut �tre
	 * que M ou F, en outre, si le param�tre sexe n'est pas conforme on d�termine
	 * qu'il s'agit d'un F par d�faut.
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
	 * Doit r�cup�rer le sexe du personnage...
	 * Mais... Si le sexe n'a jamais �t� d�fini ? on doit faire quoi ?
	 * @return
	 */
	public char sexe(){
		return (this.sexe == '\u0000' ? Character.FEMALE : this.sexe);
	}
	
	/**
	 * La couleur ne peut �tre qu'une des couleurs d�finies dans la constante
	 * colors, si le param�tre transmis ne fait pas partie du tableau, on d�finit
	 * arbitrairement que c'est la premi�re couleur d�finie dans le tableau
	 * ATTENTION la comparaison des types String ne peut se faire que par un equals
	 * @param couleur
	 * @return
	 */
	public Character couleur(String couleur){
		// Variable de contr�le de pr�sence de l'�l�ment couleur dans le tableau colors
		boolean inArray = false;
		
		for(int indice=0; indice < Character.COLORS.length; indice++){
			if(couleur.toLowerCase().equals(Character.COLORS[indice].toLowerCase())){
				inArray = true; // On a trouv� une correspondance
				this.couleur = Character.COLORS[indice];
				break; // On sort de la boucle... on a trouv� une correspondance
			}
		}
		
		// Sortie de boucle... on va v�rifier la valeur de inArray
		if(!inArray){
			this.couleur = Character.COLORS[0];
		}
		
		return this;
	}
	
	public String couleur(){
		return this.couleur;
	}
	
	/**
	 * La m�thode isTheMurder(boolean murder) DOIT IMPERATIVEMENT �tre
	 * cod�e dans toutes les classes Filles de la classe Character
	 * @param murder
	 * @return
	 */
	abstract public Character isTheMurder(boolean murder);
	
	public boolean isTheMurder(){
		return this.isTheMurder;
	}
	
}
