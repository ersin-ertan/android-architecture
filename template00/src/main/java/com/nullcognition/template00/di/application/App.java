package com.nullcognition.template00.di.application;
// ersin 17/10/15 Copyright (c) 2015+ All rights reserved.


import android.app.Application;
import android.content.Context;

import com.nullcognition.template00.di.activity.DaggeredActivity;

import javax.inject.Singleton;

import dagger.Provides;

public class App extends Application{

	private Component app;
	public Component getAppComponent(){return app;}

	public final DaggeredActivity.ComponentHolder activityComponentHolder =
			new DaggeredActivity.ComponentHolder();

	public static App get(Context context){return (App) context.getApplicationContext();}

	@Override public void onCreate(){
		super.onCreate();
		if(app == null){
			app = DaggerApp_Component.builder().module(new Module(this)).build();
		}
		app.inject(this);
	}


	@Singleton @dagger.Component(modules = { App.Module.class }) public interface Component{

		void inject(App app);

		DaggeredActivity.ActivityComponent plus(DaggeredActivity.Module activityModule);
	}


	@dagger.Module public static class Module{

		final private Application app;
		public Module(App a){app = a;}

		@Provides public Application provideApplication(){return app;}
	}
}

