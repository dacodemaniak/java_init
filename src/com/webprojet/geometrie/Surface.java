/**
 * 
 */
package com.webprojet.geometrie;

/**
 * @author DaCodeManiak
 *
 */
public class Surface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(5, 3, "Orange");
		Cercle cercle = new Cercle((float) 0.5, "Rouge");
		
		System.out.println(rectangle.toString());
		System.out.println(cercle.toString());

	}

}
