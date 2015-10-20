package com.nullcognition.template00.di.presenter;
// ersin 19/10/15 Copyright (c) 2015+ All rights reserved.

import com.nullcognition.template00.di.fragment.BaseViewFragment;

import javax.inject.Inject;


public abstract class BasePresenter{

	protected BaseViewFragment baseViewFragment;

	public BasePresenter(/*could put a persistent thread handler here*/){}

	public abstract void toast();

	public abstract void setBaseFragment(final BaseViewFragment bvf);
}
