package com.nullcognition.cleanarchitecture.presentation.internal.di.components;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import android.content.Context;

import com.nullcognition.cleanarchitecture.domain.executor.PostExecutionThread;
import com.nullcognition.cleanarchitecture.domain.executor.ThreadExecutor;
import com.nullcognition.cleanarchitecture.domain.repository.UserRepository;
import com.nullcognition.cleanarchitecture.presentation.internal.di.modules.ApplicationModule;
import com.nullcognition.cleanarchitecture.presentation.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent{

	void inject(BaseActivity baseActivity);

	//Exposed to sub-graphs.
	Context context();
	ThreadExecutor threadExecutor();
	PostExecutionThread postExecutionThread();
	UserRepository userRepository();
}
