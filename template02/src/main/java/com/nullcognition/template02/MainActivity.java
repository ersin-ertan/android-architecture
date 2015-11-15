package com.nullcognition.template02;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

	FSPA      fspa;
	ViewPager viewPager;

	int current = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		fspa = new FSPA(this, getSupportFragmentManager());
		viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(fspa);
		viewPager.setCurrentItem(current);
	}

	@OnClick(R.id.btn_activity) void activity(final View view){
		if(current == FSPA.fragmentTypes.length - 1){ current = 0; }
		else{ ++current; }

		Toast.makeText(MainActivity.this, String.valueOf(current), Toast.LENGTH_SHORT).show();
		viewPager.setCurrentItem(current);

	}


}
