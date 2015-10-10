package com.nullcognition.cleanarchitecture.domain.repository;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.cleanarchitecture.domain.User;

import java.util.List;

import rx.Observable;

public interface UserRepository{

	@SuppressWarnings("Convert2MethodRef") Observable<List<User>> getUsers();
	@SuppressWarnings("Convert2MethodRef") Observable<User> getUser(int userId);
}
