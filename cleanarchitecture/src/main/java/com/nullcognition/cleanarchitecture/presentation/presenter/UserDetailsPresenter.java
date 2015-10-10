package com.nullcognition.cleanarchitecture.presentation.presenter;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import android.support.annotation.NonNull;

import com.nullcognition.cleanarchitecture.domain.User;
import com.nullcognition.cleanarchitecture.domain.exception.DefaultErrorBundle;
import com.nullcognition.cleanarchitecture.domain.exception.ErrorBundle;
import com.nullcognition.cleanarchitecture.domain.interactor.DefaultSubscriber;
import com.nullcognition.cleanarchitecture.domain.interactor.UseCase;
import com.nullcognition.cleanarchitecture.presentation.exception.ErrorMessageFactory;
import com.nullcognition.cleanarchitecture.presentation.internal.di.PerActivity;
import com.nullcognition.cleanarchitecture.presentation.mapper.UserModelDataMapper;
import com.nullcognition.cleanarchitecture.presentation.model.UserModel;
import com.nullcognition.cleanarchitecture.presentation.view.UserDetailsView;

import javax.inject.Inject;
import javax.inject.Named;

@PerActivity
public class UserDetailsPresenter extends DefaultSubscriber<User> implements Presenter{

	private int userId;

	private UserDetailsView viewDetailsView;

	private final UseCase             getUserDetailsUseCase;
	private final UserModelDataMapper userModelDataMapper;

	@Inject
	public UserDetailsPresenter(@Named("userDetails") UseCase getUserDetailsUseCase,
	                            UserModelDataMapper userModelDataMapper){
		this.getUserDetailsUseCase = getUserDetailsUseCase;
		this.userModelDataMapper = userModelDataMapper;
	}

	public void setView(@NonNull UserDetailsView view){
		this.viewDetailsView = view;
	}

	@Override public void resume(){}

	@Override public void pause(){}

	@Override public void destroy(){
		this.getUserDetailsUseCase.unsubscribe();
	}

	public void initialize(int userId){
		this.userId = userId;
		this.loadUserDetails();
	}

	private void loadUserDetails(){
		this.hideViewRetry();
		this.showViewLoading();
		this.getUserDetails();
	}

	private void showViewLoading(){
		this.viewDetailsView.showLoading();
	}

	private void hideViewLoading(){
		this.viewDetailsView.hideLoading();
	}

	private void showViewRetry(){
		this.viewDetailsView.showRetry();
	}

	private void hideViewRetry(){
		this.viewDetailsView.hideRetry();
	}

	private void showErrorMessage(ErrorBundle errorBundle){
		String errorMessage = ErrorMessageFactory.create(this.viewDetailsView.getContext(),
				errorBundle.getException());
		this.viewDetailsView.showError(errorMessage);
	}

	private void showUserDetailsInView(User user){
		final UserModel userModel = this.userModelDataMapper.transform(user);
		this.viewDetailsView.renderUser(userModel);
	}

	private void getUserDetails(){
		this.getUserDetailsUseCase.execute(this);
	}

	@Override public void onCompleted(){
		this.hideViewLoading();
	}

	@Override public void onError(Throwable e){
		this.hideViewLoading();
		this.showErrorMessage(new DefaultErrorBundle((Exception) e));
		this.showViewRetry();
	}

	@Override public void onNext(User user){
		this.showUserDetailsInView(user);
	}
}
