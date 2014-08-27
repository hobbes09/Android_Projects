package com.example.newbostonapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{
	
	String classes[] = {"MainActivity", "TextPlay", "Email", "Camera", "Data", "Example5"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//in place of setContentView
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Class ourclass = null;
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String selector = classes[position];
		try{
			ourclass = Class.forName("com.example.newbostonapp."+selector);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Intent ourintent = new Intent(Menu.this, ourclass);
		startActivity(ourintent);
	}
	
}
