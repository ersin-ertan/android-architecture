package com.nullcognition.rxpermission;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.tbruyelle.rxpermissions.RxPermissions;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RxPermissions rx = new RxPermissions(this);

    rx.request(Manifest.permission.READ_EXTERNAL_STORAGE).subscribe(new Action1<Boolean>() {
      @Override public void call(Boolean aBoolean) {

      }
    }, new Action1<Throwable>() {
      @Override public void call(Throwable throwable) {
        Log.e(" ", throwable.getMessage());
      }
    });
  }
}
