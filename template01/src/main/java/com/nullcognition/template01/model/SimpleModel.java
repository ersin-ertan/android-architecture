package com.nullcognition.template01.model;
// ersin 23/10/15 Copyright (c) 2015+ All rights reserved.


public class SimpleModel{

	private String firstName;
	private String lastName;

	public SimpleModel(String fn, String ln){
		firstName = fn;
		lastName = ln;
	}

	public String getFirstName(){ return firstName;}

	public String getLastName(){ return lastName;}

	public void setFirstName(final String firstName){ this.firstName = firstName;}

	public void setLastName(final String lastName){this.lastName = lastName;}
}
