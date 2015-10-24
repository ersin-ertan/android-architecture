package com.nullcognition.template01.view.controller;
// ersin 23/10/15 Copyright (c) 2015+ All rights reserved.


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.nullcognition.template01.model.SimpleModel;
import com.nullcognition.template01.view.viewmodel.ListViewModel;

import java.util.Random;

public class ListController extends Fragment{

	public ListController(){}

	public void setListViewModel(ListViewModel lvm){
		this.lvm = lvm;
	}

	public boolean isListViewModel(){return lvm != null;}

	ListViewModel lvm;
	SimpleModel   simpleModel;

	@Override public void onCreate(final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		simpleModel = new SimpleModel("firstName", "lastName");
	}

	public void changeName(View view){
		simpleModel.setFirstName(String.valueOf(new Random().nextInt()));
		lvm.setNameFirstLast(simpleModel.getFirstName() + simpleModel.getLastName());
	}


}
