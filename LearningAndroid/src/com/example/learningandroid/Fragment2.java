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
public class Fragment2 extends ListFragment{
	String [] letters = {"A1", "B1", "C1", "D1", "E1", "F1", "G1"};

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
