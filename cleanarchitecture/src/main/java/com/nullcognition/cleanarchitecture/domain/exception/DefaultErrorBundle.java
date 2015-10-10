package com.nullcognition.cleanarchitecture.domain.exception;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


public class DefaultErrorBundle implements ErrorBundle{

	public static final String DEFAULT_ERROR_MSG = "unknown error";
	private final Exception exception;

	public DefaultErrorBundle(final Exception exception){this.exception = exception;}

	@Override public Exception getException(){ return exception;}

	@Override public String getErrorMessage(){
		return (exception != null) ? exception.getMessage() : DEFAULT_ERROR_MSG;
	}
}
