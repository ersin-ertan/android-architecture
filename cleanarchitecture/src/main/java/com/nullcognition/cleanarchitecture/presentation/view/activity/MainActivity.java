package com.nullcognition.cleanarchitecture.presentation.view.activity;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nullcognition.cleanarchitecture.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity{

	@Bind(R.id.btn_LoadData) Button btn_LoadData;

	@Override protected void onCreate(final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
	}

	@OnClick(R.id.btn_LoadData) void navigateToUserList(final View view){
		navigator.navigateToUserList(this);
	}
}
