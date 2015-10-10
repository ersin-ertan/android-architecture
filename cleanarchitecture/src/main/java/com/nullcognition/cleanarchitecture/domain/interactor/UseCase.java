package com.nullcognition.cleanarchitecture.domain.interactor;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.cleanarchitecture.domain.executor.PostExecutionThread;
import com.nullcognition.cleanarchitecture.domain.executor.ThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public abstract class UseCase{

	private final ThreadExecutor      threadExecutor;
	private final PostExecutionThread postExecutionThread;

	private Subscription subscription = Subscriptions.empty();

	protected UseCase(final ThreadExecutor threadExecutor, final PostExecutionThread postExecutionThread){
		this.threadExecutor = threadExecutor;
		this.postExecutionThread = postExecutionThread;
	}

	protected abstract Observable buildUseCaseObservable();

	@SuppressWarnings("unchecked")
	public void execute(Subscriber UseCaseSubscriber){

		this.subscription = this.buildUseCaseObservable()
		                        .subscribeOn(Schedulers.from(threadExecutor))
		                        .observeOn(postExecutionThread.getScheduler())
		                        .subscribe(UseCaseSubscriber);
	}

	public void unsubscribe(){
		if(!subscription.isUnsubscribed()){
			subscription.unsubscribe();
		}
	}
}
