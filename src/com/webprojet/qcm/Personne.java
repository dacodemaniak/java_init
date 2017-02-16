package com.webprojet.qcm;

public class Personne {
	/**
	 * Définit le nom d'une personne... quelle qu'elle soit
	 */
	private String nom;
	private String prenom;
	private int age;
	
	/**
	 * Le nom qui sera alloué à l'instance de Personne
	 * @param sonNom
	 */
	public Personne(String sonNom){
		this.nom = sonNom;
	}
	
	public Personne setNom(String nom){
		this.nom = nom;
		return this;
	}
	
	public void setPrenom(String prenom){
		this.prenom = prenom;
	}
	
	public String getPrenom(){
		return prenom;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getIdentite(){
		return this.prenom + " " + this.nom + " (" + this.age + ")";
	}
	
	public String getIdentite(String type){
		if(type == "tout"){
			return this.getIdentite();
		} else{
			if(type == "nomprenom"){
				return this.nom + " " + this.prenom;
			} else {
				if(type == "prenomnom"){
					return this.prenom + " " + this.nom;
				}
			}
		}
		
		// Je me plante... je retourne tout quand même
		return this.getIdentite();
	}
	
	/**
	 * Retourne le nom alloué à l'instance courante de Personne
	 * @return
	 */
	public String getNom(){
		return this.nom;
	}
}
