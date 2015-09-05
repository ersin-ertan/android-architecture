package com.nullcognition.dagger2.apis;
// ersin 05/09/15 Copyright (c) 2015+ All rights reserved.


public class MyClass01 extends MyClass00{

	private static int count = 0;
	private final  int id    = count++;
	public String getId(){return this.getClass().getSimpleName()+" as Singleton "+ ":"+id ;}
}
