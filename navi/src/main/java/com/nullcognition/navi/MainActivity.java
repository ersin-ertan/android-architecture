package com.nullcognition.navi;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.trello.navi.Event;
import com.trello.navi.Listener;
import com.trello.navi.NaviComponent;
import com.trello.navi.component.support.NaviAppCompatActivity;

public class MainActivity extends NaviAppCompatActivity{

	public NaviComponent naviComponent = this;
	public static int i;

	public MainActivity(){
		naviComponent.addListener(Event.PAUSE, new Listener<Void>(){
			@Override public void call(final Void aVoid){

				Toast.makeText(MainActivity.this, "navicomponent call" + ++i, Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}
}

