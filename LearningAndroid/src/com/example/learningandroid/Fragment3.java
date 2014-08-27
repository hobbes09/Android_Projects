package com.example.learningandroid;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Fragment3 extends ListFragment{
	String [] letters = {"A2", "B2", "C2", "D2", "E2", "F2", "G2"};

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, letters));
	}
	
	public void onListItemSelected(ListView l, View v, int position, long id){
		//Do nothing
	}
}
