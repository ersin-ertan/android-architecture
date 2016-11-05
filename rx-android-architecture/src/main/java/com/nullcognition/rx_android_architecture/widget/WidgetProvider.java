package com.nullcognition.rx_android_architecture.widget;
// ersin 10/10/15 Copyright (c) 2015+ All rights reserved.


import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;

public class WidgetProvider extends AppWidgetProvider{

	public static final String ACTION_REFRESH = "com.nullcognition.rx-android-architecture.REFRESH";
	public static final String WIDGET_ID      = "WIDGET ID";

	@Override public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
		super.onUpdate(context, appWidgetManager, appWidgetIds);

		for(int appWidgetId : appWidgetIds){
			//			Intent intentService = new Intent(context, WidgetService.class);
			//			intentService.setAction(ACTION_REFRESH);
			//			intentService.putExtra(WIDGET_ID, appWidgetId);
			//			context.startService(intentService);
		}
	}
}
