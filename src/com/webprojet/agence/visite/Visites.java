package com.webprojet.agence.visite;

import java.util.ArrayList;

public class Visites {
	private ArrayList<Visite> visites;
	
	public Visites(){
		this.visites = new ArrayList<Visite>();
	}
	
	public void add(Visite visite){
		this.visites.add(visite);
	}
	
	public ArrayList<Visite> visites(){
		return this.visites;
	}
	
	public Visite get(int indice){
		if(indice > this.visites.size()){
			return this.visites.get(0);
		}
		
		return this.visites.get(indice);
	}
}
