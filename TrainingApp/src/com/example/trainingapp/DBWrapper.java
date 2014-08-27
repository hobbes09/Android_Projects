package com.example.trainingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBWrapper {
	
	private DBHelper helper;
	private SQLiteDatabase db;
	
	public DBWrapper(Context context){
		helper = new DBHelper(context);
		db = helper.getWritableDatabase();
	}
	
	public long addCredentials(String userid, String password){
		ContentValues values = new ContentValues();
		values.put(DBHelper.CLM_USERID, userid);
		values.put(DBHelper.CLM_PASSWORD, password);
		
		long rowid = db.insert(DBHelper.TABLE_NAME, null, values);
		return rowid;
	}
	
	public Cursor getCredentials(){
		//query
		String[] clms = {DBHelper.CLM_USERID, DBHelper.CLM_PASSWORD};
		Cursor c = db.query(DBHelper.TABLE_NAME, clms, null, null, null, null, null);
		return c;
	}
	
	public void closeDB(){
		db.close();
	}

}
