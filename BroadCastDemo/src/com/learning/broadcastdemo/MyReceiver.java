package com.learning.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		if(action.equalsIgnoreCase(Intent.ACTION_USER_PRESENT)){
			//Static registered
			Toast.makeText(context, "Hakula Matata", Toast.LENGTH_SHORT).show();
		}
	}

}
