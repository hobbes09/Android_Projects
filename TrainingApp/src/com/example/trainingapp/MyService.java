package com.example.trainingapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import java.util.*;

public class MyService extends Service{

	public static final String ACTION_TASK_COMPLETE = "com.example.trainingapp.action.task_complete"; //follow convention here
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		// Use this intent to extract data for any task to perform
		Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
		// Thread created here, if application needs it
		
		// Send broadcast for task completion
		Intent i = new Intent(ACTION_TASK_COMPLETE);
		i.putExtra("Time", Calendar.getInstance().getTime().toString());
		sendBroadcast(i);
		
		return super.onStartCommand(intent, flags, startId);
	}

}
