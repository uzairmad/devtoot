package com.example.activebartest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

//Search SearchActivity class, should display ONE result
public class SearchActivity extends ActionBarActivity {
	TextView tx;
	int index = 0;
	boolean resultFound = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);

		tx = (TextView) findViewById(R.id.result_text);

		Intent intent = getIntent();
		String resultLang = intent.getStringExtra(HomeActivity.EXTRA_NAME);

		for (int i = 0; i < HomeActivity.languageArray.size(); i++) {

			String language = HomeActivity.languageArray.get(i).getname();
			
			String language_nonCase = language.toLowerCase(); //cast language name to lowercase
			String result_nonCase = resultLang.toLowerCase(); //cast search term to lowercase

			if (result_nonCase.equals(language_nonCase)) { //compare lowecase terms 

				index = i;
				resultFound = true;

			}
		}

		if (resultFound) {
			//result found and language will be displayed
			String properResult = HomeActivity.languageArray.get(index).getname();
			tx.setText(properResult + "                            ");
			
		} else {
			//no results
			tx.setText("No Result Found For" + resultLang);

		}

		tx.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// make sure result was found before we do somethinng with click
				if (resultFound) {
					// start activity of options for language

					Language lang = HomeActivity.languageArray.get(index);
					Intent optionsIntent = new Intent(SearchActivity.this,
							LanguageOptions.class);

					optionsIntent.putExtra(getString(R.string.extra_object),
							lang); // temp out,
					startActivity(optionsIntent);

				}
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.results, menu);
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
