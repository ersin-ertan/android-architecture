package com.nullcognition.aircycle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

/**
 * Created by mms on 11/9/16.
 */

public class LifecycleListener {

  public void onCreate() {
    Log.i(TAG, "LL onCreate: ");
  }

  public void onCreate(MainActivity activity) {
    Log.i(TAG, "LL onCreate: with activity" + activity.getClass().getSimpleName());
    Toast.makeText(activity, "Oncreate toast", Toast.LENGTH_SHORT).show();
  }

  public void onDestroy(AppCompatActivity activity) {
    Log.i(TAG, "LL onDestroy: with AppCompatActivity" + activity.getClass().getSimpleName());
  }
}
