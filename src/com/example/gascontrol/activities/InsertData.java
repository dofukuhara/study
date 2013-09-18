package com.example.gascontrol.activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gascontrol.R;

public class InsertData extends Activity {
	
	TextView lastUpdate;
	RadioGroup radioGroup;
	EditText gasValue;
	EditText totalValue;
	EditText totalKM;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insert_data);
		
		// Display the current Date Information in screen
		lastUpdate = (TextView)findViewById(R.id.displayDateInfo);
		Time now = new Time(Time.getCurrentTimezone());
		now.setToNow();
		lastUpdate.setText("Date: " + now.monthDay + "/" + now.month + "/" + now.year);

		
		radioGroup = (RadioGroup) findViewById(R.id.radioSelGasType);
		gasValue = (EditText) findViewById(R.id.editGasValue);
		totalValue = (EditText) findViewById(R.id.editTotalValue);
		totalKM = (EditText) findViewById(R.id.editTotalKM);
		
	}
	
	public void onClickSaveButton(View v) {
		int id = radioGroup.getCheckedRadioButtonId();
		int gasType = 0;
		
		if (id == -1){
		    //no item selected
		} else if (id == R.id.radioButtonGas){
			gasType=1;
		} else if (id == R.id.radioButtonAlc) {
			gasType=2;
		}
		
		if (gasValue.getText().toString().isEmpty()) {
			Toast.makeText(getApplicationContext(), "Gas Value is empty!\nPlease insert a value", Toast.LENGTH_SHORT).show();
		} else if (totalValue.getText().toString().isEmpty()) {
			Toast.makeText(getApplicationContext(), "Total Gas Value is empty!\nPlease insert a value.", Toast.LENGTH_SHORT).show();
		} else if (totalKM.getText().toString().isEmpty()) {
			Toast.makeText(getApplicationContext(), "Total KM is empty!\nPlease insert a value.", Toast.LENGTH_SHORT).show();
		} else {
			String message = "Gas Type: " + gasType + "\n"
					+ "Gas Value: " + gasValue.getText().toString() + "\n"
					+ "Total Gas Value: " + totalValue.getText().toString() + "\n"
					+ "Total KM: " + totalKM.getText().toString()	;
			Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
			
		}
			
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insert_data, menu);
		return true;
	}

}
