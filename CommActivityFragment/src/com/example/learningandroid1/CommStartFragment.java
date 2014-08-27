package com.example.learningandroid1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CommStartFragment extends Fragment{
	
	Button bn;
	EditText ed1; //The edittext in CommMainActivity(level=1)
	TextView tv2;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.comm_start_fragment, container, false); //returns View object
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		bn = (Button)getView().findViewById(R.id.commB2);
		ed1 = (EditText)getActivity().findViewById(R.id.commEd1); //getting string from host activity
		tv2 = (TextView)getView().findViewById(R.id.commTv2);
		
		bn.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fm = getFragmentManager();
				FragmentTransaction ft = fm.beginTransaction();
				CommSecondFragment cf2 = new CommSecondFragment();
				ft.add(R.id.comm_start_fragment_id, cf2);
				ft.commit();

			}
		});
		
		String msg = ed1.getText().toString();
		tv2.setText(msg);
		
	}

}

