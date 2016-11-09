package com.nullcognition.compositeandroid.plugin;

import android.util.Log;
import com.pascalwelsch.compositeandroid.activity.ActivityPlugin;

/**
 * Created by mms on 11/8/16.
 */

public class ActivityTracking2 extends ActivityPlugin {

  private static final String TAG = ActivityTracking2.class.getSimpleName();

  @Override public void onResume() {
    super.onResume();
    Log.v(TAG, "#2 onResume()");
  }
}