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
import com.nullcognition.cleanarchitecture.presentation.view.UserListView;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

@PerActivity
public class UserListPresenter extends DefaultSubscriber<List<User>> implements Presenter{

	private UserListView viewListView;

	private final UseCase             getUserListUseCase;
	private final UserModelDataMapper userModelDataMapper;

	@Inject
	public UserListPresenter(@Named("userList") UseCase getUserListUserCase, UserModelDataMapper userModelDataMapper){
		this.getUserListUseCase = getUserListUserCase;
		this.userModelDataMapper = userModelDataMapper;
	}

	public void setView(@NonNull UserListView view){
		this.viewListView = view;
	}

	@Override public void resume(){}

	@Override public void pause(){}

	@Override public void destroy(){
		this.getUserListUseCase.unsubscribe();
	}

	public void initialize(){
		this.loadUserList();
	}

	private void loadUserList(){
		this.hideViewRetry();
		this.showViewLoading();
		this.getUserList();
	}

	public void onUserClicked(UserModel userModel){
		this.viewListView.viewUser(userModel);
	}

	private void showViewLoading(){
		this.viewListView.showLoading();
	}

	private void hideViewLoading(){
		this.viewListView.hideLoading();
	}

	private void showViewRetry(){
		this.viewListView.showRetry();
	}

	private void hideViewRetry(){
		this.viewListView.hideRetry();
	}

	private void showErrorMessage(ErrorBundle errorBundle){
		String errorMessage = ErrorMessageFactory.create(this.viewListView.getContext(),
				errorBundle.getException());
		this.viewListView.showError(errorMessage);
	}

	private void showUsersCollectionInView(Collection<User> usersCollection){
		final Collection<UserModel> userModelsCollection =
				this.userModelDataMapper.transform(usersCollection);
		this.viewListView.renderUserList(userModelsCollection);
	}

	private void getUserList(){
		this.getUserListUseCase.execute(this);
	}

	@Override public void onCompleted(){
		this.hideViewLoading();
	}

	@Override public void onError(Throwable e){
		this.hideViewLoading();
		this.showErrorMessage(new DefaultErrorBundle((Exception) e));
		this.showViewRetry();
	}

	@Override public void onNext(List<User> users){
		this.showUsersCollectionInView(users);
	}
}
