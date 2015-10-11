package com.nullcognition.rx_android_architecture.rxutils;
// ersin 10/10/15 Copyright (c) 2015+ All rights reserved.


import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.internal.Preconditions;

public final class RxUtils{

	private RxUtils(){ throw new AssertionError();}

	@NonNull
	public static <T> Observable<List<T>> toObservableList(@NonNull List<Observable<T>> observables){
		Preconditions.checkNotNull(observables, "observables cant be null");
		return Observable.combineLatest(observables, RxUtils::toList);
	}

	@NonNull
	@SuppressWarnings("unchecked")
	static <T> List<T> toList(@NonNull Object... args){
		Preconditions.checkNotNull(args, "args cant be null");

		final List<T> list = new ArrayList<>();
		for(Object o : args){
			list.add((T) o);
		}
		return list;
	}
}


