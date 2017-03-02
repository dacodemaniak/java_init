/**
 * 
 */
package com.webprojet.persistence.test;

import com.webprojet.persistence.SGBDSetup;

/**
 * @author DaCodeManiak
 *
 */
public class ReservationSetup extends SGBDSetup {
	public ReservationSetup(){
		this.dbName = "reservation";
		this.userName = "resa_db_user";
		this.userPassword = "Re5@DM1n";
		this.port = "3306";
		this.host = "127.0.0.1";
		this.type = "mysql";
	}
}
