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
	public int getLastId(String tableName);
	public int getLastId(String tableName, String primaryKeyName);
}
