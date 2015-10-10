package com.nullcognition.cleanarchitecture.presentation.internal.di.modules;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import android.app.Activity;

import com.nullcognition.cleanarchitecture.presentation.internal.di.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module public class ActivityModule{

	private final Activity activity;

	public ActivityModule(Activity activity){
		this.activity = activity;
	}

	@PerActivity
	@Provides Activity provideActivity(){
		return activity;
	}
}
