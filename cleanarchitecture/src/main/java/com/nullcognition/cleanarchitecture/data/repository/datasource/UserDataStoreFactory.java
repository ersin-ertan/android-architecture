package com.nullcognition.cleanarchitecture.data.repository.datasource;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.

import android.content.Context;

import com.nullcognition.cleanarchitecture.data.cache.UserCache;
import com.nullcognition.cleanarchitecture.data.entity.mapper.UserEntityJsonMapper;
import com.nullcognition.cleanarchitecture.data.net.RestApi;
import com.nullcognition.cleanarchitecture.data.net.RestApiImpl;

import javax.inject.Singleton;

@Singleton
public class UserDataStoreFactory{

	private final Context   context;
	private final UserCache userCache;

	public UserDataStoreFactory(final Context context, final UserCache userCache){
		if(context == null || userCache == null){
			throw new IllegalArgumentException("consturtor parms cant be null");
		}

		this.context = context;
		this.userCache = userCache;
	}

	public UserDataStore create(int userId){
		UserDataStore userDataStore;

		if(!userCache.isExpired() && userCache.isCached(userId)){
			userDataStore = new DiskUserDataStore(this.userCache);
		}
		else{
			userDataStore = createCloudDataStore();
		}
		return userDataStore;
	}

	public UserDataStore createCloudDataStore(){
		UserEntityJsonMapper userEntityJsonMapper = new UserEntityJsonMapper();
		RestApi              restApi              = new RestApiImpl(context, userEntityJsonMapper);

		return new CloudUserDataStore(restApi, userCache);
	}

}
