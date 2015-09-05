package com.nullcognition.dagger2.apis;
// ersin 05/09/15 Copyright (c) 2015+ All rights reserved.


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MyClass03 extends MyClass00{

	private static int count = 0;
	private final  int id    = count++;
	public String getId(){return this.getClass().getSimpleName() + ":" + id;}
	@Inject public void methodInjection(Broadcaster brocaster){
		brocaster.register(this);
	}

	public static class Broadcaster{

		List<MyClass03> listeners = new ArrayList<>(1);
		public void register(MyClass03 myClass03){
			listeners.add(myClass03);
		}
	}

}
