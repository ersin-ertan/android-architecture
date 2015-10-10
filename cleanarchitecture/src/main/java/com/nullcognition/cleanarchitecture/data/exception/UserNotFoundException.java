package com.nullcognition.cleanarchitecture.data.exception;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


public class UserNotFoundException extends Exception{

	public UserNotFoundException(){
		super();
	}

	public UserNotFoundException(final String message){
		super(message);
	}

	public UserNotFoundException(final String message, final Throwable cause){
		super(message, cause);
	}

	public UserNotFoundException(final Throwable cause){
		super(cause);
	}
}
