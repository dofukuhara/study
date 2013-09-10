package com.example.gascontrol.activities;

import com.example.gascontrol.R;
import com.example.gascontrol.R.layout;
import com.example.gascontrol.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class InsertData extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insert_data);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insert_data, menu);
		return true;
	}

}
