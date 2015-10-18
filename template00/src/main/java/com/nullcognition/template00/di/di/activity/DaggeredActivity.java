package com.nullcognition.template00.di.di.activity;
// ersin 17/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.template00.di.Main2Activity;
import com.nullcognition.template00.di.MainActivity;
import com.nullcognition.template00.di.di.application.App;
import com.nullcognition.template00.di.di.fragment.DaggeredFragment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

import dagger.Provides;
import dagger.Subcomponent;

public class DaggeredActivity{

	@Scope @Retention(RetentionPolicy.RUNTIME) public @interface ActivityScope{ }

	@ActivityScope
	@Subcomponent(modules = { DaggeredActivity.Module.class }) public interface ActivityComponent{

//		void inject(BaseActivity baseActivity);
		void inject(MainActivity mainActivity);
		void inject(Main2Activity main2Activity);

		DaggeredFragment.FragmentComponent plus(DaggeredFragment.Module fragmentModule);
	}


	@dagger.Module public static class Module{

		final private BaseActivity baseActivity;
		public Module(final BaseActivity baseActivity){this.baseActivity = baseActivity;}

		@Provides public BaseActivity provideBaseActivity(){return baseActivity;}
	}


	public static class ComponentHolder{

		private ActivityComponent activityComponent;
		public ActivityComponent getActivityComponent(){return activityComponent;}

		public void releaseActivityComponent(){activityComponent = null;}

		public ActivityComponent createActivityComponent(BaseActivity baseActivity){
			releaseActivityComponent();
			activityComponent =
					App.get(baseActivity)
					   .getAppComponent()
					   .plus(new Module(baseActivity));
			return activityComponent;
		}
	}
}
