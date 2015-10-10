package com.nullcognition.cleanarchitecture.domain.interactor;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.cleanarchitecture.domain.executor.PostExecutionThread;
import com.nullcognition.cleanarchitecture.domain.executor.ThreadExecutor;
import com.nullcognition.cleanarchitecture.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;

public class GetUserListUseCase extends UseCase{

	private final UserRepository userRepository;

	@Inject
	public GetUserListUseCase(UserRepository userRepository, ThreadExecutor threadExecutor,
	                          PostExecutionThread postExecutionThread){
		super(threadExecutor, postExecutionThread);
		this.userRepository = userRepository;
	}

	@Override public Observable buildUseCaseObservable(){
		return this.userRepository.getUsers();
	}
}
