/**
 * 
 */
package com.in28minutes.rest.basic.auth;

/**
 * @author SU20005775
 *
 */
public class AuthenticationBean {
	private String message;

	public AuthenticationBean() {
	}
	public AuthenticationBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("HelloWorldBean [message=%s]", message);
	}
	
	

}
