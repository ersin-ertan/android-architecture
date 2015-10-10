package com.nullcognition.cleanarchitecture.presentation.exception;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import android.content.Context;

import com.nullcognition.cleanarchitecture.R;
import com.nullcognition.cleanarchitecture.data.exception.NetworkConnectionException;
import com.nullcognition.cleanarchitecture.data.exception.UserNotFoundException;

public class ErrorMessageFactory{

	private ErrorMessageFactory(){ throw new IllegalAccessError();}

	public static String create(Context context, Exception exception){

		String message = context.getString(R.string.exception_message_generic);

		if(exception instanceof NetworkConnectionException){
			message = context.getString(R.string.exception_message_no_connection);
		}
		else if(exception instanceof UserNotFoundException){
			message = context.getString(R.string.exception_message_user_not_found);
		}
		return message;
	}
}
