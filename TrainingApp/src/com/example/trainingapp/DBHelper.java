package com.example.trainingapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	public static final String DB_NAME = "auth.db";
	public static final String TABLE_NAME = "credentials";
	public static final String CLM_USERID = "userid";
	public static final String CLM_PASSWORD = "password";
	public static final String TABLE_QUERY = "create table "+TABLE_NAME+"("+CLM_USERID+" text,"+CLM_PASSWORD+" text)";
	
	public DBHelper(Context context) {
		super(context, DB_NAME, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(TABLE_QUERY);

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
