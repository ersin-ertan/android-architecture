package com.nullcognition.cleanarchitecture.presentation;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.cleanarchitecture.domain.executor.PostExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

@Singleton
public class UIThread implements PostExecutionThread{

	@Inject public UIThread(){}


	@Override public Scheduler getScheduler(){ return AndroidSchedulers.mainThread(); }
}
