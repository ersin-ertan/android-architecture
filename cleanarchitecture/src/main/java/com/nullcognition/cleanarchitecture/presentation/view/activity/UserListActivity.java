package com.nullcognition.cleanarchitecture.presentation.view.activity;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.nullcognition.cleanarchitecture.R;
import com.nullcognition.cleanarchitecture.presentation.internal.di.HasComponent;
import com.nullcognition.cleanarchitecture.presentation.internal.di.components.DaggerUserComponent;
import com.nullcognition.cleanarchitecture.presentation.internal.di.components.UserComponent;
import com.nullcognition.cleanarchitecture.presentation.model.UserModel;
import com.nullcognition.cleanarchitecture.presentation.view.fragment.UserListFragment;

public class UserListActivity extends BaseActivity implements HasComponent<UserComponent>,
                                                              UserListFragment.UserListListener{

	public static Intent getCallingIntent(Context context){
		return new Intent(context, UserListActivity.class);
	}

	private UserComponent userComponent;

	@Override protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_user_list);

		this.initializeInjector();
	}

	private void initializeInjector(){
		this.userComponent = DaggerUserComponent.builder()
		                                        .applicationComponent(getApplicationComponent())
		                                        .activityModule(getActivityModule())
		                                        .build();
	}

	@Override public UserComponent getComponent(){
		return userComponent;
	}

	@Override public void onUserClicked(UserModel userModel){
		this.navigator.navigateToUserDetails(this, userModel.getUserId());
	}
}
