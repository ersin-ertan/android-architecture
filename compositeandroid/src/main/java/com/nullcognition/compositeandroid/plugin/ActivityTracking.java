package com.nullcognition.compositeandroid.plugin;

import android.util.Log;
import com.pascalwelsch.compositeandroid.activity.ActivityPlugin;

/**
 * Created by mms on 11/8/16.
 */

public class ActivityTracking extends ActivityPlugin {

  public ActivityTracking() {
    // do something
  }

  @Override public void onStart() {
    super.onStart();
    Log.v("AT", "onStart");
  }
}
