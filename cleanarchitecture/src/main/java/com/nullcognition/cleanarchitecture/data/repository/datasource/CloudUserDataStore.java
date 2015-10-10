package com.nullcognition.cleanarchitecture.data.repository.datasource;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.cleanarchitecture.data.cache.UserCache;
import com.nullcognition.cleanarchitecture.data.entity.UserEntity;
import com.nullcognition.cleanarchitecture.data.net.RestApi;

import java.util.List;

import rx.Observable;
import rx.functions.Action1;

public class CloudUserDataStore implements UserDataStore{

	private final RestApi   restApi;
	private final UserCache userCache;

	private final Action1<UserEntity> saveToCacheAction = new Action1<UserEntity>(){
		@Override public void call(final UserEntity userEntity){
			if(userEntity != null){ userCache.put(userEntity); }
		}
	};

	public CloudUserDataStore(final RestApi restApi, final UserCache userCache){
		this.restApi = restApi;
		this.userCache = userCache;
	}

	@Override public Observable<List<UserEntity>> userEntityList(){
		return restApi.userEntityList();
	}

	@Override public Observable<UserEntity> userEntityDetails(final int userid){
		return restApi.userEntityById(userid)
		              .doOnNext(saveToCacheAction);
	}

}
