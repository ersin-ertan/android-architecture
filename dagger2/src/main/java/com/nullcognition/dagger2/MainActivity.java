package com.nullcognition.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.nullcognition.dagger2.apis.InjectConstructor;
import com.nullcognition.dagger2.apis.MyClass01;
import com.nullcognition.dagger2.apis.MyClass02;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{

//	@Inject MySingleton mySingleton;

	@Inject MyClass01         myClass01; // singleton
	@Inject MyClass02         myClass02; // !singleton
	@Inject InjectConstructor injectConstructor;

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
		((TextView) findViewById(R.id.tv_injSingleton)).setText(myClass01.getId());
		((TextView) findViewById(R.id.tv_injNon)).setText(myClass02.getId());
		((TextView) findViewById(R.id.tv_injConst)).setText(injectConstructor.getId());

	}

//	@OnClick(R.id.btn_injSingleton) void injSingleton(final View view){
//	}
//	@OnClick(R.id.btn_injNon) void injNon(final View view){
//	}
//	@OnClick(R.id.btn_injSingleton) void injSingleton(final View view){
//		((TextView) findViewById(R.id.tv_injSingleton)).setText(myClass02.getId());
//	}

}
