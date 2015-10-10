package com.nullcognition.cleanarchitecture.presentation.internal.di.modules;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.cleanarchitecture.domain.executor.PostExecutionThread;
import com.nullcognition.cleanarchitecture.domain.executor.ThreadExecutor;
import com.nullcognition.cleanarchitecture.domain.interactor.GetUserDetailsUseCase;
import com.nullcognition.cleanarchitecture.domain.interactor.GetUserListUseCase;
import com.nullcognition.cleanarchitecture.domain.interactor.UseCase;
import com.nullcognition.cleanarchitecture.domain.repository.UserRepository;
import com.nullcognition.cleanarchitecture.presentation.internal.di.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module public class UserModule{

	private int userId = -1;

	public UserModule(){}

	public UserModule(int userId){
		this.userId = userId;
	}

	@PerActivity
	@Provides @Named("userList") UseCase provideGetUserListUseCase(GetUserListUseCase getUserListUseCase){
		return getUserListUseCase;
	}

	@PerActivity
	@Provides @Named("userDetails") UseCase provideGetUserDetailsUseCase(
			UserRepository userRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread){
		return new GetUserDetailsUseCase(userId, userRepository, threadExecutor, postExecutionThread);
	}
}
