/**
 * 
 */
package calendrier;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author DaCodeManiak
 *
 */
public class Anniversaire {
	private String nom;
	private GregorianCalendar date;
	
	public Anniversaire(String nom, GregorianCalendar date){
		this.nom = nom;
		this.date = date;
	}
	
	public String toString(){
		return "L'anniversaire de " + this.nom + " est le " + this.humanize();
	}
	
	private String humanize(){
		Date localDate;
		
		// Injecter dans la variable date, la valeur de l'attribut date converti
		localDate = this.date.getTime();
		
		// Définir le format de sortie... DateFormat
		DateFormat format = DateFormat.getDateInstance(DateFormat.FULL);
		
		// Utiliser la méthode "format()" de l'objet de type DateFormat
		return format.format(localDate);
	}
	
}
