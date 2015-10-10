package com.nullcognition.cleanarchitecture.presentation.view;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.cleanarchitecture.presentation.model.UserModel;

public interface UserDetailsView extends LoadDataView{

	void renderUser(UserModel user);
}
