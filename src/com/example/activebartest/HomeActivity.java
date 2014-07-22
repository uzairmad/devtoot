package com.example.activebartest;

import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends ActionBarActivity implements
		SearchView.OnQueryTextListener {
	public final static String EXTRA_NAME = "com.example.activebartest.NAME";
	SearchView mSearchView;
	ExpandableListView exp;
	ListView listview;
	public static ArrayList<Language> languageArray = new ArrayList<Language>();
	ArrayList<String> listViewArrayList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		exp = (ExpandableListView) findViewById(R.id.expandableListView_test);
		listview = (ListView) findViewById(R.id.listView_test);

		loadLangArray(); // instantiate and fill languageArray with Language
							// objects AND listview arraylist

		ArrayAdapter listAdapter = new ArrayAdapter(this,
				R.layout.video_list_item, listViewArrayList);
		listview.setAdapter(listAdapter);

		// /expandable list stuff
		CustomAdapter myadapter = new CustomAdapter(this);
		exp.setAdapter(myadapter);
		registerExpandListClick();

		exp.setVisibility(View.GONE); // set listview to show by default
		registerListViewClick(); // register listview

	}

	public void loadLangArray() {

		Language java = new Language("Java", "https://www.youtube.com", // URL
																		// for
																		// installing
																		// Java
																		// video
				"https://www.youtube.com");// URL for first java program video
		Language SQL = new Language("SQL", "https://www.youtube.com", // same as
																		// above
				"https://www.youtube.com");
		Language Perl = new Language("Perl", "https://www.youtube.com",
				"https://www.youtube.com");
		Language PHP = new Language("PHP", "https://www.youtube.com",
				"https://www.youtube.com");
		java.setHistory("Add History for Java "); // Enter text for history
		java.setDescription("Java is an object-oriented programming language developed "
				+ "by Sun Microsystems. Java is a platform-independent, multi-threaded programming "
				+ "environment designed for creating programs and applications for the Internet and "
				+ "Intranets."); // Enter text for description
		SQL.setHistory(" ");
		Perl.setHistory("");
		PHP.setHistory(" ");

		listViewArrayList.add(java.getname()); // add name to ListView
		listViewArrayList.add(SQL.getname());
		listViewArrayList.add(Perl.getname());
		listViewArrayList.add(PHP.getname());

		languageArray.add(java); // add objects to Language arrayList
		languageArray.add(Perl);
		languageArray.add(PHP);
		languageArray.add(SQL);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		MenuItem searchItem = menu.findItem(R.id.action_search);

		mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
		mSearchView.setQueryHint("Search");
		mSearchView.setOnQueryTextListener(this); // sets listeneter for changes
													// when somoene enters stuf
													// finto searchview, this
													// cuz this class implements
													// it

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
		} else if (id == R.id.action_search) {

			mSearchView.setIconified(false);

			return true;

		} else if (id == R.id.action_sort) {
			View menuItemView = findViewById(R.id.action_sort); // SAME ID AS
																// MENU ID

			PopupMenu popupMenu = new PopupMenu(this, menuItemView);
			/** Adding menu items to the popumenu */
			popupMenu.getMenuInflater().inflate(R.menu.popup,
					popupMenu.getMenu());
			/** Defining menu item click listener for the popup menu */
			popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {

				@Override
				public boolean onMenuItemClick(MenuItem popItem) {
					int popID = popItem.getItemId();

					if (popID == R.id.action1) { // type

						// Toast.makeText(HomeActivity.this,
						// "You selected the action Type",
						// Toast.LENGTH_SHORT).show();
						listview.setVisibility(View.GONE);
						exp.setVisibility(View.VISIBLE);
					} else if (popID == R.id.action2) { // alpha

						// Toast.makeText(HomeActivity.this,
						// "You selected the action Alpha ",
						// Toast.LENGTH_SHORT).show();
						exp.setVisibility(View.GONE);
						listview.setVisibility(View.VISIBLE);
					}

					return true;
				}
			});
			// ...
			popupMenu.show();
			// ...
			return true;
		}

		// return super.onOptionsItemSelected(item);

		return false;
	}

	@Override
	public boolean onQueryTextChange(String s) {

		return true;
	}

	@Override
	public boolean onQueryTextSubmit(String s) {

		// String result = s.toLowerCase();
		String result = s.trim();
		Intent intent = new Intent(this, SearchActivity.class);
		intent.putExtra(EXTRA_NAME, result);
		startActivity(intent);

		return false;
	}

	private void registerListViewClick() {
		listview = (ListView) findViewById(R.id.listView_test);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {
				TextView txt = (TextView) view;
				String message = txt.getText().toString();
				startOptionsActivity(message);

			}

		});

	}

	private void registerExpandListClick() {
		exp = (ExpandableListView) findViewById(R.id.expandableListView_test);
		exp.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {

				String langclicked = CustomAdapter.childList[groupPosition][childPosition];
				startOptionsActivity(langclicked);

				return false;
			}
		});
	}

	private void startOptionsActivity(String language) {

		int itemIndex = 0;
		for (int i = 0; i < languageArray.size(); i++) {
			if (languageArray.get(i).getname().equals(language)) {

				itemIndex = i;

			}
		}

		Language lang = languageArray.get(itemIndex);

		Intent optionsIntent = new Intent(HomeActivity.this,
				LanguageOptions.class);
		optionsIntent.putExtra(getString(R.string.extra_object), lang);

		startActivity(optionsIntent);

	}
}
