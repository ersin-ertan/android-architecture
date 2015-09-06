package com.nullcognition.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.nullcognition.dagger2.apis.InjectConstructor;
import com.nullcognition.dagger2.apis.MyClass01;
import com.nullcognition.dagger2.apis.MyClass02;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

//	@Inject MySingleton mySingleton;

	@Inject @Named("default")       MyClass01 myClass01; // singleton
	@Inject @Named("another") MyClass01 anothermyClass01; // singleton

	@Inject MyClass02 myClass02; // !singleton
	InjectConstructor injectConstructor;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		((App) getApplication()).getComponentMedium().mediumsInject(this);
//		((App) getApplication()).getComponentSmall().smallsInject(this);

		populateTextViews();

	}
	private void populateTextViews(){
		((TextView) findViewById(R.id.tv_injSingleton)).setText("default " + myClass01.getId());
		((TextView) findViewById(R.id.tv_injSingletonAnother)).setText("another " + anothermyClass01.getId());

		((TextView) findViewById(R.id.tv_injNon)).setText(myClass02.getId());
	}

	//	@OnClick(R.id.btn_injSingleton) void injSingleton(final View view){
//	}
	@OnClick(R.id.btn_getObjG) void getFromObjectGraph(final View view){
		// get from the object graph each time its needed
		injectConstructor = ((App) getApplication()).getComponentMedium().injectConstuctorClass();
		((TextView) findViewById(R.id.tv_injConst)).setText(injectConstructor.getId());
	}

}
