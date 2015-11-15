package com.nullcognition.template02;
// ersin 14/11/15 Copyright (c) 2015+ All rights reserved.


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class FSPA extends FragmentStatePagerAdapter{

	Context context;
	public static final Class[] fragmentTypes = { F0.class, F1.class, F2.class };

	public FSPA(final Context context, final FragmentManager fm){
		super(fm);
		this.context = context;
	}

	@Override public Fragment getItem(final int position){
		Fragment f = null;
		switch(position){
			case 0:
				f = Builders.F0().i(1).build(context);
				break;
			case 1:
				f = Builders.F1().f1("f1").build(context);
				break;
			case 2:
				f = Builders.F2().f2("f2").build(context);
				break;
			default:
				f = Builders.F0().build(context);
				break;
		}
		return f;
	}

	@Override public int getCount(){
		return fragmentTypes.length;
	}
}
