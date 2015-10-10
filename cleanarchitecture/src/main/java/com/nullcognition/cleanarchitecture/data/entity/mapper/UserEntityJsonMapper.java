package com.nullcognition.cleanarchitecture.data.entity.mapper;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.nullcognition.cleanarchitecture.data.entity.UserEntity;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;


public class UserEntityJsonMapper{

	private final Gson gson;

	@Inject public UserEntityJsonMapper(){ gson = new Gson(); }

	public UserEntity transformUserEntity(String userJsonResponse) throws JsonSyntaxException{
		try{
			Type userEntityUserEntityype = new TypeToken<UserEntity>(){ }.getType();
			UserEntity userEntity = gson.fromJson(userJsonResponse, userEntityUserEntityype);

			return userEntity;
		}
		catch(JsonSyntaxException jsonSE){ throw jsonSE;}
	}

	public List<UserEntity> transformUserEntityCollection(String userListJsonResponse)
			throws JsonSyntaxException{

		List<UserEntity> userEntityCollection;
		try{
			Type listOfUserEntityUserEntityype = new TypeToken<List<UserEntity>>(){ }.getType();
			userEntityCollection = this.gson.fromJson(userListJsonResponse, listOfUserEntityUserEntityype);

			return userEntityCollection;
		}
		catch(JsonSyntaxException jsonException){
			throw jsonException;
		}
	}
}
