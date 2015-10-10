package com.nullcognition.cleanarchitecture.domain.executor;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import rx.Scheduler;

public interface PostExecutionThread{

	Scheduler getScheduler();
}
