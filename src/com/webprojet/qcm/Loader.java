package com.webprojet.qcm;

public class Loader {

	public static void main(String[] args) {
		/**
		 * Je fais une instance de la classe Personne
		 *  et dans la foul�e, je lui dis qu'elle s'appelle St�phanie
		 */
		Personne personne = new Personne("Anne-C�cile");
		Personne jp = new Personne("Jean-Philippe");
		
		// J'aimerais dire Bonjour � St�phanie
		// On va donc instancier la classe BonjourQui qui est la seule
		//	� savoir dire Bonjour... � une Personne
		BonjourQui salut = new BonjourQui();
		
		// Okay Java, mon instance salut de BonjourQui est pr�te. Il faudrait d�finir � qui donc elle peut bien dire bonjour
		salut.setPersonne(personne);
		
		// Super "salut", maintenant soit poli et dit bonjour � la dame...
		salut.sayHello();
		
		// Eh... t'aurais pas oubli� Jean-Philippe ???
		salut.setPersonne(jp);
		salut.sayHello();
		

	}

}
