package com.nullcognition.cleanarchitecture.domain.interactor;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import rx.Subscriber;

public class DefaultSubscriber<T> extends Subscriber<T>{

	@Override public void onCompleted(){

	}
	@Override public void onError(final Throwable e){

	}
	@Override public void onNext(final T t){

	}
}
