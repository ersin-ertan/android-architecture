package com.nullcognition.cleanarchitecture.domain.exception;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


public interface ErrorBundle{

	Exception getException();
	String getErrorMessage();
}
