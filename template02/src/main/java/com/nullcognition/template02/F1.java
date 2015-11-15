package com.nullcognition.template02;
// ersin 14/11/15 Copyright (c) 2015+ All rights reserved.


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nullcognition.template02.databinding.F1Binding;
import com.sora.util.akatsuki.Arg;
import com.sora.util.akatsuki.Retained;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class F1 extends F{

	F1Binding binding;

	@Retained @Arg String    f1;
	@Retained      ViewModel vm;

	@Override public void onCreate(@Nullable final Bundle savedInstanceState){
		if(vm == null){
			vm = new ViewModel();
			vm.os.set("onCreate f1");
		}
		super.onCreate(savedInstanceState);
	}

	@Nullable @Override public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState){
		binding = DataBindingUtil.inflate(inflater, R.layout.f1, container, false);
		ButterKnife.bind(this, binding.getRoot());
		binding.setVm(vm);
		return binding.getRoot();
	}

	@OnClick(R.id.btn_f1) void button(final View view){
		vm.os.set("buttonClick f1");
	}
}
