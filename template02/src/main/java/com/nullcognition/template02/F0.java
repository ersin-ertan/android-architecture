package com.nullcognition.template02;
// ersin 14/11/15 Copyright (c) 2015+ All rights reserved.


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nullcognition.template02.databinding.F0Binding;
import com.sora.util.akatsuki.Arg;
import com.sora.util.akatsuki.Retained;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class F0 extends F{

	@Retained @Arg int i;

	F0Binding binding;
	@Retained ViewModel vm;
	Controller controller;
	Presenter  presenter;

	@Override public void onCreate(@Nullable final Bundle savedInstanceState){
		if(vm == null){
			vm = new ViewModel();
			vm.os.set("onCreate f0");
		}
		super.onCreate(savedInstanceState);
		controller = new Controller(vm);
		presenter = new Presenter();
	}

	@Nullable @Override public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState){
		binding = DataBindingUtil.inflate(inflater, R.layout.f0, container, false);
		ButterKnife.bind(this, binding.getRoot());
		binding.setController(controller);
		binding.setVm(vm);
		binding.setPresenter(presenter);
		return binding.getRoot();
	}

	@OnClick(R.id.btn_f0) void button(final View view){
		vm.os.set("buttonClick f0 received model");
	}
}
