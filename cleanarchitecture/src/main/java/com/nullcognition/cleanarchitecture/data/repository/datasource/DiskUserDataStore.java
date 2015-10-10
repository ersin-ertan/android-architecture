package com.nullcognition.cleanarchitecture.data.repository.datasource;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.cleanarchitecture.data.cache.UserCache;
import com.nullcognition.cleanarchitecture.data.entity.UserEntity;

import java.util.List;

import rx.Observable;

public class DiskUserDataStore implements UserDataStore{

	private final UserCache userCache;

	public DiskUserDataStore(final UserCache userCache){this.userCache = userCache;}

	@Override public Observable<List<UserEntity>> userEntityList(){
		throw new UnsupportedOperationException("operation not yet fulfilled");
	}

	@Override public Observable<UserEntity> userEntityDetails(final int userid){
		return this.userCache.get(userid);
	}

}
