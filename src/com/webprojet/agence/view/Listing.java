package com.webprojet.agence.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.webprojet.agence.visite.Visite;
import com.webprojet.agence.visite.Visites;

public class Listing {
	private Visites visites;
	
	
	public void visites(Visites visites){
		this.visites = visites;
	}
	
	public void showListing(){
		/**
		 * Instance d'une Frame Java pour l'affichage des visites
		 */
		final JFrame fenetre = new JFrame("Visites");
		
		/**
		 * D�finition des en-t�te de la liste � afficher
		 */
		String[] colonnes = {"Date", "Visiteur", "Bien"};
		
		/**
		 * Instance du mod�le de tableau pour l'affichage des visites
		 */
		final DefaultTableModel modele = new DefaultTableModel(colonnes, 0);
		
		/**
		 * Instance d'un tableau � partir du mod�le d�fini
		 */
		JTable tableau = new JTable(modele);
		
		/**
		 * Ajoute le tableau dans un "panneau" avec ascenseurs
		 */
		fenetre.getContentPane().add(new JScrollPane(tableau));
		
		/**
		 * On ajoute les lignes dans le tableau � pr�senter
		 */
		for(final Visite visite : this.visites.visites()){
			modele.addRow(
					new String[] {visite.date(), visite.getPersonne(), visite.getBien()}
			);
		}
		
		/**
		 * Une option pour quitter l'application
		 */
		JMenuItem menuQuitter = new JMenuItem("Quitter", 'Q');
		menuQuitter.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event){
						if(JOptionPane.showConfirmDialog(fenetre, "Vous partez d�j� ?", "Quitter", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
							System.exit(0);
						}
					}
				}
		);
		JMenuBar barreMenu = new JMenuBar();
		fenetre.setJMenuBar(barreMenu);
		JMenu menuFichier = new JMenu("Fichier");
		menuFichier.add(menuQuitter);
		barreMenu.add(menuFichier);
		/**
		 * Affichage proprement dit de la fen�tre
		 */
		fenetre.setSize(500, 300);
		fenetre.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		fenetre.setVisible(true);
	}
}
