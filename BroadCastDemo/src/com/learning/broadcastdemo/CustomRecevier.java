package com.learning.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomRecevier extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		if(action.equalsIgnoreCase("com.learning.action.custombroadcast")){
			Toast.makeText(context, "Custom Broadcast received", Toast.LENGTH_LONG).show();
		}
	}

}
