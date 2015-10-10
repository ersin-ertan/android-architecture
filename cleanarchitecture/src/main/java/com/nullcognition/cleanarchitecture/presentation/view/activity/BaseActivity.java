package com.nullcognition.cleanarchitecture.presentation.view.activity;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.nullcognition.cleanarchitecture.presentation.AndroidApplication;
import com.nullcognition.cleanarchitecture.presentation.internal.di.components.ApplicationComponent;
import com.nullcognition.cleanarchitecture.presentation.internal.di.modules.ActivityModule;
import com.nullcognition.cleanarchitecture.presentation.navigation.Navigator;

import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity{

	@Inject Navigator navigator;

	@Override protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		getApplicationComponent().inject(this);
	}

	protected void addFragment(int containerViewId, Fragment fragment){
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.add(containerViewId, fragment);
		fragmentTransaction.commit();
	}

	protected ApplicationComponent getApplicationComponent(){
		return ((AndroidApplication) getApplication()).getApplicationComponent();
	}

	protected ActivityModule getActivityModule(){ return new ActivityModule(this); }

}
