package com.nullcognition.template00.di;

import android.os.Bundle;

import com.nullcognition.template00.R;
import com.nullcognition.template00.di.di.activity.DaggeredActivity;
import com.nullcognition.template00.di.di.activity.BaseActivity;

public class MainActivity extends BaseActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		if(savedInstanceState == null){
//			getSupportFragmentManager()
//					.beginTransaction()
//					.add(
//
//							R.id.linearLayout,
//
//							(Fragment) Builders.MainFragment(savedInstanceState).string("st").build(this),
//							new MainFragment(),
//
//							"t"
//
//					).commit();
		}
//
//		Builders.Main2Activity().from(this.getClass().getSimpleName()).startActivity(this);
		navigator.switchActivity(Main2Activity.class);
	}

	@Override protected void injectSelf(final DaggeredActivity.ActivityComponent activityComponent){
		activityComponent.inject(this);
	}

	@Override protected int getLayout(){
		return R.layout.activity_main;
	}
}
