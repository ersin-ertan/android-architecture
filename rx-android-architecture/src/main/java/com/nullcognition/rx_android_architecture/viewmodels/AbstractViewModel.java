package com.nullcognition.rx_android_architecture.viewmodels;
// ersin 10/10/15 Copyright (c) 2015+ All rights reserved.


import android.support.annotation.NonNull;
import android.util.Log;

import rx.subscriptions.CompositeSubscription;

public abstract class AbstractViewModel{

	private static final String TAG = AbstractViewModel.class.getSimpleName();
	private CompositeSubscription compositeSubscription;

	final public void subscribeToDataStore(){
		Log.v(TAG, "subscribeToDataStore");
		unsubscribeFromDataStore();
		compositeSubscription = new CompositeSubscription();
		subscribeToDataStoreInternal(compositeSubscription);
	}

	public void dispose(){
		Log.v(TAG, "dispose");

		if(compositeSubscription != null){
			Log.e(TAG, "Disposing without calling unsubscribeFromDataStore first");

			unsubscribeFromDataStore();
		}
	}

	abstract void subscribeToDataStoreInternal(@NonNull CompositeSubscription compositeSubscription);

	public void unsubscribeFromDataStore(){
		Log.v(TAG, "unsubscribeToDataStore");
		if(compositeSubscription != null){
			compositeSubscription.clear();
			compositeSubscription = null;
		}
	}
}
