package com.example.commftof;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class FirstFragment extends Fragment {
	
	SendMessage SM;
	Button b1;
	EditText ed1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		return inflater.inflate(R.layout.fragment_one, container, false); //returns View object
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		ed1 = (EditText)getView().findViewById(R.id.ed1);
		b1 = (Button)getView().findViewById(R.id.b1);
				
		b1.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String Message;
			Message = ed1.getText().toString();
			SM.sendData(Message);
			}
					
		});
				
	}

	interface SendMessage{
		public void sendData(String message);
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		try{
			SM = (SendMessage)activity;
		}catch(ClassCastException e){
			throw new ClassCastException("You need to implement sendData method");
		}
	}

	
}
