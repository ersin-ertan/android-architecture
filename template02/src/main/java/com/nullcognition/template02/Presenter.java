package com.nullcognition.template02;
// ersin 14/11/15 Copyright (c) 2015+ All rights reserved.


import android.databinding.ObservableInt;
import android.view.View;

public class Presenter{

	ObservableInt buttonf0Visibility = new ObservableInt(View.VISIBLE);



	public static String capitalize(String s){
		return s.toUpperCase();
	}

	public void hideButtonf0(){
		buttonf0Visibility.set(View.INVISIBLE);
	}

	public void showButtonf0(){
		buttonf0Visibility.set(View.VISIBLE);
	}

	public boolean getButtonVisibility(){
		if(buttonf0Visibility.get() == View.VISIBLE){ return true; }
		return false;
	}

	public void displayClicked(View view){

	}
}
