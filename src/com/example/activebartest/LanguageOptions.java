package com.example.activebartest;

import java.util.ArrayList;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class LanguageOptions extends ActionBarActivity {

	ListView listview;
	ArrayList<String> optionsList = new ArrayList<String>();
	Language languageObject;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_language_options);

		listview = (ListView) findViewById(R.id.listview_options);

		Intent intent = getIntent();
		languageObject = (Language) intent
				.getParcelableExtra(getString(R.string.extra_object));

		String name = languageObject.getname();
		String description = languageObject.getname();
		optionsList.add("Description");
		optionsList.add("History of " + name);
		optionsList.add("Installing " + name);
		optionsList.add("Your First Program");
		
		MyListAdapter listAdapter = new MyListAdapter(this, optionsList);
		listview.setAdapter(listAdapter);
		registerListClick();
		
		
	}

	private void registerListClick() {
		listview = (ListView) findViewById(R.id.listview_options);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {
			
				switch (position) {

				case 0: //Description
					//Do nothing just display
					
					break;
				case 1: //History
					Intent historyIntent = new Intent(LanguageOptions.this, HistoryActivity.class);
					historyIntent.putExtra(getString(R.string.extra_object),
							languageObject); // temp out,					
					startActivity(historyIntent);
					
					//Start History Activity
					break;
				case 2: //Installing
					
					startActivity(new Intent(
							Intent.ACTION_VIEW,
							Uri.parse(languageObject.getLangURL())));
					break;
				case 3: //Program
					startActivity(new Intent(
							Intent.ACTION_VIEW,
							Uri.parse(languageObject.getProgramURL())));
					
					break;
				default:
					break;

				}


			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.language_options, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
