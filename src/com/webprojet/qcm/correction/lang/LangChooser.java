/**
 * 
 */
package com.webprojet.qcm.correction.lang;

import java.util.ArrayList;
import com.webprojet.qcm.correction.*;

/**
 * @author DaCodeManiak
 *
 */
public class LangChooser {
	private String lng;
	
	public LangChooser(String lng){
		this.lng = lng;
	}
	
	public Hello sayHello(){
		
		switch(this.lng){
			case "fr":
				return new HelloFr();
			
			case "en":
				return new HelloEn();
			
			default:
				return(new Hello());	
		}
	}
}
