package com.nullcognition.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nullcognition.dagger2.apis.MyClass01;
import com.nullcognition.dagger2.apis.MySingleton;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity{

//	@Inject MySingleton mySingleton;

	@Inject MyClass01 myClass01;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		((App) getApplication()).getComponentMedium().mediumsInject(this);
//		((App) getApplication()).getComponentSmall().smallsInject(this);

	}

}
