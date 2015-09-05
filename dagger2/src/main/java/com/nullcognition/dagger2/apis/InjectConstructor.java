package com.nullcognition.dagger2.apis;
// ersin 05/09/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.dagger2.sopes.ScopeCustom;

import javax.inject.Inject;

@ScopeCustom // optional if needed
public class InjectConstructor extends MyClass00{

	@Inject public InjectConstructor(){}

	private static int count = 0;
	private final  int id    = count++;
	public String getId(){return this.getClass().getSimpleName() + " as non provided Singleton " + ":" + id;}
	// non provided from module because it uses constructor injection in the class itself

}
