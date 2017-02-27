/**
 * 
 */
package calendrier;

/**
 * @author DaCodeManiak
 *
 */
public class Utils {
	public static int[] parseDate(String input, char separator){
		
		int mois;
		int jour;
		
		// On commence par d�terminer la position du s�parateur dans la cha�ne input
		int positionSep = input.indexOf(separator);
		
		jour = Integer.parseInt(input.substring(0, positionSep));
		mois = Integer.parseInt(input.substring(positionSep+1));

		int[] dateParts = {jour, (mois - 1)};
		
		return dateParts;
	}
}
