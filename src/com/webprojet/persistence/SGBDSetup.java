/**
 * 
 */
package com.webprojet.persistence;

/**
 * @author DaCodeManiak
 *
 */
public abstract class SGBDSetup implements Setup {
	protected String dbName;
	protected String userName;
	protected String userPassword;
	protected String host;
	protected String port;
	protected String type;
	
	/* (non-Javadoc)
	 * @see com.webprojet.persistence.Setup#dbName(java.lang.String)
	 */
	@Override
	public void dbName(String dbName) {
		this.dbName = dbName;
	}

	/* (non-Javadoc)
	 * @see com.webprojet.persistence.Setup#dbName()
	 */
	@Override
	public String dbName() {
		// TODO Auto-generated method stub
		return this.dbName;
	}

	/* (non-Javadoc)
	 * @see com.webprojet.persistence.Setup#userName(java.lang.String)
	 */
	@Override
	public void userName(String userName) {
		this.userName = userName;

	}

	/* (non-Javadoc)
	 * @see com.webprojet.persistence.Setup#userName()
	 */
	@Override
	public String userName() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	/* (non-Javadoc)
	 * @see com.webprojet.persistence.Setup#userPassword(java.lang.String)
	 */
	@Override
	public void userPassword(String password) {
		// TODO Auto-generated method stub
		this.userPassword = password;

	}

	/* (non-Javadoc)
	 * @see com.webprojet.persistence.Setup#userPassword()
	 */
	@Override
	public String userPassword() {
		// TODO Auto-generated method stub
		return this.userPassword;
	}

	/* (non-Javadoc)
	 * @see com.webprojet.persistence.Setup#serverHost(java.lang.String)
	 */
	@Override
	public void serverHost(String host) {
		// TODO Auto-generated method stub
		if(host.equals("")){
			this.host = "127.0.0.1";
		} else {
			this.host = host;
		}
	}

	/* (non-Javadoc)
	 * @see com.webprojet.persistence.Setup#serverHost()
	 */
	@Override
	public String serverHost() {
		// TODO Auto-generated method stub
		return this.host;
	}

	/* (non-Javadoc)
	 * @see com.webprojet.persistence.Setup#serverPort(java.lang.String)
	 */
	@Override
	public void serverPort(String port) {
		this.port = port;

	}

	/* (non-Javadoc)
	 * @see com.webprojet.persistence.Setup#serverPort()
	 */
	@Override
	public String serverPort() {
		// TODO Auto-generated method stub
		return this.port;
	}

	/* (non-Javadoc)
	 * @see com.webprojet.persistence.Setup#serverType(java.lang.String)
	 */
	@Override
	public void serverType(String type) {
		this.type = type;

	}

	/* (non-Javadoc)
	 * @see com.webprojet.persistence.Setup#serverType()
	 */
	@Override
	public String serverType() {
		// TODO Auto-generated method stub
		return this.type;
	}

}
