package com.nullcognition.cleanarchitecture.data.exception;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.cleanarchitecture.domain.exception.ErrorBundle;

public class RepositoryErrorBundle implements ErrorBundle{

	private final Exception exception;

	public RepositoryErrorBundle(Exception exception){
		this.exception = exception;
	}

	@Override
	public Exception getException(){
		return exception;
	}

	@Override
	public String getErrorMessage(){
		String message = "";
		if(this.exception != null){
			this.exception.getMessage();
		}
		return message;
	}
}
