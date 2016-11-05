package com.nullcognition.template01.di.fragment;
// ersin 21/10/15 Copyright (c) 2015+ All rights reserved.

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.nullcognition.template01.di.activity.BaseActivity;
import com.sora.util.akatsuki.Akatsuki;
import com.sora.util.akatsuki.Retained;

//import android.databinding.DataBindingUtil;
//import android.databinding.ViewDataBinding;

public abstract class BaseViewFragment extends Fragment{

	@Retained public String s = "";
	//	protected P basePresenter;
//	ViewDataBinding viewDataBinding;

	@Override public void onAttach(final Context context){
		super.onAttach(context);

		DaggeredFragment.ComponentHolder fch = ((BaseActivity) context).fragmentComponentHolder;
		if(fch.getFragmentComponent() == null){ fch.createFragmentComponent(this); }

		injectSelf(fch.getFragmentComponent());
//		basePresenter.setBaseFragment(this);
	}

	protected abstract void injectSelf(final DaggeredFragment.FragmentComponent fragmentComponent);

//	@Inject protected void injectPresenter(P typedPresenter){
//		basePresenter = typedPresenter;
//	}

//	@Nullable @Override public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState){
//		viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
//		ButterKnife.bind(this, viewDataBinding.getRoot());
//		return viewDataBinding.getRoot();
//	}

	protected abstract int getLayout();

	@Override public void onCreate(@Nullable final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Akatsuki.restore(this, savedInstanceState);

	}

//	@Override public void onViewStateRestored(@Nullable final Bundle savedInstanceState){
//		super.onViewStateRestored(savedInstanceState);
//	}

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
