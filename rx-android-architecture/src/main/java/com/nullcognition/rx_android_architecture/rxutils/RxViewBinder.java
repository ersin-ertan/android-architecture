package com.nullcognition.rx_android_architecture.rxutils;
// ersin 10/10/15 Copyright (c) 2015+ All rights reserved.


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import rx.subscriptions.CompositeSubscription;

public abstract class RxViewBinder{

	@Nullable private CompositeSubscription compositeSubscription;

	public void bind(){
		unbind();
		compositeSubscription = new CompositeSubscription();
		bindInternal(compositeSubscription);
	}

	public void unbind(){
		if(compositeSubscription != null){
			compositeSubscription.clear();
			compositeSubscription = null;
		}
	}

	protected abstract void bindInternal(@NonNull final CompositeSubscription compositeSubscription);
}
