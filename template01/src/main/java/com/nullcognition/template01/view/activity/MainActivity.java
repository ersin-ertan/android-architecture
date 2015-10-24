package com.nullcognition.template01.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.nullcognition.template01.R;
import com.nullcognition.template01.di.activity.BaseActivity;
import com.nullcognition.template01.di.activity.DaggeredActivity;
import com.nullcognition.template01.view.controller.ListController;
import com.nullcognition.template01.view.fragment.ListFragment;

import butterknife.OnClick;

public class MainActivity extends BaseActivity{

	@OnClick(R.id.btn_addFragment) void addFragment(final View view){

		FragmentManager     fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();

		if(fm.findFragmentByTag(ListController.class.getSimpleName()) == null){
			ft.add(new ListController(), ListController.class.getSimpleName())
			  .replace(R.id.frameLayout, new ListFragment(), ListFragment.class.getSimpleName())
			  .commit();
		}
		else{
			ft.replace(R.id.frameLayout, new ListFragment(), ListFragment.class.getSimpleName())
			  .commit();
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);


	}

	@Override protected void injectSelf(final DaggeredActivity.ActivityComponent activityComponent){
		activityComponent.inject(this);
	}

	@Override protected int getLayout(){
		return R.layout.activity_main;
	}
}
