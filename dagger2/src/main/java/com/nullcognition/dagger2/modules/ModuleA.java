package com.nullcognition.dagger2.modules;
// ersin 05/09/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.dagger2.apis.MyClass01;
import com.nullcognition.dagger2.apis.MyClass02;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleA{

	@Provides @Singleton
	public MyClass01 provideMyClass01(){return new MyClass01();}

	@Provides MyClass02 provideMyClass02(){return new MyClass02();}
}
