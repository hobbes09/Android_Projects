package com.example.trainingapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener, OnItemClickListener{

	private Button loginButton;
	ListView lv;
	String[] data = {"Android","iOS","Symbian"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, data);
		setContentView(R.layout.login);
		lv = (ListView)findViewById(R.id.listView1);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(this);
		loginButton = (Button)findViewById(R.id.bLogin);
		loginButton.setOnClickListener(this);
		
	}
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		/*
		 if(v==loginButton){
		 	SharedPreferences pref = getSharedPreferences("auth", MODE_PRIVATE);
			String userid = pref.getString("userid", null);
			String password = pref.getString("password", null);
		*/
		
		String userid = null, password = null;
		
		DBWrapper wrapper = new DBWrapper(this);
		Cursor c = wrapper.getCredentials();
		
		if(c.getCount()>0){
			c.moveToFirst();
			userid = c.getString(c.getColumnIndex(DBHelper.CLM_USERID));
			password = c.getString(c.getColumnIndex(DBHelper.CLM_PASSWORD));
		}
		
		if(userid == null || password == null){
			Intent i = new Intent(this, Authorization.class);
			startActivity(i);
		}
		else
			Toast.makeText(this, "User already authenticated", Toast.LENGTH_SHORT).show();
	}



	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Selected="+data[position], Toast.LENGTH_SHORT).show();
	}

}
