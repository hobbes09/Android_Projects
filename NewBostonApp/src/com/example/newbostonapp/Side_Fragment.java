package com.example.newbostonapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Side_Fragment extends Fragment {
	View view;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view =  inflater.inflate(R.layout.email,container, false);
		return view;
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		}
	
	
}
