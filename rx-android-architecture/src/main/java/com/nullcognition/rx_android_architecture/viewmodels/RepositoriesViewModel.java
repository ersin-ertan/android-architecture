package com.nullcognition.rx_android_architecture.viewmodels;
// ersin 10/10/15 Copyright (c) 2015+ All rights reserved.

import android.support.annotation.NonNull;
import com.nullcognition.rx_android_architecture.data.DataLayer;
import com.nullcognition.rx_android_architecture.pojo.GitHubRepository;
import java.util.List;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

public class RepositoriesViewModel extends AbstractViewModel{

	private static final String TAG = RepositoriesViewModel.class.getSimpleName();
	private static final int MAX_REPOSITORIES_DISPLAYED = 5;
	@NonNull private final DataLayer.GetGitHubRepositorySearch getGitHubRepositorySearch = null;
	@NonNull private final DataLayer.GetGitHubRepository getGitHubRepository = null;
	private final PublishSubject<String>           searchString     = PublishSubject.create();
	private final PublishSubject<GitHubRepository> selectRepository = PublishSubject.create();
	private final BehaviorSubject<List<GitHubRepository>> repositories             = BehaviorSubject.create();
	private final BehaviorSubject<ProgressStatus>         networkRequestStatusText = BehaviorSubject.create();

	@Override void subscribeToDataStoreInternal(
			@NonNull CompositeSubscription compositeSubscription) {

	}

	public enum ProgressStatus {
		LOADING, ERROR, IDLE
	}




}
