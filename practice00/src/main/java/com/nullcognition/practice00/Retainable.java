package com.nullcognition.practice00;
// ersin 01/10/15 Copyright (c) 2015+ All rights reserved.


import android.os.Parcel;
import android.os.Parcelable;

import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;

@ParcelablePlease
public class Retainable implements Parcelable{

	public int state = 0;


	@Override public int describeContents(){ return 0; }
	@Override public void writeToParcel(Parcel dest, int flags){RetainableParcelablePlease.writeToParcel(this, dest, flags);}
	public static final Creator<Retainable> CREATOR = new Creator<Retainable>(){
		public Retainable createFromParcel(Parcel source){
			Retainable target = new Retainable();
			RetainableParcelablePlease.readFromParcel(target, source);
			return target;
		}
		public Retainable[] newArray(int size){return new Retainable[size];}
	};
}
