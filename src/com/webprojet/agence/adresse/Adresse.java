package com.webprojet.agence.adresse;

public class Adresse {
	protected String numRue;
	protected String nomRue;
	protected String cplRue;
	protected String codePostal;
	protected String ville;
	/**
	 * @return the numRue
	 */
	public String numRue() {
		return this.numRue;
	}
	/**
	 * @param numRue the numRue to set
	 */
	public Adresse numRue(String numRue) {
		this.numRue = numRue;
		return this;
	}
	/**
	 * @return the nomRue
	 */
	public String nomRue() {
		return this.nomRue;
	}
	/**
	 * @param nomRue the nomRue to set
	 */
	public Adresse nomRue(String nomRue) {
		this.nomRue = nomRue;
		return this;
	}
	/**
	 * @return the cplRue
	 */
	public String cplRue() {
		return this.cplRue;
	}
	/**
	 * @param cplRue the cplRue to set
	 */
	public Adresse cplRue(String cplRue) {
		this.cplRue = cplRue;
		return this;
	}
	/**
	 * @return the codePostal
	 */
	public String codePostal() {
		return this.codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public Adresse codePostal(String codePostal) {
		this.codePostal = codePostal;
		return this;
	}
	/**
	 * @return the ville
	 */
	public String ville() {
		return this.ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public Adresse ville(String ville) {
		this.ville = ville;
		return this;
	}
	
	
}
