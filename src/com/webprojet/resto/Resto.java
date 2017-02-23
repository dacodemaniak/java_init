package com.webprojet.resto;

import javax.swing.JOptionPane;

public class Resto {
	public static void main(String[] args){
		Menu midi = new Menu();
		
		JOptionPane.showMessageDialog(null, midi.toString());
	}
}
