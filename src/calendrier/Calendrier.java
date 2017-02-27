/**
 * 
 */
package calendrier;

import java.util.GregorianCalendar;

/**
 * @author DaCodeManiak
 *
 */
public class Calendrier {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GregorianCalendar today = new GregorianCalendar();
		
		MonCalendrier calendrier = new MonCalendrier();
		
		JoursFeries joursferies = new JoursFeries();
		joursferies.hydrate("newyearday", 
				new GregorianCalendar(today.get(GregorianCalendar.YEAR),
				0, 
				1)
		);
		joursferies.hydrate("travail", new GregorianCalendar(today.get(GregorianCalendar.YEAR),
				4,
				1)
		);
		joursferies.hydrate("ww2", new GregorianCalendar(today.get(GregorianCalendar.YEAR),
				4,
				8)
		);
		joursferies.hydrate("fetenat", new GregorianCalendar(today.get(GregorianCalendar.YEAR),
				6,
				14)
		);
		
		// Quelques anniversaires...
		Anniversaires liste = new Anniversaires();
		liste.hydrate("Jean-Luc", new GregorianCalendar(1968,3,30));
		
		Anniversaire clelie = new Anniversaire("Clélie", new GregorianCalendar(2012,2,8));
		liste.hydrate(clelie);
		
		// Ajoutons un nouveau jour férié
		joursferies.hydrate("armistice", new GregorianCalendar(today.get(GregorianCalendar.YEAR),
				10,
				11)
		);
		
		// On peut ajouter un peu tout à "calendrier"
		calendrier.add(joursferies).add(liste);
	}

}
