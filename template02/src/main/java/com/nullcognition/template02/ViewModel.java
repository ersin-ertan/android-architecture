package com.nullcognition.template02;
// ersin 14/11/15 Copyright (c) 2015+ All rights reserved.


import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.os.Parcel;
import android.os.Parcelable;

import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;

@ParcelablePlease
public class ViewModel implements Parcelable{

	public ObservableField<String> os = new ObservableField<>("default");


	@Override public int describeContents(){ return 0; }
	@Override public void writeToParcel(Parcel dest, int flags){ViewModelParcelablePlease.writeToParcel(this, dest, flags);}
	public static final Creator<ViewModel> CREATOR = new Creator<ViewModel>(){
		public ViewModel createFromParcel(Parcel source){
			ViewModel target = new ViewModel();
			ViewModelParcelablePlease.readFromParcel(target, source);
			return target;
		}
		public ViewModel[] newArray(int size){return new ViewModel[size];}
	};
}
