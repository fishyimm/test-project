package com.example.demo.bean.req;

import java.io.Serializable;

public class RegisterReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4119779149424276439L;
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "RegisterReq [email=" + email + ", password=" + password + "]";
	}

}
