package com.webprojet.string.utils;

public class StringUtils {
	public String chaine;
	
	public String replace(String search, String replace){
		String returnValue = "";			
		if(this.chaine.contains("\n")){
			for(int indice = 0; indice < this.chaine.length(); indice++){
				if(search.equals(this.chaine.substring(indice,indice+1))){
					returnValue += "<br>";
					indice++;
				} else {
					returnValue += this.chaine.substring(indice, indice+1);
				}
			}
		} else {
			returnValue = this.chaine;
		}
		return returnValue;
	}		
}
