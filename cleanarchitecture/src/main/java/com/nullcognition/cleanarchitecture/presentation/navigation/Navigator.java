package com.nullcognition.cleanarchitecture.presentation.navigation;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import android.content.Context;
import android.content.Intent;

import com.nullcognition.cleanarchitecture.presentation.view.activity.UserDetailsActivity;
import com.nullcognition.cleanarchitecture.presentation.view.activity.UserListActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Navigator{

	@Inject
	public void Navigator(){
		//empty
	}

	public void navigateToUserList(Context context){
		if(context != null){
			Intent intentToLaunch = UserListActivity.getCallingIntent(context);
			context.startActivity(intentToLaunch);
		}
	}

	public void navigateToUserDetails(Context context, int userId){
		if(context != null){
			Intent intentToLaunch = UserDetailsActivity.getCallingIntent(context, userId);
			context.startActivity(intentToLaunch);
		}
	}
}
