package com.nullcognition.rx_android_architecture;
// ersin 10/10/15 Copyright (c) 2015+ All rights reserved.


import android.app.Application;
import android.content.Context;

import com.nullcognition.rx_android_architecture.injections.ApplicationModule;
import com.nullcognition.rx_android_architecture.utils.ApplicationInsturmentation;

import javax.inject.Inject;

public class RxBookApp extends Application{

	@Inject ApplicationInsturmentation applicationInsturmentation;

	public static RxBookApp get(Context context){return (RxBookApp) context.getApplicationContext();}

	ApplicationComponent applicationComponent;
	public ApplicationComponent getApplicationComponent(){return applicationComponent;}

	@Override public void onCreate(){
		super.onCreate();

		if(applicationComponent == null){
//			applicationComponent =
//					DaggerApplicationComponent.build()
//					                          .applicationModule(new ApplicationModule(this))
//					                          .build();
		}
		// do we need to inject this? or is the graph fulfilled in the top level?
	}
}
