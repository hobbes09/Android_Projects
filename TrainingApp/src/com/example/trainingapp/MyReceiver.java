package com.example.trainingapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		
		if(action.equalsIgnoreCase(MyService.ACTION_TASK_COMPLETE)){
			String time = intent.getStringExtra("Time");
			Toast.makeText(context, "Service task completed at "+time, Toast.LENGTH_LONG).show();
		}
		else if(action.equalsIgnoreCase(Intent.ACTION_USER_PRESENT)){
			Toast.makeText(context, "Welcome back", Toast.LENGTH_LONG).show();
		}		
	}	
}

// http://www.tutorialspoint.com/android/android_broadcast_receivers.htm