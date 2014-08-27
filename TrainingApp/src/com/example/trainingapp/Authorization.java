package com.example.trainingapp;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Authorization extends Activity{
	
	EditText userEmail, passwd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.auth);
		
		userEmail = (EditText)findViewById(R.id.edEmail);
		passwd = (EditText)findViewById(R.id.edPass);
		
		displayNotification();
	}

	private void displayNotification() {
		// TODO Auto-generated method stub
		NotificationManager nManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		Notification.Builder builder = new Notification.Builder(this);
		builder.setSmallIcon(R.drawable.ic_launcher);
		builder.setTicker("Please Login");
		builder.setContentTitle("Aunthentication");
		builder.setContentText("Enter Credentials");
		
		Intent i = new Intent(this, Login.class);
		PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
		
		builder.setContentIntent(pi);
		builder.setAutoCancel(true);
		
		Notification myNotification = builder.build(); //builder.getNotification() , use for lower SDK versions
		nManager.notify(1, myNotification);
	}
	
	public void submitClick(View v){
		String userid = userEmail.getText().toString();
		String pass = passwd.getText().toString();
		
		if(userid.length()>0 && pass.length()>0){
			Toast.makeText(this, "Correct data entered", Toast.LENGTH_LONG).show();
			//Save data in Shared Preference
			/*
			SharedPreferences pref = getSharedPreferences("auth", MODE_PRIVATE);
			SharedPreferences.Editor editor = pref.edit();
			editor.putString("userid", userid);
			editor.putString("password", pass);
			editor.commit();
			*/
			
			DBWrapper wrapper = new DBWrapper(this);
			long rowid = wrapper.addCredentials(userid, pass);
			if(rowid != -1)
				Toast.makeText(this, "Data Saved in DB", Toast.LENGTH_LONG).show();
			else
				Toast.makeText(this, "Error saving in DB", Toast.LENGTH_LONG).show();
			
		}
		else
			Toast.makeText(this, "Please enter data", Toast.LENGTH_SHORT).show();
		
	}
	
	public void cancelClick(View v){
		//finish();
		MyDialog dlg = new MyDialog();
		dlg.show(getFragmentManager(), "xyz");
	}
	
}
