package calendrier;

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class GenererCalendrier {

	public static void main(String[] args) {
		JoursFeries joursferies = new JoursFeries();
		
		// Une variable pour r�cup�rer l'ann�e courante...
		GregorianCalendar today = new GregorianCalendar();
		int anneeCourante = today.get(GregorianCalendar.YEAR);
		
		// Une variable qui me permet de continuer jusqu'� ce que...
		boolean nextJourFerie = true;
		
		// On lance une boucle pour alimenter tous nos jours f�ri�s
		while(nextJourFerie){
			String leJour = JOptionPane.showInputDialog("Jour f�ri� :");
			
			if(leJour == null){
				nextJourFerie = false; // Pour sortir de la boucle
			} else {
				// On a un nouveau jour feri�... on demande le jour et le mois
				String jourEtMois = JOptionPane.showInputDialog("Jour et mois (jj/mm) :");
				int[] dateParts = Utils.parseDate(jourEtMois, '/');
				
				joursferies.hydrate(leJour, new GregorianCalendar(anneeCourante, dateParts[1], dateParts[0]));
			}
		}
		
		JOptionPane.showMessageDialog(null, joursferies);
	}

}
