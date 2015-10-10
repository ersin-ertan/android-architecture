package com.nullcognition.cleanarchitecture.data.entity.mapper;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.

import com.nullcognition.cleanarchitecture.data.entity.UserEntity;
import com.nullcognition.cleanarchitecture.domain.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserEntityDataMapper{

	@Inject public UserEntityDataMapper(){}

	public User transform(UserEntity userEntity){
		User user = null;
		if(userEntity != null){
			user = new User(userEntity.getUserId());
			user.setCoverUrl(userEntity.getCoverUrl());
			user.setFullName(userEntity.getFullname());
			user.setDescription(userEntity.getDescription());
			user.setFollowers(userEntity.getFollowers());
			user.setEmail(userEntity.getEmail());
		}

		return user;
	}

	public List<User> transform(Collection<UserEntity> userEntityCollection){
		List<User> userList = new ArrayList<>(20);
		User       user;
		for(UserEntity userEntity : userEntityCollection){
			user = transform(userEntity);
			if(user != null){
				userList.add(user);
			}
		}

		return userList;
	}
}
