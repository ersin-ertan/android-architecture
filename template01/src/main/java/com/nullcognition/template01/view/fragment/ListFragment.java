//package com.nullcognition.template01.view.fragment;
//// ersin 23/10/15 Copyright (c) 2015+ All rights reserved.
//
//
////import android.databinding.DataBindingUtil;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.nullcognition.template01.di.fragment.BaseViewFragment;
//import com.nullcognition.template01.di.fragment.DaggeredFragment;
//import com.nullcognition.template01.view.controller.ListController;
//import com.nullcognition.template01.view.viewmodel.ListViewModel;
//import com.sora.util.akatsuki.Retained;
//
////import com.nullcognition.template01.databinding.FragmentListBinding;
//
//public class ListFragment extends BaseViewFragment{
//
////	FragmentListBinding binding;
//	@Retained ListViewModel viewModel;
//
//
//	@Override public void onCreate(@Nullable final Bundle savedInstanceState){
//		super.onCreate(savedInstanceState);
//		if(viewModel == null){viewModel = new ListViewModel();}
//		ListController listController = ((ListController) getActivity().getSupportFragmentManager()
//		                                                               .findFragmentByTag(ListController.class.getSimpleName()));
//		if(!listController.isListViewModel()){
//			listController.setListViewModel(viewModel);
//		}
//	}
//
//	@Override protected void injectSelf(
//			final DaggeredFragment.FragmentComponent fragmentComponent){
//		fragmentComponent.inject(this);
//	}
//
//	@Nullable @Override public View onCreateView(final LayoutInflater inflater,
//	                                             final ViewGroup container,
//	                                             final Bundle savedInstanceState){
////		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
////		ButterKnife.bind(this, binding.getRoot());
////		binding.setViewModel(viewModel);
////		binding.setController(
////				((ListController) getActivity()
////						.getSupportFragmentManager()
////						.findFragmentByTag(ListController.class.getSimpleName())
////				)
////		);
////		return binding.getRoot();
//		return null;// quick // FIXME: 6/7/16 building module
//	}
//
//	@Override protected int getLayout(){
//		return 0;
//	}
//}
