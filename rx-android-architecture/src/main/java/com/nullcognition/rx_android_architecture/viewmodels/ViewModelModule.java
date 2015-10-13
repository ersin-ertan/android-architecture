package com.nullcognition.rx_android_architecture.viewmodels;
// ersin 10/10/15 Copyright (c) 2015+ All rights reserved.


import dagger.Module;
import dagger.Provides;

@Module public class ViewModelModule{

	public RepositoriesViewModel provideRepositoriesViewModel(GetGitHubRepositorySearch repositorySearch,
	                                                          GetGitHubRepository repositoryRepository){
		return new RepositoriesViewModel(repositorySearch, repositoryRepository);
	}

	@Provides
	public RepositoryViewModel provideRepositoryViewModel(GetUserSettings getUserSettings,
	                                                      FetchAndGetGitHubRepository fetchAndGetGitHubRepository){
		return new RepositoryViewModel(getUserSettings, fetchAndGetGitHubRepository);
	}
}
