package com.nullcognition.cleanarchitecture.presentation.view;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.cleanarchitecture.presentation.model.UserModel;

import java.util.Collection;

public interface UserListView extends LoadDataView{

	void renderUserList(Collection<UserModel> userModelCollection);

	void viewUser(UserModel userModel);
}
