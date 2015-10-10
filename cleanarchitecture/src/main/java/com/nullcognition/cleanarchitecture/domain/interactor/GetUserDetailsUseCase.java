package com.nullcognition.cleanarchitecture.domain.interactor;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.cleanarchitecture.domain.executor.PostExecutionThread;
import com.nullcognition.cleanarchitecture.domain.executor.ThreadExecutor;
import com.nullcognition.cleanarchitecture.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;

public class GetUserDetailsUseCase extends UseCase{

	private final int            userId;
	private final UserRepository userRepository;


	@Inject public GetUserDetailsUseCase(final int userId, final UserRepository userRepository,
	                                    ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread){
		super(threadExecutor, postExecutionThread);
		this.userId = userId;
		this.userRepository = userRepository;
	}

	@Override protected Observable buildUseCaseObservable(){
		return userRepository.getUser(userId);
	}

}
