package com.example.trainingapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class MyDialog extends DialogFragment{

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Dialog dlg = null;
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("Confirmation");
		builder.setMessage("Do you want to exit ?");
		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				getActivity().finish();
			}
		});
		
		builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		});
		
		dlg = builder.create();
		
		return dlg;
	}

	
	
}
