/**
 * 
 */
package calendrier;

import java.util.ArrayList;

/**
 * @author DaCodeManiak
 *
 */
public class MonCalendrier {
	private ArrayList<Dates> moncalendrier;
	
	public MonCalendrier(){
		this.moncalendrier = new ArrayList<Dates>();
	}
	
	public MonCalendrier add(Dates date){
		this.moncalendrier.add(date);
		return this;
	}
}
