/**
 * 
 */
package com.webprojet.persistence;

import java.sql.Connection;

/**
 * @author DaCodeManiak
 *
 */
public interface Connect {
	public void connect();
	public Connection get();
	public void disconnect();
}
