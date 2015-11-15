package com.nullcognition.template02;
// ersin 14/11/15 Copyright (c) 2015+ All rights reserved.


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.sora.util.akatsuki.Akatsuki;

import butterknife.ButterKnife;

public class F extends Fragment{

	@Override public void onCreate(@Nullable final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Akatsuki.restore(this, savedInstanceState);
	}

	@Override public void onSaveInstanceState(final Bundle outState){
		super.onSaveInstanceState(outState);
		Akatsuki.save(this, outState);
	}


	@Override public void onDestroyView(){
		super.onDestroyView();
		ButterKnife.unbind(this);
	}

}
