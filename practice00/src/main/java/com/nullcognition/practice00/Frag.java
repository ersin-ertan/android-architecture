package com.nullcognition.practice00;
// ersin 01/10/15 Copyright (c) 2015+ All rights reserved.


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Frag extends Fragment{

	public static final String TAG = Frag.class.getSimpleName();

	public int state = 0;
	public Retainable retainable;
	public Obj        obj;

	public Frag(){}

	@Override public void onAttach(final Context context){
		super.onAttach(context);
		Log.e(TAG, "onAttach() Frag reference:" + this.toString());
		Log.e(TAG, "onAttach() called with: " + "context = [" + context + "]");
	}

	@Override public void onCreate(final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		Log.e(TAG, "onCreate() Frag reference:" + this.toString());
		Log.e(TAG, "onCreate() called with: " + "savedInstanceState = [" + savedInstanceState + "]");
		Log.e(TAG, "onCreate() Frag State: " + String.valueOf(state));
		retainable = new Retainable();
		Log.e(TAG, "onCreate Retainable State: " + String.valueOf(retainable.state));
		obj = new Obj();
		Log.e(TAG, "onCreate Obj State: " + String.valueOf(obj.state));

		setRetainInstance(true);
	}


	@Nullable @Override public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState){
		Log.e(TAG, "onCreateView() called with: " + "inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
		Log.e(TAG, "onCreateView() Frag State" + String.valueOf(state));
		Log.e(TAG, "onCreateView() Retainable State: " + String.valueOf(retainable.state));
		Log.e(TAG, "onCreateView() Obj State: " + String.valueOf(obj.state));

		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override public void onDestroyView(){
		Log.e(TAG, "onDestroyView() called with: " + "");
		super.onDestroyView();
	}

	@Override public void onDetach(){
		Log.e(TAG, "onDetach() called with: " + "");
		super.onDetach();
	}

	@Override public void onDestroy(){
		Log.e(TAG, "onDestroy() called with: " + "");
		super.onDestroy();
	}

	public static class Obj{

		public int state = 0;
	}
}
