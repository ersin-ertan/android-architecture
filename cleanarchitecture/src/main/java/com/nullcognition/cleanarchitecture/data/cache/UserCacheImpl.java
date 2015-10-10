package com.nullcognition.cleanarchitecture.data.cache;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.

import android.content.Context;

import com.nullcognition.cleanarchitecture.data.cache.serializer.JsonSerializer;
import com.nullcognition.cleanarchitecture.data.entity.UserEntity;
import com.nullcognition.cleanarchitecture.data.exception.UserNotFoundException;
import com.nullcognition.cleanarchitecture.domain.executor.ThreadExecutor;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;

@Singleton
public class UserCacheImpl implements UserCache{

	private static final String SETTINGS_FILE_NAME             = "com.nullcognition.cleanarchitecture.SETTINGS";
	private static final String SETTINGS_KEY_LAST_CACHE_UPDATE = "last_cache_update";

	private static final String DEFAULT_FILE_NAME = "user_";
	private static final long   EXPIRATION_TIME   = 60 * 10 * 1000;

	private final Context        context;
	private final File           cacheDir;
	private final JsonSerializer serializer;
	private final FileManager    fileManager;
	private final ThreadExecutor threadExecutor;

	@Inject public UserCacheImpl(Context context, JsonSerializer userCacheSerializer,
	                             FileManager fileManager, ThreadExecutor executor){
		if(context == null || userCacheSerializer == null || fileManager == null || executor == null){
			throw new IllegalArgumentException("Invalid null parameter");
		}
		this.context = context.getApplicationContext();
		this.cacheDir = this.context.getCacheDir();
		this.serializer = userCacheSerializer;
		this.fileManager = fileManager;
		this.threadExecutor = executor;
	}

	@Override public synchronized Observable<UserEntity> get(final int userId){
		return Observable.create(new Observable.OnSubscribe<UserEntity>(){
			@Override public void call(Subscriber<? super UserEntity> subscriber){
				File       userEntityFile = UserCacheImpl.this.buildFile(userId);
				String     fileContent    = UserCacheImpl.this.fileManager.readFileContent(userEntityFile);
				UserEntity userEntity     = UserCacheImpl.this.serializer.deserialize(fileContent);

				if(userEntity != null){
					subscriber.onNext(userEntity);
					subscriber.onCompleted();
				}
				else{
					subscriber.onError(new UserNotFoundException());
				}
			}
		});
	}

	@Override public synchronized void put(UserEntity userEntity){
		if(userEntity != null){
			File userEntitiyFile = this.buildFile(userEntity.getUserId());
			if(!isCached(userEntity.getUserId())){
				String jsonString = this.serializer.serialize(userEntity);
				this.executeAsynchronously(new CacheWriter(this.fileManager, userEntitiyFile,
						jsonString));
				setLastCacheUpdateTimeMillis();
			}
		}
	}

	@Override public boolean isCached(final int userId){
		File userEntityFile = this.buildFile(userId);
		return this.fileManager.exists(userEntityFile);
	}
	@Override public boolean isExpired(){
		long currentTime    = System.currentTimeMillis();
		long lastUpdateTime = this.getLastCacheUpdateTimeMillis();

		boolean expired = ((currentTime - lastUpdateTime) > EXPIRATION_TIME);

		if(expired){ this.evictAll();}
		return expired;
	}
	@Override public synchronized void evictAll(){
		this.executeAsynchronously(new CacheEvictor(this.fileManager, this.cacheDir));
	}

	private File buildFile(int userId){
		StringBuilder fileNameBuilder = new StringBuilder();
		fileNameBuilder.append(this.cacheDir.getPath());
		fileNameBuilder.append(File.separator);
		fileNameBuilder.append(DEFAULT_FILE_NAME);
		fileNameBuilder.append(userId);

		return new File(fileNameBuilder.toString());
	}

	private void setLastCacheUpdateTimeMillis(){
		long currentMillis = System.currentTimeMillis();
		this.fileManager.writeToPreferences(this.context, SETTINGS_FILE_NAME,
				SETTINGS_KEY_LAST_CACHE_UPDATE, currentMillis);
	}

	private long getLastCacheUpdateTimeMillis(){
		return this.fileManager.getFromPreferences(this.context, SETTINGS_FILE_NAME,
				SETTINGS_KEY_LAST_CACHE_UPDATE);
	}

	private void executeAsynchronously(Runnable runnable){
		this.threadExecutor.execute(runnable);
	}

	private static class CacheWriter implements Runnable{

		private final FileManager fileManager;
		private final File        fileToWrite;
		private final String      fileContent;

		CacheWriter(FileManager fileManager, File fileToWrite, String fileContent){
			this.fileManager = fileManager;
			this.fileToWrite = fileToWrite;
			this.fileContent = fileContent;
		}

		@Override public void run(){
			this.fileManager.writeToFile(fileToWrite, fileContent);
		}
	}


	private static class CacheEvictor implements Runnable{

		private final FileManager fileManager;
		private final File        cacheDir;

		CacheEvictor(FileManager fileManager, File cacheDir){
			this.fileManager = fileManager;
			this.cacheDir = cacheDir;
		}

		@Override public void run(){
			this.fileManager.clearDirectory(this.cacheDir);
		}
	}
}
