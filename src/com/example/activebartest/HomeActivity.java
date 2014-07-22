package com.example.activebartest;

import java.util.ArrayList;
import java.util.Collections;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ListView;
import android.widget.TextView;

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

		//Java
				Language java = new Language("Java");//,"Compiled"
				java.setDescription("This is a discription for Java");
				java.setHistory("This is the history about Java");
				java.setLangURL(getString(R.string.installing_java));
				java.setProgramURL(getString(R.string.java_hello_world));

				//C++
				Language cplusplus = new Language("C++");//,"Compiled"
				cplusplus.setDescription("This is a discription for C++");
				cplusplus.setHistory("This is the history about C++");
				cplusplus.setLangURL(getString(R.string.installing_cpp));
				cplusplus.setProgramURL(getString(R.string.cpp_hello_world));

				//Ruby
				Language ruby = new Language("Ruby"); //,"Interpreted"
				ruby.setDescription("This is a discription for Ruby");
				ruby.setHistory("This is the history about Ruby");
				ruby.setLangURL(getString(R.string.installing_ruby));
				ruby.setProgramURL(getString(R.string.ruby_hello_world));

				//Perl
				Language perl = new Language("Perl");//,"Interpreted"
				perl.setDescription("This is a discription for Perl");
				perl.setHistory("This is the history about Perl");
				perl.setLangURL(getString(R.string.installing_perl));
				perl.setProgramURL(getString(R.string.perl_hello_world));

				//Python
				Language python = new Language("Python");//,"Interpreted"
				python.setDescription("This is a discription for Python");
				python.setHistory("This is the history about Python");
				python.setLangURL(getString(R.string.installing_python));
				python.setProgramURL(getString(R.string.python_hello_world));

				//PHP
				Language php = new Language("PHP");//,"web"
				php.setDescription("This is a discription for PHP");
				php.setHistory("This is the history about PHP");
				php.setLangURL(getString(R.string.installing_php));
				php.setProgramURL(getString(R.string.php_hello_world));

				//C#
				Language csharp = new Language("C#");//,"Compiled"
				csharp.setDescription("This is a discription for C#");
				csharp.setHistory("This is the history about C#");
				csharp.setLangURL(getString(R.string.installing_csharp));
				csharp.setProgramURL(getString(R.string.csharp_hello_world));

				//Objective C
				Language objectivec = new Language("Objective C");//,"Compiled"
				objectivec.setDescription("This is a discription for Objective C");
				objectivec.setHistory("This is the history about Objective C");
				objectivec.setLangURL("www.youtube.com");
				objectivec.setProgramURL("www.youtube.com");

				//JavaScript
				Language javascript = new Language("JavaScript");//,"web"
				javascript.setDescription("This is a discription for JavaScript");
				javascript.setHistory("This is the history about JavaScript");
				javascript.setLangURL(getString(R.string.installing_javascript));
				javascript.setProgramURL(getString(R.string.javascript_hello_world));

				//HTML
				Language html = new Language("HTML");//,"web"
				html.setDescription("This is a discription for HTML");
				html.setHistory("This is the history about HTML");
				html.setLangURL(getString(R.string.installing_html));
				html.setProgramURL(getString(R.string.html_hello_world));

				//Visual Basic
				Language visualbasic = new Language("Visual Basic");//,"Compiled"
				visualbasic.setDescription("This is a discription for Visual Basic");
				visualbasic.setHistory("This is the history about Visual Basic");
				visualbasic.setLangURL("www.youtube.com");
				visualbasic.setProgramURL("www.youtube.com");

				//SQL
				Language sql = new Language("SQL");//"DB"
				sql.setDescription("This is a discription for SQL");
				sql.setHistory("This is the history about SQL");
				sql.setLangURL(getString(R.string.installing_sql));
				sql.setProgramURL(getString(R.string.sql_hello_world));

				//MongoDB
				Language mongodb = new Language("MongoDB");//,"DB"
				mongodb.setDescription("This is a discription for MongoDB");
				mongodb.setHistory("This is the history about MongoDB");
				mongodb.setLangURL("www.youtube.com");
				mongodb.setProgramURL("www.youtube.com");

				//VBScript
				Language vbscript = new Language("VBScript");//,"Interpreted"
				vbscript.setDescription("This is a discription for VBScript");
				vbscript.setHistory("This is the history about VBSCript");
				vbscript.setLangURL("Nothing to install");
				vbscript.setProgramURL(getString(R.string.vbscript_hello_world));
				
				languageArray.add(java); // add objects to Language arrayList
				languageArray.add(perl);
				languageArray.add(cplusplus);
				languageArray.add(vbscript);
				languageArray.add(perl);
				languageArray.add(mongodb);
				languageArray.add(sql);
				languageArray.add(csharp);
				languageArray.add(php);
				languageArray.add(python);
				languageArray.add(html);
				languageArray.add(visualbasic);
				languageArray.add(objectivec);
				languageArray.add(ruby);
				
				//sorry removed your sort, theres already an implementation to do this in one line if Language implements a Comparator
			Collections.sort(languageArray, new Language.NameComparator()); 
			    
			  //add name to ListView ordered list view		
				for (int i=0; i < languageArray.size(); i++) {
					listViewArrayList.add(languageArray.get(i).getname());
				}

	
		

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
