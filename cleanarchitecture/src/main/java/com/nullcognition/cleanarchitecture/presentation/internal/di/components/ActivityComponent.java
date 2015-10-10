package com.nullcognition.cleanarchitecture.presentation.internal.di.components;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import android.app.Activity;

import com.nullcognition.cleanarchitecture.presentation.internal.di.PerActivity;
import com.nullcognition.cleanarchitecture.presentation.internal.di.modules.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
	//Exposed to sub-graphs.
	Activity activity();
}
