/**
 * 
 */
package com.webprojet.persistence;

/**
 * @author DaCodeManiak
 *
 */
public interface Setup {
	public void dbName(String dbName);
	public String dbName();
	
	public void userName(String userName);
	public String userName();
	
	public void userPassword(String password);
	public String userPassword();
	
	public void serverHost(String host);
	public String serverHost();
	
	public void serverPort(String port);
	public String serverPort();
	
	public void serverType(String type);
	public String serverType();
}
