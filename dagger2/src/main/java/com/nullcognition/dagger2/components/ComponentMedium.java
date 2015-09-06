package com.nullcognition.dagger2.components;
// ersin 05/09/15 Copyright (c) 2015+ All rights reserved.

import com.nullcognition.dagger2.MainActivity;
import com.nullcognition.dagger2.apis.InjectConstructor;
import com.nullcognition.dagger2.modules.ModuleA;
import com.nullcognition.dagger2.modules.ModuleB;
import com.nullcognition.dagger2.sopes.ScopeCustom;

import javax.inject.Singleton;

import dagger.Component;

@ScopeCustom
@Component(
// setting a dependency enforces that this components creation corresponds with an instance of the dependency
//		dependencies = ComponentSmall.class,
		modules = { ModuleA.class, ModuleB.class })
// thus components must explicitly provide their type for other dependencies to use

// having two @Singleton components does not work thus the need for custom scopes, if @Singleton is
// removed, then all of the @Singleton annotations in the moddules and @Provides must be removed
// meaning if a modules output is requested more than once, a new instance will be created

public interface ComponentMedium{

// because the type must be of MainActivity and parent/child do not work, your could implement an
// abstract class,in a base class, perform the injection there and implement it in a sub class
	void mediumsInject(MainActivity mainActivity);

	//	MyClass03 myClass03(); // is this needed if doing method injection, no. It sets the fields and the
	// methods with the above mediumsInject(MainActivity activity);
	InjectConstructor injectConstuctorClass();
}


// ** todo the trick to pass your self as the app...
