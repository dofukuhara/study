package com.example.gascontrol.activities;

import java.util.List;
import java.util.Random;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.gascontrol.R;
import com.example.gascontrol.db.Dados;
import com.example.gascontrol.db.GasDataSource;

public class TestDatabaseActivity extends ListActivity {
	  private GasDataSource datasource;

	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);

	    datasource = new GasDataSource(this);
	    datasource.open();

	    List<Dados> values = datasource.getAllDados();

	    // Use the SimpleCursorAdapter to show the
	    // elements in a ListView
	    ArrayAdapter<Dados> adapter = new ArrayAdapter<Dados>(this,
	        android.R.layout.simple_list_item_1, values);
	    setListAdapter(adapter);
	  }

	  // Will be called via the onClick attribute
	  // of the buttons in main.xml
	  public void onClick(View view) {
	    @SuppressWarnings("unchecked")
	    ArrayAdapter<Dados> adapter = (ArrayAdapter<Dados>) getListAdapter();
	    Dados dado = null;
	    switch (view.getId()) {
	    case R.id.add:
	      String[] infos = new String[] { "Cool", "Very nice", "Hate it" };
	      int nextInt = new Random().nextInt(3);
	      // Save the new comment to the database
//	      comment = datasource.createDado(comments[nextInt]);
	      dado = datasource.createDado(infos[nextInt]);
	      adapter.add(dado);
	      break;
	    }
	    adapter.notifyDataSetChanged();
	  }

	  @Override
	  protected void onResume() {
	    datasource.open();
	    super.onResume();
	  }

	  @Override
	  protected void onPause() {
	    datasource.close();
	    super.onPause();
	  }

	} 