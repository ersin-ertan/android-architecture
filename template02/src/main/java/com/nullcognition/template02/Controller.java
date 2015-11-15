package com.nullcognition.template02;
// ersin 14/11/15 Copyright (c) 2015+ All rights reserved.


import android.view.View;

import java.lang.ref.WeakReference;

public class Controller{

	private final WeakReference<ViewModel> vm;
	public Controller(final ViewModel vm){ this.vm = new WeakReference<ViewModel>(vm); }

	public void longRunningComputation(final View view){
		new Thread(new Runnable(){
			@Override public void run(){
				try{
					Thread.sleep(5000);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				vm.get().os.set(vm.get().os.get() + " long running complete");
			}
		}).start();
	}
}
