package com.nullcognition.practice00;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity{

	public static final String TAG = MainActivity.class.getSimpleName();
	Frag frag;

	View button;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Frag existing = (Frag) getSupportFragmentManager().findFragmentByTag(Frag.TAG);
		if(existing != null){
			Log.e(TAG, "Frag from fragmentManager");
			frag = existing;
		}

		button = findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener(){
			@Override public void onClick(final View v){

				if(frag == null){
					Log.e(TAG, "new Frag()");
					frag = new Frag();
					getSupportFragmentManager().beginTransaction().add(frag, Frag.TAG).commit();
				}
				else{
					frag.state = 1;
					Log.e(TAG, "Activity Frag State:" + String.valueOf(frag.state));

					frag.retainable.state = 1;
					Log.e(TAG, "Activity Retainable State:" + String.valueOf(frag.retainable.state));

					frag.obj.state = 1;
					Log.e(TAG, "Activity Obj State: " + String.valueOf(frag.obj.state));
				}

			}
		});
	}


}
