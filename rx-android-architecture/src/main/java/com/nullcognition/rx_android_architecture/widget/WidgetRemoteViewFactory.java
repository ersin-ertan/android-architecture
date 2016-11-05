package com.nullcognition.rx_android_architecture.widget;
// ersin 10/10/15 Copyright (c) 2015+ All rights reserved.


import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

public class WidgetRemoteViewFactory implements RemoteViewsService.RemoteViewsFactory{

	public static final String TAG = WidgetRemoteViewFactory.class.getSimpleName();
	private final Context context;

	public WidgetRemoteViewFactory(final Context context){this.context = context;}


	@Override public int            getViewTypeCount()              { return 0;}
	@Override public void           onCreate()                      {}
	@Override public void           onDataSetChanged()              {}
	@Override public void           onDestroy()                     {}
	@Override public long           getItemId(final int position)   { return 0;}
	@Override public boolean        hasStableIds()                  { return false;}
	@Override public RemoteViews    getLoadingView()                { return null;}

	@Override public int getCount(){ return 1;}

	@Override public RemoteViews getViewAt(final int position){
		Log.d(TAG, "getViewAt(" + position + ")");
		return null; // quick fix
		//		return new RemoteViews(context.getPackageName(), R.layout.widget_layout);
	}
}
