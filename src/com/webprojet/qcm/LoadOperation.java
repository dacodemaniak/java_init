package com.webprojet.qcm;

public class LoadOperation {

	public static void main(String[] args) {
		// Test des appels de méthodes de la classe Arithmetics
		Arithmetics operations = new Arithmetics();
		
		// On invoque la méthode addition() sans paramètres
		System.out.println("Résultat de la méthode addition() sans paramètre : " + operations.getAddition());
		
		// Invoquons la méthode cette fois avec des paramètres
		System.out.println("Résultat de la méthode addition() avec paramètres :" + operations.getAddition(10,25));
		System.out.println("Résultat de la méthode addition() avec paramètres :" + operations.getAddition(153,212));
	}

}
