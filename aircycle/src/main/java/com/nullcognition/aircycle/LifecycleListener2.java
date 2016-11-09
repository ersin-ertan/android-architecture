package com.nullcognition.aircycle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by mms on 11/9/16.
 */

public class LifecycleListener2 {

  public void onCreate() {
    Log.i(TAG, "LL2 onCreate: ");
  }

  public void onCreate(MainActivity activity) {
    Log.i(TAG, "LL2 onCreate: with activity " + activity.getClass().getSimpleName());
  }

  public void onDestroy(AppCompatActivity activity) {
    Log.i(TAG, "LL2 onDestroy: with AppCompatActivity " + activity.getClass().getSimpleName());
  }
}
