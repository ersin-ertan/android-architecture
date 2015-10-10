package com.nullcognition.cleanarchitecture.data.cache.serializer;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.

import com.google.gson.Gson;
import com.nullcognition.cleanarchitecture.data.entity.UserEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class JsonSerializer{

	private final Gson gson = new Gson();

	@Inject public JsonSerializer(){}

	public String serialize(UserEntity userEntity){
		String jsonString = gson.toJson(userEntity, UserEntity.class);
		return jsonString;
	}

	public UserEntity deserialize(String jsonString){
		UserEntity userEntity = gson.fromJson(jsonString, UserEntity.class);
		return userEntity;
	}
}
