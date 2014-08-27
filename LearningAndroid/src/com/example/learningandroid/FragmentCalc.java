package com.example.learningandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentCalc extends Fragment{
	int counter=0;
	Button add, sub;
	TextView display;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.calc_fragment, container, false);		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		counter=0;
		add = (Button)getView().findViewById(R.id.bAdd);
		sub = (Button)getView().findViewById(R.id.bSub);
		display = (TextView)getView().findViewById(R.id.tvDisplay);
		
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
