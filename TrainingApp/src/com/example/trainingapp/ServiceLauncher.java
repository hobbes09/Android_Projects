package com.example.trainingapp;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class ServiceLauncher extends Activity{
	
	public MyReceiver receiver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.servicelauncher);
		
		//Register receiver
		receiver = new MyReceiver();
		IntentFilter filter = new IntentFilter(MyService.ACTION_TASK_COMPLETE);
		registerReceiver(receiver, filter);
		
	}
	
	public void serviceButtonCLick(View v){
		Intent i = new Intent(this, MyService.class);
		startService(i);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(receiver);
	}

}
