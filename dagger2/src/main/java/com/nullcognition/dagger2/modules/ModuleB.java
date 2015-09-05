package com.nullcognition.dagger2.modules;
// ersin 05/09/15 Copyright (c) 2015+ All rights reserved.

import com.nullcognition.dagger2.apis.MyClass03;
import com.nullcognition.dagger2.apis.InjectConstructor;
import com.nullcognition.dagger2.sopes.ScopeCustom;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

// showcasing multiple provideables


@Module
public class ModuleB{

	@Provides @ScopeCustom
	public MyClass03 provideMyClass03(){return new MyClass03();}

//	@Provides InjectConstructor provideConstorInject(){return new InjectConstructor();}
// not needed because the constructor was injected, providing downstream injecting capabilities
}
