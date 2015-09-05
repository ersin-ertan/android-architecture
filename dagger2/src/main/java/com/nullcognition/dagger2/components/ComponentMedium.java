package com.nullcognition.dagger2.components;
// ersin 05/09/15 Copyright (c) 2015+ All rights reserved.

import com.nullcognition.dagger2.MainActivity;
import com.nullcognition.dagger2.modules.ModuleA;
import com.nullcognition.dagger2.modules.ModuleB;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ModuleA.class, ModuleB.class })
public interface ComponentMedium{

	void mediumsInject(MainActivity mainActivity);
}
