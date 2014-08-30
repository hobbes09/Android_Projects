package com.learning.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DynamicReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		
		if(action.equalsIgnoreCase(MainActivity.ACTION_TASK_COMPLETE)){
			String time = intent.getStringExtra("Time");
			Toast.makeText(context, "Dynamic Broadcast completed at "+time, Toast.LENGTH_LONG).show();
		}

	}

}
