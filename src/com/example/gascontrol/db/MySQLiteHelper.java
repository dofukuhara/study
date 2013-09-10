package com.example.gascontrol.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {
	
	  public static final String TABLE_GASDB = "gasdb";
	  public static final String COLUMN_ID = "_ID";
	  public static final String COLUMN_GASTYPE = "GASTYPE";
	  public static final String COLUMN_GASVALUE = "GASVALUE";
	  public static final String COLUMN_TOTALVALUE = "TOTALVALUE";
	  public static final String COLUMN_TOTALKM = "TOTALKM";
	  public static final String COLUMN_DATE = "DATE";
	  public static final String COLUMN_RENDIMENTO = "RENDIMENTO";
	  
	  private static final String DATABASE_NAME = "gasdb.db";
	  private static final int DATABASE_VERSION = 1;
	  
	  // Database creation sql statement
	  private static final String DATABASE_CREATE = "create table "
	      + TABLE_GASDB + "(" 
	      + COLUMN_ID + " integer primary key autoincrement, " 
	      + COLUMN_GASTYPE + "integer not null, "
	      + COLUMN_GASVALUE + "integer not null, "
	      + COLUMN_TOTALVALUE + "integer not null, "
   	      + COLUMN_TOTALKM + "integer not null, "
   	      + COLUMN_DATE + "text not null, "
	      + COLUMN_RENDIMENTO  + " integer not null);";

	  public MySQLiteHelper(Context context) {
	    super(context, DATABASE_NAME, null, DATABASE_VERSION);
	  }

	  @Override
	  public void onCreate(SQLiteDatabase database) {
	    database.execSQL(DATABASE_CREATE);
	  }

	  @Override
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    Log.w(MySQLiteHelper.class.getName(),
	        "Upgrading database from version " + oldVersion + " to "
	            + newVersion + ", which will destroy all old data");
	    db.execSQL("DROP TABLE IF EXISTS " + TABLE_GASDB);
	    onCreate(db);
	  }
}
