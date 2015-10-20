package com.nullcognition.template00.view.fragment;
// ersin 18/10/15 Copyright (c) 2015+ All rights reserved.


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nullcognition.template00.R;
import com.nullcognition.template00.di.fragment.BaseViewFragment;
import com.nullcognition.template00.di.fragment.DaggeredFragment;

import butterknife.Bind;
import butterknife.BindString;

public class MainFragment extends BaseViewFragment{

	public static final String TAG = "MainFragment";

//	@Retained @Arg String string; // bugs in library

	@BindString(R.string.app_name) String   appName;
	@Bind(R.id.tv_fragment)        TextView textView;

	@Override protected void injectSelf(final DaggeredFragment.FragmentComponent fragmentComponent){
		fragmentComponent.inject(this);
	}

	@Nullable @Override public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState){
		View v = super.onCreateView(inflater, container, savedInstanceState);
		textView.setText(appName);
//		basePresenter.toast();
		return v;
	}

	@Override protected int getLayout(){
		return R.layout.fragment_main;
	}
}
