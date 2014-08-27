package com.example.newbostonapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener, OnCheckedChangeListener{

	TextView question, test;
	Button returnData;
	RadioGroup selectionList;
	String gotBread, sentData;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		initialize();
		//Bundle gotBasket = getIntent().getExtras();
		//gotBread = gotBasket.getString("key");
		//question.setText(gotBread);
	}
	
	private void initialize() {
		// TODO Auto-generated method stub
		question = (TextView)findViewById(R.id.tvQuestion);
		test = (TextView)findViewById(R.id.tvText);
		returnData = (Button)findViewById(R.id.bReturn);
		selectionList = (RadioGroup)findViewById(R.id.rgAnswers);
		selectionList.setOnCheckedChangeListener(this);
		returnData.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent person = new Intent();
		Bundle backpack = new Bundle();
		backpack.putString("answer", sentData);
		person.putExtras(backpack);
		setResult(RESULT_OK, person);
		finish();
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch(arg1){
		case R.id.rCrazy:
			sentData = "Probably Right !";
			break;
		case R.id.rAwesome:
			sentData = "Definately Right !";
			break;
		case R.id.rDude:
			sentData = "Spot on !";
			break;
		}
		test.setText(sentData);
	}
	
	
}
