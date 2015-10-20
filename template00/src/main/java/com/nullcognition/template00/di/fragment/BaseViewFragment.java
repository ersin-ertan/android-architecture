package com.nullcognition.template00.di.fragment;
// ersin 17/10/15 Copyright (c) 2015+ All rights reserved.


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nullcognition.template00.di.activity.BaseActivity;
import com.nullcognition.template00.di.presenter.BasePresenter;
import com.sora.util.akatsuki.Akatsuki;
import com.sora.util.akatsuki.Retained;

import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class BaseViewFragment<P extends BasePresenter> extends android.support.v4.app.Fragment{

	@Retained public String s = "";
	protected P basePresenter;

	@Override public void onAttach(final Context context){
		super.onAttach(context);

		DaggeredFragment.ComponentHolder fch = ((BaseActivity) context).fragmentComponentHolder;
		if(fch.getFragmentComponent() == null){ fch.createFragmentComponent(this); }

		injectSelf(fch.getFragmentComponent());
		basePresenter.setBaseFragment(this);
	}

	protected abstract void injectSelf(final DaggeredFragment.FragmentComponent fragmentComponent);

	@Inject protected void injectPresenter(P typedPresenter){
		basePresenter = typedPresenter;
	}

	@Nullable @Override public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState){
		View rootView = inflater.inflate(getLayout(), container, false);
		ButterKnife.bind(this, rootView);
		return rootView;
	}

	protected abstract int getLayout();

	@Override public void onViewStateRestored(@Nullable final Bundle savedInstanceState){
		super.onViewStateRestored(savedInstanceState);
		Akatsuki.restore(this, savedInstanceState);
	}

	@Override public void onSaveInstanceState(final Bundle outState){
		super.onSaveInstanceState(outState);
		Akatsuki.save(this, outState);
	}

	@Override public void onDestroy(){
		ButterKnife.unbind(this);
		((BaseActivity) getActivity()).fragmentComponentHolder.releaseFragmentComponent();
		super.onDestroy();
	}

	protected Integer getParentViewId(){
		if(getView() != null && getView().getParent() != null){
			return ((ViewGroup) getView().getParent()).getId();
		}
		return null;
	}
}
