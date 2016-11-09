package com.nullcognition.aircycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.github.simonpercic.aircycle.AirCycle;

public class MainActivity extends AppCompatActivity {

  public static final String TAG = "AIRCYCLE";
  @AirCycle LifecycleListener listener;
  @AirCycle LifecycleListener2 listenerOnConstructor;

  // constructor must be public
  public MainActivity() {
    //bindMainActivityAirCycle(); // remember that this doesn't work because this, is not initialized within the constructor
    Log.i(TAG, "onCreate: pre lifecycler on constructor new");
    listenerOnConstructor =
        new LifecycleListener2(); // this is proving that lifecycle listener creation is
    // not tied to constructor, may be created any where, unless relying on other components being passed in after
    // onCreate initialization
    Log.i(TAG, "onCreate: post" + " lifecycler on constructor new");
  }

  @Override protected void onCreate(Bundle savedInstanceState) {

    bindMainActivityAirCycle(); // binding MUST occur before on create super

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Log.i(TAG, "onCreate: pre lifecycler new");
    listener = new LifecycleListener();
    Log.i(TAG, "onCreate: post" + " lifecycler new");
  }

  public void bindMainActivityAirCycle() {
    Log.i(TAG, "onCreate: Prebind");
    MainActivityAirCycle.bind(this); // MainActivityAirCycle is generated
    Log.i(TAG, "onCreate: Post - Bind");
  }
}
