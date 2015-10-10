package com.nullcognition.cleanarchitecture.presentation.internal.di.components;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.cleanarchitecture.presentation.internal.di.PerActivity;
import com.nullcognition.cleanarchitecture.presentation.internal.di.modules.ActivityModule;
import com.nullcognition.cleanarchitecture.presentation.internal.di.modules.UserModule;
import com.nullcognition.cleanarchitecture.presentation.view.fragment.UserDetailsFragment;
import com.nullcognition.cleanarchitecture.presentation.view.fragment.UserListFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = { ActivityModule.class, UserModule.class })
public interface UserComponent extends ActivityComponent{

	void inject(UserListFragment userListFragment);
	void inject(UserDetailsFragment userDetailsFragment);
}
