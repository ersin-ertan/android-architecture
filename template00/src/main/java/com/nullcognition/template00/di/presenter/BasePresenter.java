package com.nullcognition.template00.di.presenter;
// ersin 19/10/15 Copyright (c) 2015+ All rights reserved.

import android.widget.Toast;

import com.nullcognition.template00.di.fragment.BaseViewFragment;


public abstract class BasePresenter{

	protected final BaseViewFragment baseViewFragment;

	public BasePresenter(BaseViewFragment bvf){
		baseViewFragment = bvf;

//		DaggeredPresenter.ComponentHolder pch = baseViewFragment.presenterComponentHolder;
//		if(pch.getPresenterComponent() == null){ pch.createPresenterComponent(this); }
//
//		injectSelf(pch.getPresenterComponent());
	}

//	protected abstract void injectSelf(final DaggeredPresenter.PresenterComponent presenterComponent);

	public void toast(){ Toast.makeText(baseViewFragment.getContext(), "basepresenter", Toast.LENGTH_SHORT).show(); }


}
