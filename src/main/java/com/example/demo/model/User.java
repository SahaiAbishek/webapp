package com.example.demo.model;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String provFirstName;
	private String provLastName;

	public String getProvFirstName() {
		return provFirstName;
	}

	public void setProvFirstName(String provFirstName) {
		this.provFirstName = provFirstName;
	}

	public String getProvLastName() {
		return provLastName;
	}

	public void setProvLastName(String provLastName) {
		this.provLastName = provLastName;
	}

}
