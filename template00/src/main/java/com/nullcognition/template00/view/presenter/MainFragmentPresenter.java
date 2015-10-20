package com.nullcognition.template00.view.presenter;
// ersin 19/10/15 Copyright (c) 2015+ All rights reserved.


import android.widget.Toast;

import com.nullcognition.template00.di.fragment.BaseViewFragment;
import com.nullcognition.template00.di.presenter.BasePresenter;

import javax.inject.Inject;

public class MainFragmentPresenter extends BasePresenter{

	@Inject public MainFragmentPresenter(){ }

	@Override public void toast(){
		Toast.makeText(baseViewFragment.getContext(), "MainFragmentPresenter", Toast.LENGTH_SHORT).show();
	}

	@Override public void setBaseFragment(final BaseViewFragment bvf){ baseViewFragment = bvf; }
}
