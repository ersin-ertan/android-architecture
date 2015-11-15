//package com.nullcognition.rx_android_architecture.viewmodels;
//// ersin 10/10/15 Copyright (c) 2015+ All rights reserved.
//
//
//import android.support.annotation.NonNull;
//import android.util.Log;
//
//import com.nullcognition.rx_android_architecture.data.DataLayer;
//import com.nullcognition.rx_android_architecture.pojo.GitHubRepository;
//import com.nullcognition.rx_android_architecture.pojo.UserSettings;
//
//import rx.Observable;
//import rx.android.internal.Preconditions;
//import rx.subjects.BehaviorSubject;
//import rx.subscriptions.CompositeSubscription;
//
//public class RepositoryViewModel extends AbstractViewModel{
//
//	private static final String TAG = RepositoryViewModel.class.getSimpleName();
//
////	private final DataLayer.GetUserSettings             getUserSettings;
////	private final DataLayer.FetchAndGetGitHubRepository fetchAndGetGitHubRepository;
//
//	final private BehaviorSubject<GitHubRepository> repository = BehaviorSubject.create();
//
//	public RepositoryViewModel(@NonNull DataLayer.GetUserSettings getUserSettings,
//	                           @NonNull DataLayer.FetchAndGetGitHubRepository fetchAndGetGitHubRepository){
//		Preconditions.checkNotNull(getUserSettings, "Gey User Settings cannot be null.");
//		Preconditions.checkNotNull(fetchAndGetGitHubRepository,
//				"Fetch And Get GitHub Repository cannot be null.");
//
//		this.getUserSettings = getUserSettings;
//		this.fetchAndGetGitHubRepository = fetchAndGetGitHubRepository;
//		Log.v(TAG, "RepositoryViewModel");
//	}
//
//	@Override void subscribeToDataStoreInternal(@NonNull final CompositeSubscription compositeSubscription){
//		compositeSubscription.add(getUserSettings.call()
//		                                         .map(UserSettings::getSelectedRepositoryId)
//		                                         .switchMap(fetchAndGetGitHubRepository::call)
//		                                         .subscribe(repository));
//	}
//
//	@NonNull public Observable<GitHubRepository> getRepository(){
//		return repository.asObservable();
//	}
//}
