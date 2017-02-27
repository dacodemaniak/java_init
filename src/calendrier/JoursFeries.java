/**
 * 
 */
package calendrier;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author DaCodeManiak
 *
 */
public class JoursFeries extends Dates implements GenericCalendrier {
	private HashMap<String,GregorianCalendar> joursferies;
	
	public JoursFeries(){
		this.joursferies = new HashMap<String,GregorianCalendar>();
	}
	
	private JoursFeries ajout(String nom, GregorianCalendar date){
		this.joursferies.put(nom, date);
		return this;
	}
	
	public void hydrate(String nom, GregorianCalendar date){
		this.ajout(nom, date);
	}
	
	public String toString(){
		String output = "Jours fériés : \n";
		
		// En utilisant un iterator
		Set<Entry<String, GregorianCalendar>> jours = this.joursferies.entrySet();
		@SuppressWarnings("rawtypes")
		Iterator iterator = jours.iterator();
		while(iterator.hasNext()){
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry)iterator.next();
			Date date = ((GregorianCalendar) entry.getValue()).getTime();
			DateFormat format = DateFormat.getDateInstance(DateFormat.FULL);
			output += entry.getKey() + " : " + format.format(date);
		}
		return output;
	}
}
