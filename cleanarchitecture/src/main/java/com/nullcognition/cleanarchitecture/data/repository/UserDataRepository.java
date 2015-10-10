package com.nullcognition.cleanarchitecture.data.repository;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.

import com.nullcognition.cleanarchitecture.data.entity.mapper.UserEntityDataMapper;
import com.nullcognition.cleanarchitecture.data.repository.datasource.UserDataStore;
import com.nullcognition.cleanarchitecture.data.repository.datasource.UserDataStoreFactory;
import com.nullcognition.cleanarchitecture.domain.User;
import com.nullcognition.cleanarchitecture.domain.repository.UserRepository;

import java.util.List;

import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class UserDataRepository implements UserRepository{

	private final UserDataStoreFactory userDataStoreFactory;
	private final UserEntityDataMapper userEntityDataMapper;

	public UserDataRepository(final UserDataStoreFactory userDataStoreFactory, final UserEntityDataMapper userEntityDataMapper){
		this.userDataStoreFactory = userDataStoreFactory;
		this.userEntityDataMapper = userEntityDataMapper;
	}

	@SuppressWarnings("Convert2MethodRef")
	@Override public Observable<List<User>> users(){
		final UserDataStore userDataStore = this.userDataStoreFactory.createCloudDataStore();
		return userDataStore.userEntityList()
		                    .map(userEntities -> this.userEntityDataMapper.transform(userEntities));
	}

	@SuppressWarnings("Convert2MethodRef")
	@Override public Observable<User> user(int userId){
		final UserDataStore userDataStore = this.userDataStoreFactory.create(userId);
		return userDataStore.userEntityDetails(userId)
		                    .map(userEntity -> this.userEntityDataMapper.transform(userEntity));
	}
}
