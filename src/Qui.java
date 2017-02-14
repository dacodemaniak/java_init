/**
 * 
 */

/**
 * @author DaCodeManiak
 *
 */
public class Qui {
	protected String nom;
	protected String prenom;
	
	public void presenteToi(){
		System.out.println("Bonjour " + this.prenom + " " + this.nom);
	}
	
	public void setNom(String nom){
		this.nom = nom;
		return;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public void setPrenom(String prenom){
		this.prenom = prenom;
	}
	
	public String getPrenom(){
		return this.prenom;
	}
	
}
