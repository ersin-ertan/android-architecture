package com.nullcognition.dagger2.modules;
// ersin 05/09/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.dagger2.apis.MySingleton;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

// base example of a single providable singleton

@Module
public class ModuleSingleton{

	@Provides @Singleton
	public MySingleton provideMySingleton(){return new MySingleton(); }
}
