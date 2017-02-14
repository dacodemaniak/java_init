/**
 * 
 */

/**
 * @author DaCodeManiak
 *
 */
public class Personne {
	/**
	 * @var byte age : Age de la personne courante
	 */
	private byte age;
	
	/**
	 * @var String nom
	 */
	private String nom;
	
	/**
	 * @var 7
	 * String prenom;
	 */
	private String prenom;
	
	/**
	 * Constructeur : porte le m�me nom que le nom de la Classe
	 * Ne retourne rien... surtout pas void !!!
	 */
	public Personne(){
		this.age = 18;
		this.nom = "Le Fant�me";
		this.prenom = "Casper";
	}
	
	public Personne(int age, String nom, String prenom){
		this.age = (byte) age;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	/**
	 * D�finit l'�ge de la personne
	 * @param age
	 */
	public void setAge(byte age){
		this.age = age;
	}
	
	/**
	 * Retourne l'�ge de la personne dans l'instance courante de Personne
	 * @return byte
	 */
	public byte getAge(){
		return this.age;
	}
	
	/**
	 * D�finit la valeur de l'attribut nom de l'instance courante de Personne
	 * @param nom
	 */
	public void setNom(String nom){
		this.nom = nom;
	}
	
	/**
	 * Retourne la valeur de l'attribut nom de l'instance courante
	 * @return
	 */
	public String getNom(){
		return this.nom;
	}
	
	/**
	 * D�finit la valeur de l'attribut nom de l'instance courante
	 * @param nom
	 * Equivalent � un setter mais cha�nable... return this;
	 */
	public Personne nom(String nom){
		this.nom = nom;
		return this;
	}
	
	public String nom(){
		return this.nom;
	}
	
	public Personne prenom(String prenom){
		this.prenom = prenom;
		return this;
	}
	
	public String prenom(){
		return this.prenom;
	}
	
	public Personne age(int age){
		this.age = (byte) age; // On caste age pour faciliter les choses
		return this;
	}
	
	public byte age(){
		return this.age;
	}
	/**
	 * D�finit l'attribut nom de l'instance courante de Personne
	 * @param prenom
	 */
	public void setPrenom(String prenom){
		this.prenom = prenom;
	}
	
	public String getPrenom(){
		return this.prenom;
	}
	
	
}
