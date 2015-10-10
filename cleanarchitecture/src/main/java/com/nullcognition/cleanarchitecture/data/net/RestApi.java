package com.nullcognition.cleanarchitecture.data.net;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.cleanarchitecture.data.entity.UserEntity;

import java.util.List;

import rx.Observable;

public interface RestApi{

	String API_BASE_URL = "http://www.android10.org/myapi/";

	String API_URL_GET_USER_LIST    = API_BASE_URL + "users.json";
	String API_URL_GET_USER_DETAILS = API_BASE_URL + "user_";

	Observable<List<UserEntity>> getUserEntityList();
	Observable<UserEntity> getUserEntityById(final int userId);
}
