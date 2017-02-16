package com.webprojet.qcm;

public class Arithmetics {
	
	public int getAddition(int operande1, int operande2){
		return this.addition(operande1, operande2);
	}
	
	public int getAddition(){
		return this.addition();
	}
	
	/**
	 * M�thode addition()
	 * @return int (Mais qui sera toujours le r�sultat de 2 + 3)
	 */
	private int addition(){
		int resultat;
		int operande1;
		int operande2;
		
		// Faisons l'addition elle-m�me
		operande1 = 2;
		operande2 = 3;
		
		resultat = operande1 + operande2;
		
		return resultat;
	}
	
	private int addition(int operande1, int operande2){
		int resultat;
		
		// Faisons l'addition, mais cette fois avec des valeurs pass�es en param�tre
		resultat = operande1 + operande2;
		
		return resultat;
	}
}
