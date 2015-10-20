package com.nullcognition.template00.di.fragment;
// ersin 17/10/15 Copyright (c) 2015+ All rights reserved.


import com.nullcognition.template00.di.application.App;
import com.nullcognition.template00.di.presenter.BasePresenter;
import com.nullcognition.template00.view.presenter.MainFragmentPresenter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

import dagger.Provides;
import dagger.Subcomponent;

public class DaggeredFragment{

	@Scope @Retention(RetentionPolicy.RUNTIME) public @interface FragmentScope{ }


	@FragmentScope
	@Subcomponent(modules = { DaggeredFragment.Module.class/*, DaggeredPresenter.Module.class */ }) public interface FragmentComponent{

		void inject(BaseViewFragment<MainFragmentPresenter> baseViewFragment);

//				void inject(BaseViewFragment<BasePresenter> baseViewFragment);
		// will now have to create an injection for each type and have a cast in the fragment's inject() method
	}


	@dagger.Module public static class Module{

		final private BaseViewFragment baseViewFragment;

		public Module(final BaseViewFragment baseViewFragment){this.baseViewFragment = baseViewFragment;}

		@FragmentScope
		@Provides public BaseViewFragment provideBaseFragment(){return baseViewFragment;}
	}


	public static class ComponentHolder{

		private FragmentComponent fragmentComponent;

		public FragmentComponent getFragmentComponent(){return fragmentComponent;}

		public FragmentComponent createFragmentComponent(BaseViewFragment baseViewFragment){
			releaseFragmentComponent();
			fragmentComponent =
					App.get(baseViewFragment.getContext())
							.activityComponentHolder.getActivityComponent()
							                        .plus(new Module(baseViewFragment));
			return fragmentComponent;
		}

		public void releaseFragmentComponent(){fragmentComponent = null;}
	}
}

