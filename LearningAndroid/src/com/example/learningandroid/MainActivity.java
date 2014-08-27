package com.example.learningandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {
	
	FragmentManager fm;
	FragmentTransaction ft;
	Fragment myFragment;
	
	Button frag1, frag2, frag3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		frag1 = (Button)findViewById(R.id.button1);
		frag2 = (Button)findViewById(R.id.button2);
		frag3 = (Button)findViewById(R.id.button3);
		
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		
		if (savedInstanceState == null){
			StartFragment myFragment = new StartFragment();
			ft.add(R.id.myFragment, myFragment);
			ft.commit();
		}
		frag1.setOnClickListener(btnOnClickListener);
		frag2.setOnClickListener(btnOnClickListener);
		frag3.setOnClickListener(btnOnClickListener);
		
	}
	
	Button.OnClickListener btnOnClickListener = new Button.OnClickListener(){
		@Override
		public void onClick(View v){
			Fragment newFragment;
			
			if (v == frag1){
				newFragment = new Fragment1();
			} else if (v == frag2){
				newFragment = new Fragment2();
			} else if (v == frag3){
				//newFragment = new Fragment3();
				newFragment = new FragmentCalc();
			} else {
				newFragment = new StartFragment();
			}
			FragmentManager fm1 = getSupportFragmentManager();
			FragmentTransaction ft1 = fm1.beginTransaction();
			ft1.replace(R.id.myFragment, newFragment)
			.addToBackStack(null)
			.commit();
			
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

/* IMPORTANT - MUST READ !

To go from Activity A -> Activity B we use intents. Likewise, to go from Fragment A -> Fragment B, in Activity A, we use FragmentTransactions.

FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
Fragment f = new CustomFragment();
fragmentTransaction.add(R.id.fragment_container, f);
fragmentTransaction.commit();

Also, use addToBackStack() method, in order to return to fragment A from fragment B on pressing back button.
*/