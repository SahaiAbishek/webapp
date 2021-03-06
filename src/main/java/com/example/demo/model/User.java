package com.example.demo.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String provFirstName;
	private String provLastName;
	private MultipartFile myfile;

	public MultipartFile getMyfile() {
		return myfile;
	}

	public void setMyfile(MultipartFile myfile) {
		this.myfile = myfile;
	}

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
