package com.nullcognition.cleanarchitecture.presentation.view.activity;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.nullcognition.cleanarchitecture.R;
import com.nullcognition.cleanarchitecture.domain.User;
import com.nullcognition.cleanarchitecture.presentation.internal.di.HasComponent;
import com.nullcognition.cleanarchitecture.presentation.internal.di.components.DaggerUserComponent;
import com.nullcognition.cleanarchitecture.presentation.internal.di.components.UserComponent;
import com.nullcognition.cleanarchitecture.presentation.internal.di.modules.UserModule;
import com.nullcognition.cleanarchitecture.presentation.view.fragment.UserDetailsFragment;

public class UserDetailsActivity extends BaseActivity implements HasComponent<UserComponent>{

	private static final String INTENT_EXTRA_PARAM_USER_ID = "org.android10.INTENT_PARAM_USER_ID";
	private static final String INSTANCE_STATE_PARAM_USER_ID = "org.android10.STATE_PARAM_USER_ID";

	private int userId;
	private UserComponent userComponent;

	public static Intent getCallingIntent(Context context, int userId) {
		Intent callingIntent = new Intent(context, UserDetailsActivity.class);
		callingIntent.putExtra(INTENT_EXTRA_PARAM_USER_ID, userId);

		return callingIntent;
	}

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_user_details);

		this.initializeActivity(savedInstanceState);
		this.initializeInjector();
	}

	@Override protected void onSaveInstanceState(Bundle outState) {
		if (outState != null) {
			outState.putInt(INSTANCE_STATE_PARAM_USER_ID, this.userId);
		}
		super.onSaveInstanceState(outState);
	}

	/**
	 * Initializes this activity.
	 */
	private void initializeActivity(Bundle savedInstanceState) {
		if (savedInstanceState == null) {
			this.userId = getIntent().getIntExtra(INTENT_EXTRA_PARAM_USER_ID, -1);
			addFragment(R.id.fl_fragment, UserDetailsFragment.newInstance(this.userId));
		} else {
			this.userId = savedInstanceState.getInt(INSTANCE_STATE_PARAM_USER_ID);
		}
	}

	private void initializeInjector() {
		this.userComponent = DaggerUserComponent.builder()
		                                        .applicationComponent(getApplicationComponent())
		                                        .activityModule(getActivityModule())
		                                        .userModule(new UserModule(this.userId))
		                                        .build();
	}

	@Override public UserComponent getComponent() {
		return userComponent;
	}
}
