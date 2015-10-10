package com.nullcognition.cleanarchitecture.presentation.view.fragment;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.nullcognition.cleanarchitecture.presentation.internal.di.HasComponent;

public abstract class BaseFragment extends Fragment{

	@Override public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	protected void showToastMessage(String message){
		Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
	}

	@SuppressWarnings("unchecked")
	protected <C> C getComponent(Class<C> componentType){
		return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
	}
}
