package com.nullcognition.cleanarchitecture.presentation;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import android.app.Application;

import com.nullcognition.cleanarchitecture.presentation.internal.di.components.ApplicationComponent;
import com.nullcognition.cleanarchitecture.presentation.internal.di.components.DaggerApplicationComponent;
import com.nullcognition.cleanarchitecture.presentation.internal.di.modules.ApplicationModule;

public class AndroidApplication extends Application{

	private ApplicationComponent applicationComponent;

	@Override public void onCreate(){
		super.onCreate();
		initInjector();
	}
	private void initInjector(){
		if(applicationComponent == null){
			applicationComponent =  DaggerApplicationComponent.builder()
			                                                 .applicationModule(new ApplicationModule(this))
			                                                 .build();
		}
	}

	public ApplicationComponent getApplicationComponent(){ return applicationComponent; }
}
