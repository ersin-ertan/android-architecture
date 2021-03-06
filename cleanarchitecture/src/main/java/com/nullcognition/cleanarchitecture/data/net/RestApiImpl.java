package com.nullcognition.cleanarchitecture.data.net;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.nullcognition.cleanarchitecture.data.entity.UserEntity;
import com.nullcognition.cleanarchitecture.data.entity.mapper.UserEntityJsonMapper;
import com.nullcognition.cleanarchitecture.data.exception.NetworkConnectionException;

import java.net.MalformedURLException;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class RestApiImpl implements RestApi{

	private final Context              context;
	private final UserEntityJsonMapper userEntityJsonMapper;

	public RestApiImpl(Context context, UserEntityJsonMapper userEntityJsonMapper){
		if(context == null || userEntityJsonMapper == null){
			throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
		}
		this.context = context.getApplicationContext();
		this.userEntityJsonMapper = userEntityJsonMapper;
	}

	@Override public Observable<List<UserEntity>> getUserEntityList(){
		return Observable.create(new Observable.OnSubscribe<List<UserEntity>>(){
			@Override public void call(Subscriber<? super List<UserEntity>> subscriber){

				if(isThereInternetConnection()){
					try{
						String responseUserEntities = getUserEntitiesFromApi();
						if(responseUserEntities != null){
							subscriber.onNext(userEntityJsonMapper.transformUserEntityCollection(
									responseUserEntities));
							subscriber.onCompleted();
						}
						else{
							subscriber.onError(new NetworkConnectionException(""));
						}
					}
					catch(Exception e){
						subscriber.onError(new NetworkConnectionException(e.getCause()));
					}
				}
				else{
					subscriber.onError(new NetworkConnectionException());
				}
			}
		});
	}

	@Override public Observable<UserEntity> getUserEntityById(final int userId){
		return Observable.create(new Observable.OnSubscribe<UserEntity>(){
			@Override public void call(Subscriber<? super UserEntity> subscriber){

				if(isThereInternetConnection()){
					try{
						String responseUserDetails = getUserDetailsFromApi(userId);
						if(responseUserDetails != null){
							subscriber.onNext(userEntityJsonMapper.transformUserEntity(responseUserDetails));
							subscriber.onCompleted();
						}
						else{ subscriber.onError(new NetworkConnectionException());}
					}
					catch(Exception e){
						subscriber.onError(new NetworkConnectionException(e.getCause()));
					}
				}
				else{ subscriber.onError(new NetworkConnectionException());}
			}
		});
	}

	private String getUserEntitiesFromApi() throws MalformedURLException{
		return ApiConnection.createGET(RestApi.API_URL_GET_USER_LIST).requestSyncCall();
	}

	private String getUserDetailsFromApi(int userId) throws MalformedURLException{
		String apiUrl = RestApi.API_URL_GET_USER_DETAILS + userId + ".json";
		return ApiConnection.createGET(apiUrl).requestSyncCall();
	}

	private boolean isThereInternetConnection(){
		boolean isConnected;

		ConnectivityManager connectivityManager =
				(ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

		return isConnected;
	}
}
