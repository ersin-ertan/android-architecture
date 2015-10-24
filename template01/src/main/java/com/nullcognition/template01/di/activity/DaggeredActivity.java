package com.nullcognition.template01.di.activity;
// ersin 21/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.template01.di.application.App;
import com.nullcognition.template01.di.fragment.DaggeredFragment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

import dagger.Provides;
import dagger.Subcomponent;

public class DaggeredActivity{


	@Scope @Retention(RetentionPolicy.RUNTIME) public @interface ActivityScope{ }


	@ActivityScope
	@Subcomponent(modules = { DaggeredActivity.Module.class }) public interface ActivityComponent{

		void inject(BaseActivity baseActivity);

		DaggeredFragment.FragmentComponent plus(DaggeredFragment.Module fragmentModule);
	}


	@dagger.Module public static class Module{

		final private BaseActivity baseActivity;

		public Module(final BaseActivity baseActivity){this.baseActivity = baseActivity;}

		@ActivityScope
		@Provides public BaseActivity provideBaseActivity(){return baseActivity;}
	}


	public static class ComponentHolder{

		private ActivityComponent activityComponent;

		public ActivityComponent getActivityComponent(){return activityComponent;}

		public ActivityComponent createActivityComponent(BaseActivity baseActivity){
			releaseActivityComponent();
			activityComponent =
					App.get(baseActivity)
					   .getAppComponent()
					   .plus(new Module(baseActivity));
			return activityComponent;
		}

		public void releaseActivityComponent(){activityComponent = null;}
	}
}
