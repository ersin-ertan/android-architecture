package com.nullcognition.compositeandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.nullcognition.compositeandroid.plugin.ActivityTracking;
import com.nullcognition.compositeandroid.plugin.ActivityTracking2;
import com.pascalwelsch.compositeandroid.activity.CompositeActivity;

public class MainActivity extends CompositeActivity {

  public MainActivity() {
    addPlugin(new ActivityTracking2());
    addPlugin(new ActivityTracking());
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final View btn = findViewById(R.id.button);
    assert btn != null;
    btn.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Toast.makeText(MainActivity.this, "Button click", Toast.LENGTH_SHORT).show();
      }
    });
  }
}
