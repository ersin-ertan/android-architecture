package com.nullcognition.cleanarchitecture.data.cache;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.cleanarchitecture.data.entity.UserEntity;

import rx.Observable;

public interface UserCache{

	Observable<UserEntity> get(final int userId);

	void put(UserEntity userEntity);

	boolean isCached(final int userId);

	boolean isExpired();

	void evictAll();
}
