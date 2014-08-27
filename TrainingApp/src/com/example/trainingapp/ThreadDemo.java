package com.example.trainingapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

public class ThreadDemo extends Activity {

	private static final String THREADLOG = "THREADLOG";
	private TextView tv;
	private Handler handler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.threadingdemo);
		tv = (TextView)findViewById(R.id.tvThread);
		//MyTask t = new MyTask();
		//t.execute("Hello","World,","Calvin");
		Log.v(THREADLOG, "MainActivity class using...." + Thread.currentThread().getName());
		Thread t = new Thread(new MyThread("Hello1","World1,","Calvin1"));
		t.start();
	}

	private class MyTask extends AsyncTask<String, Void, String>{

		@Override
		protected String doInBackground(String... params) {
			String result = "";
			for(int i = 0; i < params.length; i++)
				result+=params[i]+" ";
			return result;
		}
		
		protected void onPostExecute(String result){
			tv.setText(result);
		}
		
	}
	
	public class MyThread implements Runnable{

		private static final String THREADLOG = "THREADLOG";
		String[] params;
		
		public MyThread(String... params){
			this.params = params;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			String result = "";
			for(int i = 0; i < params.length; i++)
				result+=params[i]+" ";
			Log.v(THREADLOG, "MyThread class using ...." + Thread.currentThread().getName());
			handler.post(new UpdateResult(result));
		}	
	}

	private class UpdateResult implements Runnable{
		
		private static final String THREADLOG = "THREADLOG";
		String result;
		public UpdateResult(String result){
			this.result = result;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			tv.setText("Using java thread, result = "+this.result);
			Log.v(THREADLOG, "UpdateResult class using...." + Thread.currentThread().getName());
		}
		
	}
	
}
