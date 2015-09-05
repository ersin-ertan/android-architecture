package com.nullcognition.dagger2.apis;
// ersin 05/09/15 Copyright (c) 2015+ All rights reserved.


import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton // optional if needed
public class InjectConstructor extends MyClass00{

	@Inject public InjectConstructor(){}

	private static int count = 0;
	private final int id    = count++;
	public String getId(){return this.getClass().getSimpleName() +" as non provided Singleton "+ ":" + id;}

}
