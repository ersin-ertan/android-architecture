package com.nullcognition.template00.di.di.activity;
// ersin 17/10/15 Copyright (c) 2015+ All rights reserved.


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nullcognition.template00.di.di.application.App;
import com.nullcognition.template00.di.di.fragment.DaggeredFragment;
import com.nullcognition.template00.di.di.navigator.Navigator;
import com.sora.util.akatsuki.Akatsuki;
import com.sora.util.akatsuki.Retained;

import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity{

	@Inject protected Navigator navigator;
	@Retained String s = ""; // still need in the base class else crash

	public final DaggeredFragment.ComponentHolder fragmentComponentHolder =
			new DaggeredFragment.ComponentHolder();

	@Override protected void onCreate(final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(getLayout());

		DaggeredActivity.ComponentHolder ach = App.get(this).activityComponentHolder;
		if(ach.getActivityComponent() == null){ ach.createActivityComponent(this); }

		injectSelf(ach.getActivityComponent());
		ButterKnife.bind(this);
		Akatsuki.restore(this, savedInstanceState);
	}

	@Override protected void onSaveInstanceState(final Bundle outState){
		super.onSaveInstanceState(outState);
		Akatsuki.save(this, outState);
		ButterKnife.unbind(this);
	}
	@Override public void finish(){
		App.get(this).activityComponentHolder.releaseActivityComponent(); // learn as to when this is and is not needed
		super.finish();
	}

	protected abstract void injectSelf(final DaggeredActivity.ActivityComponent activityComponent);

	protected abstract int getLayout();
}
