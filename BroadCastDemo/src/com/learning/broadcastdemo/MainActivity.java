package com.learning.broadcastdemo;


import java.util.Calendar;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends Activity {

	public static String ACTION_TASK_COMPLETE = "com.learning.action.dynamicbroadcast";
	
	public DynamicReceiver dyReceiver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Dynamic registering of broadcast
		dyReceiver = new DynamicReceiver();
		IntentFilter filter = new IntentFilter(ACTION_TASK_COMPLETE);
		registerReceiver(dyReceiver, filter);
		

	}

	public void sendCustomBroadCast(View v){
		Intent i = new Intent();
		i.setAction("com.learning.action.custombroadcast");
		sendBroadcast(i);
	}
	
	public void sendDynamicCustomBroadCast(View v){
		Intent i = new Intent(ACTION_TASK_COMPLETE);
		i.putExtra("Time", Calendar.getInstance().getTime().toString());
		sendBroadcast(i);
	}

	public void onDestroy(){
		super.onDestroy();
		//Dynamic unregistering of broadcast
		unregisterReceiver(dyReceiver);
	}
	
}
