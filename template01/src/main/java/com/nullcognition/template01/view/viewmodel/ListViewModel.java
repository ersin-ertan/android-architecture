//package com.nullcognition.template01.view.viewmodel;
//// ersin 23/10/15 Copyright (c) 2015+ All rights reserved.
//
//
////import android.databinding.BaseObservable;
////import android.databinding.Bindable;
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.view.View;
//
//import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;
//import com.nullcognition.template01.BR;
//
//@ParcelablePlease
//public class ListViewModel extends BaseObservable implements Parcelable{
//
//	String nameFirstLast;
//
//	@Bindable
//	public String getNameFirstLast(){return nameFirstLast;}
//
//	public void setNameFirstLast(final String nameFirstLast){
//		this.nameFirstLast = nameFirstLast;
//		notifyPropertyChanged(BR.nameFirstLast);
//	}
//
//	public void changeName(View view){
//		nameFirstLast = "buttonClicked";
//		notifyPropertyChanged(BR.nameFirstLast);
//	}
//
//	@Override public int describeContents(){ return 0; }
//
//	@Override public void writeToParcel(Parcel dest, int flags){ListViewModelParcelablePlease.writeToParcel(this, dest, flags);}
//
//	public static final Creator<ListViewModel> CREATOR = new Creator<ListViewModel>(){
//		public ListViewModel createFromParcel(Parcel source){
//			ListViewModel target = new ListViewModel();
//			ListViewModelParcelablePlease.readFromParcel(target, source);
//			return target;
//		}
//
//		public ListViewModel[] newArray(int size){return new ListViewModel[size];}
//	};
//}
