package com.example.gascontrol.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class GasDataSource {
	
	// Database fields
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	
	private String[] allColumns = {
			MySQLiteHelper.COLUMN_ID,
			MySQLiteHelper.COLUMN_GASTYPE, 
			MySQLiteHelper.COLUMN_GASVALUE,
			MySQLiteHelper.COLUMN_TOTALVALUE,
			MySQLiteHelper.COLUMN_TOTALKM,
			MySQLiteHelper.COLUMN_DATE,
			MySQLiteHelper.COLUMN_RENDIMENTO
	};

	public GasDataSource (Context context) {
		dbHelper = new MySQLiteHelper(context);
	}
	
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}
	
	public void close() {
		dbHelper.close();
	}
	
	public long insertNewRecord (Dados dado) {
		ContentValues values = new ContentValues();
		long insertID = 0;

		values.put(MySQLiteHelper.COLUMN_GASTYPE, dado.getGasType());
		values.put(MySQLiteHelper.COLUMN_GASVALUE, dado.getGasValue());
		values.put(MySQLiteHelper.COLUMN_TOTALVALUE, dado.getTotalValue());
		values.put(MySQLiteHelper.COLUMN_TOTALKM, dado.getTotalKM());
		values.put(MySQLiteHelper.COLUMN_DATE, dado.getDate());
		
		insertID = database.insert(MySQLiteHelper.TABLE_GASDB, null, values);
		return insertID;
	}
	
	//public Dados createDado(int gasType, long gasValue, long totalValue, long totalKM, String date, long rendimento) {
	public Dados createDado(String teste) {
		ContentValues values = new ContentValues();
//		values.put(MySQLiteHelper.COLUMN_GASTYPE, gasType);
//		values.put(MySQLiteHelper.COLUMN_GASVALUE, gasValue);
//		values.put(MySQLiteHelper.COLUMN_TOTALVALUE, totalValue);
//		values.put(MySQLiteHelper.COLUMN_TOTALKM, totalKM);
//		values.put(MySQLiteHelper.COLUMN_DATE, date);
		values.put(MySQLiteHelper.COLUMN_GASTYPE, 1);
		values.put(MySQLiteHelper.COLUMN_GASVALUE, 1);
		values.put(MySQLiteHelper.COLUMN_TOTALVALUE, 1);
		values.put(MySQLiteHelper.COLUMN_TOTALKM, 1);
		values.put(MySQLiteHelper.COLUMN_DATE, teste);
		values.put(MySQLiteHelper.COLUMN_RENDIMENTO, 1);
//		values.put(MySQLiteHelper.COLUMN_RENDIMENTO, rendimento);
		
		long insertID = database.insert(MySQLiteHelper.TABLE_GASDB, null, values);
		
		Cursor cursor = database.query(MySQLiteHelper.TABLE_GASDB, allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertID, null, null, null, null);
		
		cursor.moveToFirst();
		
		Dados newDado = cursorToDado(cursor);
		cursor.close();
		
		return newDado;
	}
	
	/*
	 * 
	 * public void DeleteDado (int gasType, long gasValue, long totalValue, long totalKM, String date, long rendimento) {
	 * 
	 * }
	 * 
	 * */
	
	public List<Dados> getAllDados() {
		List<Dados> dados = new ArrayList<Dados>();
		
		Cursor cursor = database.query(MySQLiteHelper.TABLE_GASDB, allColumns, null, null, null, null, null);
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Dados dado = cursorToDado(cursor);
			dados.add(dado);
			cursor.moveToNext();
		}
		
		cursor.close();
		return dados;
	}
	
	private Dados cursorToDado (Cursor cursor) {
		Dados dado = new Dados();
		dado.setId(cursor.getLong(0));
		dado.setGasType(cursor.getInt(1));
		dado.setGasValue(cursor.getLong(2));
		dado.setTotalValue(cursor.getLong(3));
		dado.setTotalKM(cursor.getLong(4));
		dado.setDate(cursor.getString(5));
		dado.setRendimento(cursor.getLong(6));
		
		return dado;
	}
}
