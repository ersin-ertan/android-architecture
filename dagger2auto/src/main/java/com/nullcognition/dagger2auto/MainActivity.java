package com.nullcognition.dagger2auto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import autodagger.AutoComponent;
import javax.inject.Singleton;

@AutoComponent(
    dependencies = App.class,
    modules = MainActivity.Module.class,
    superinterfaces = { App.class, GlobalComponent.class }) @Singleton public class MainActivity
    extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
}
