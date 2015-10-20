package com.nullcognition.template00.di.application;
// ersin 17/10/15 Copyright (c) 2015+ All rights reserved.


import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Provides;

public class App extends Application{

	public final com.nullcognition.template00.di.activity.DaggeredActivity.ComponentHolder activityComponentHolder =
			new com.nullcognition.template00.di.activity.DaggeredActivity.ComponentHolder();
	private Component app;

	public static App get(Context context){return (App) context.getApplicationContext();}

	public Component getAppComponent(){return app;}

	@Override public void onCreate(){
		super.onCreate();
		if(app == null){
			app = DaggerApp_Component.builder().module(new Module(this)).build();
		}
		app.inject(this);
	}

	@Singleton
	@dagger.Component(modules = { App.Module.class }) public interface Component{

		void inject(App app);

		com.nullcognition.template00.di.activity.DaggeredActivity.ActivityComponent plus(com.nullcognition.template00.di.activity.DaggeredActivity.Module activityModule);
	}


	@dagger.Module public static class Module{

		final private Application app;

		public Module(App a){app = a;}

		@Singleton
		@Provides public Application provideApplication(){return app;}
	}
}

