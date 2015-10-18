package com.nullcognition.template00.di.di.navigator;
// ersin 18/10/15 Copyright (c) 2015+ All rights reserved.


import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.nullcognition.template00.di.di.application.App;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Navigator{

	public final App app;

	@Inject public Navigator(final Application app){ this.app = (App) app; }

	// is this needed
		public void switchActivity(Class<? extends AppCompatActivity> dest){
		Intent i = new Intent(app.getApplicationContext(), dest);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		app.startActivity(i);
	}


}
