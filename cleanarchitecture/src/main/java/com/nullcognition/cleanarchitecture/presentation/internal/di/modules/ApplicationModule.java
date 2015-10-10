package com.nullcognition.cleanarchitecture.presentation.internal.di.modules;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.

import android.content.Context;

import com.nullcognition.cleanarchitecture.data.cache.UserCache;
import com.nullcognition.cleanarchitecture.data.cache.UserCacheImpl;
import com.nullcognition.cleanarchitecture.data.executor.JobExecutor;
import com.nullcognition.cleanarchitecture.data.repository.UserDataRepository;
import com.nullcognition.cleanarchitecture.domain.executor.PostExecutionThread;
import com.nullcognition.cleanarchitecture.domain.executor.ThreadExecutor;
import com.nullcognition.cleanarchitecture.domain.repository.UserRepository;
import com.nullcognition.cleanarchitecture.presentation.AndroidApplication;
import com.nullcognition.cleanarchitecture.presentation.UIThread;
import com.nullcognition.cleanarchitecture.presentation.navigation.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module public class ApplicationModule {

	private final AndroidApplication application;

	public ApplicationModule(AndroidApplication application){
		this.application = application;
	}

	@Provides @Singleton Context provideApplicationContext(){
		return this.application;
	}

	@Provides @Singleton Navigator provideNavigator(){
		return new Navigator();
	}

	@Provides @Singleton ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
		return jobExecutor;
	}

	@Provides @Singleton PostExecutionThread providePostExecutionThread(UIThread uiThread) {
		return uiThread;
	}

	@Provides @Singleton UserCache provideUserCache(UserCacheImpl userCache) {
		return userCache;
	}

	@Provides @Singleton UserRepository provideUserRepository(UserDataRepository userDataRepository) {
		return userDataRepository;
	}
}
