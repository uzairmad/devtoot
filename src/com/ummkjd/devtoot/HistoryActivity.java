package com.ummkjd.devtoot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
/*
 * HistoryActivity is a class that handles the display for the History option. 
 * It instantiates textview to display text retrieved from the static languagearray
 */
public class HistoryActivity extends ActionBarActivity {
	
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		
		tv = (TextView) findViewById(R.id.history_view);
		
		Intent intent = getIntent();
		Language obj = (Language) intent
				.getParcelableExtra(getString(R.string.extra_object)); //reference key in XML file
		
		String history = obj.getHistory();
		tv.setText(history);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.history, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		return super.onOptionsItemSelected(item);
	}



}
