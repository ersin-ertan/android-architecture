package com.nullcognition.dagger2.modules;
// ersin 05/09/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.dagger2.apis.MyClass01;
import com.nullcognition.dagger2.apis.MyClass02;
import com.nullcognition.dagger2.sopes.ScopeCustom;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleA{

	@Provides @ScopeCustom @Named("default") // creates two different instances
	public MyClass01 provideMyClass01(){return new MyClass01();}

	@Provides @ScopeCustom @Named("another") // creates two different instances
	public MyClass01 provideAnotherMyClass01(){return new MyClass01();}

	@Provides @ScopeCustom @Named("lazy") // creates two different instances
	public MyClass01 provideLazyMyClass01(){return new MyClass01();}


	@Provides MyClass02 provideMyClass02(){return new MyClass02();}
}
