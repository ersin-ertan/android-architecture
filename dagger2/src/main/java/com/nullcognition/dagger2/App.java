package com.nullcognition.dagger2;
// ersin 05/09/15 Copyright (c) 2015+ All rights reserved.


import android.app.Application;

import com.nullcognition.dagger2.components.ComponentMedium;
import com.nullcognition.dagger2.components.DaggerComponentMedium;

//import com.nullcognition.dagger2.components.ComponentSmall;
//import com.nullcognition.dagger2.components.DaggerComponentSmall;
//import com.nullcognition.dagger2.modules.ModuleSingleton;

// tried using 2 components but did not work, to remove a component such that it does not interfere
// with compilation, uncomment the component's imports, class, and anything that is injected refering
// to the components ex. @Inject MySingleton ms; when MySingleton is @Component(module = ModuleSingleton.class)


public class App extends Application{

//	private ComponentSmall componentSmall;
//	public ComponentSmall getComponentSmall(){return componentSmall;}

	private ComponentMedium componentMedium;
	public ComponentMedium getComponentMedium(){return componentMedium;}

	@Override public void onCreate(){
		super.onCreate();

//		if(componentSmall == null){
//			componentSmall = DaggerComponentSmall.builder()
//			                                     .moduleSingleton(new ModuleSingleton())
//			                                     .build();
//		}


		if(componentMedium == null){
			componentMedium = DaggerComponentMedium.builder()
//			                                       .moduleA(new ModuleA())
// let dagger implicitly create them because no external state is required
// [ex. of external state new ModuleA("for user tom")]
// 	                                       .moduleB(new ModuleB())
					.build();
		}

//	if creating a component which has all modules implicitly create able, and you can use
//		DaggerMyComponentWithModulesAllImpliciclyCreatable.create(); // no need or the builder

	}
}


