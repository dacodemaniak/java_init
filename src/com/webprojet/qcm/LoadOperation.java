package com.webprojet.qcm;

public class LoadOperation {

	public static void main(String[] args) {
		// Test des appels de m�thodes de la classe Arithmetics
		Arithmetics operations = new Arithmetics();
		
		// On invoque la m�thode addition() sans param�tres
		System.out.println("R�sultat de la m�thode addition() sans param�tre : " + operations.getAddition());
		
		// Invoquons la m�thode cette fois avec des param�tres
		System.out.println("R�sultat de la m�thode addition() avec param�tres :" + operations.getAddition(10,25));
		System.out.println("R�sultat de la m�thode addition() avec param�tres :" + operations.getAddition(153,212));
	}

}
