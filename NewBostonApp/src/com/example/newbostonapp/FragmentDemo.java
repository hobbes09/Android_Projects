package com.example.newbostonapp;

//Fragments can't exist on their own... they have to be part of an activity
//Fragments have their own UI and controls
//Fragment life cycle is tied with Activity Life cycle
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FragmentDemo extends FragmentActivity{	//extend Fragment activity if the activity has fragments...Fragment Activity is a subclass of Activity

	int counter=0;
	Button add, sub;
	TextView display;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		counter=0;
		add = (Button)findViewById(R.id.bAdd);
		sub = (Button)findViewById(R.id.bSub);
		display = (TextView)findViewById(R.id.tvDisplay);
				
		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				counter++;
				display.setText("Your total is: "+ counter);
			}
		});
		
		sub.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				counter--;
				display.setText("Your total is: "+ counter);
			}
		});
	
		
	}
	
}
