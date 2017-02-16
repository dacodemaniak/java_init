package com.webprojet.qcm;

public class Loader {

	public static void main(String[] args) {
		/**
		 * Je fais une instance de la classe Personne
		 *  et dans la foulée, je lui dis qu'elle s'appelle Stéphanie
		 */
		Personne personne = new Personne("Anne-Cécile");
		Personne jp = new Personne("Jean-Philippe");
		
		// J'aimerais dire Bonjour à Stéphanie
		// On va donc instancier la classe BonjourQui qui est la seule
		//	à savoir dire Bonjour... à une Personne
		BonjourQui salut = new BonjourQui();
		
		// Okay Java, mon instance salut de BonjourQui est prête. Il faudrait définir à qui donc elle peut bien dire bonjour
		salut.setPersonne(personne);
		
		// Super "salut", maintenant soit poli et dit bonjour à la dame...
		salut.sayHello();
		
		// Eh... t'aurais pas oublié Jean-Philippe ???
		salut.setPersonne(jp);
		salut.sayHello();
		

	}

}
