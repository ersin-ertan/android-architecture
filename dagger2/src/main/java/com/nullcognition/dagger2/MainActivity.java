package com.nullcognition.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.nullcognition.dagger2.apis.InjectConstructor;
import com.nullcognition.dagger2.apis.MyClass01;
import com.nullcognition.dagger2.apis.MyClass02;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.Lazy;

public class MainActivity extends AppCompatActivity{

//	@Inject MySingleton mySingleton;

	@Inject @Named("default") MyClass01 myClass01; // singleton
	@Inject @Named("another") MyClass01 anothermyClass01; // singleton

	@Inject MyClass02 myClass02; // !singleton

	@Inject @Named("lazy") Lazy<MyClass01> myClass01Lazy; // mixes @Named and Lazy

	InjectConstructor injectConstructor;

	// you can also inject a provider to work like a factory method
//	@Inject Provider<TextView> textViewProvider;
//
//	{	List<TextView> textViews = new ArrayList<>(1);
//		textViews.add(textViewProvider.get()); // would give you the instance
//	}

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		((App) getApplication()).getComponentMedium().mediumsInject(this);
//		((App) getApplication()).getComponentSmall().smallsInject(this);

		populateTextViews();

	}
	private void populateTextViews(){
		((TextView) findViewById(R.id.tv_injSingleton)).setText("default " + myClass01.getId());
		((TextView) findViewById(R.id.tv_injSingletonAnother)).setText("another " + anothermyClass01.getId());

		// does not work because the call to get creates the instance, and myClass01Lazy as the wrapper
		// is not null

		if(injectConstructor != null){
			((TextView) findViewById(R.id.tv_injConst)).setText(injectConstructor.getId() +
					"i is set:" + injectConstructor.i);

		}

//		if(myClass01Lazy.get() != null){
//// lazy injected, thus may be null until instantiated
//			((TextView) findViewById(R.id.tv_lazy)).setText("lazy " + myClass01Lazy.get().getId());
//		}

		((TextView) findViewById(R.id.tv_injNon)).setText(myClass02.getId());
	}

	//	@OnClick(R.id.btn_injSingleton) void injSingleton(final View view){
//	}
	@OnClick(R.id.btn_getObjG) void getFromObjectGraph(final View view){
		// get from the object graph each time its needed
		injectConstructor = ((App) getApplication()).getComponentMedium().injectConstuctorClass();
		if(injectConstructor.i == 0){ injectConstructor.setI(1);}
		// test to see if the object graph is retained on rotation
		else if(injectConstructor.i == 1){injectConstructor.i = 2;} // == 2, it is saved on rotation

		((TextView) findViewById(R.id.tv_injConst)).setText(injectConstructor.getId() +
				"i is set:" + injectConstructor.i);
	}

	@OnClick(R.id.btn_lazyInj) void lazyInj(final View view){ // get needed, just like thread local
		((TextView) findViewById(R.id.tv_lazy)).setText("lazy " + myClass01Lazy.get().getId());
		// subsequent calls will get the same instance
	}

}
