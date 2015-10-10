package com.nullcognition.cleanarchitecture.data.repository.datasource;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.cleanarchitecture.data.entity.UserEntity;

import java.util.List;

import rx.Observable;

public interface UserDataStore{

	Observable<List<UserEntity>> userEntityList();

	Observable<UserEntity> userEntityDetails(final int userid);
}
