package com.project.jwt;

import java.io.Serializable;

public class JwtNegResponse  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final String error;
	
	 public JwtNegResponse(String error) {
	        this.error = error;
	    }

	public String getError() {
		return error;
	}
	

}