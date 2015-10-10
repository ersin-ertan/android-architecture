package com.nullcognition.cleanarchitecture.presentation.view;
// ersin 09/10/15 Copyright (c) 2015+ All rights reserved.

import android.content.Context;

public interface LoadDataView{

	void showLoading();

	void hideLoading();

	void showRetry();

	void hideRetry();

	void showError(String message);

	Context getContext();
}
