package com.nullcognition.template00.di.presenter;
// ersin 19/10/15 Copyright (c) 2015+ All rights reserved.


public class DaggeredPresenter{

//	@Scope @Retention(RetentionPolicy.RUNTIME) public @interface PresenterScope{ }
//
//
//	@DaggeredPresenter.PresenterScope
//	@Subcomponent(modules = { DaggeredPresenter.Module.class }) public interface PresenterComponent{
//
//		void inject(BasePresenter basePresenter);
//	}
//


//	@dagger.Module public static class Module{
//
//		@DaggeredFragment.FragmentScope
//		@Provides public BasePresenter provideBasePresenter(BaseViewFragment baseViewFragment){
//			return new BasePresenter(baseViewFragment);
//		}
//	}


//	public static class ComponentHolder{
//
//		private PresenterComponent fragmentComponent;
//		public PresenterComponent getPresenterComponent(){ return fragmentComponent;}
//
//		public void releasePresenterComponent(){fragmentComponent = null;}
//
//		public PresenterComponent createPresenterComponent(BasePresenter baseViewPresenter){
//			releasePresenterComponent();
//			fragmentComponent =
//					((BaseActivity) baseViewPresenter.baseViewFragment.getActivity())
//							.fragmentComponentHolder.getFragmentComponent()
//							                        .plus(new Module(baseViewPresenter));
//			return fragmentComponent;
//		}
}

