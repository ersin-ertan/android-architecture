package com.nullcognition.template00.di;

import android.os.Bundle;

import com.nullcognition.template00.R;
import com.nullcognition.template00.di.di.activity.BaseActivity;
import com.nullcognition.template00.di.di.activity.DaggeredActivity;

public class Main2Activity extends BaseActivity{

//	@Arg String from;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

//		Toast.makeText(Main2Activity.this, from, Toast.LENGTH_SHORT).show();
	}

	@Override protected void injectSelf(final DaggeredActivity.ActivityComponent activityComponent){
		activityComponent.inject(this);
	}

	@Override protected int getLayout(){
		return R.layout.activity_main2;
	}
}
