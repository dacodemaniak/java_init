/**
 * 
 */
package calendrier;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author DaCodeManiak
 *
 */
public class Anniversaires extends Dates implements GenericAnniversaire {
	private ArrayList<Anniversaire> listeAnniversaires;
	
	public Anniversaires(){
		this.listeAnniversaires = new ArrayList<Anniversaire>();
	}
	
	private Anniversaires setAnniversaire(Anniversaire anniversaire){
		this.listeAnniversaires.add(anniversaire);
		return this;
	}
	
	private Anniversaires setAnniversaire(String nom, GregorianCalendar date){
		this.listeAnniversaires.add(new Anniversaire(nom, date));
		return this;
	}

	@Override
	public void hydrate(String libelle, GregorianCalendar date) {
		this.setAnniversaire(libelle, date);
		
	}

	@Override
	public void hydrate(Anniversaire anniversaire) {
		this.setAnniversaire(anniversaire);
	}
	
}
