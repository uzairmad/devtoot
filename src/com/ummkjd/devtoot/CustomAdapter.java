package com.ummkjd.devtoot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseExpandableListAdapter {

	private Context context;
	String parentList[] = {"Compiled Languages", "Interpreted Languages", "Web Languages",
			"Database Languages"};

	//Insert languages based on type location in specified arrays within multiarray
	static String childList[][] = {	   
             
	{ "C#", "C++", "Java", "Objective C", "Visual Basic" },      //Compiled  
	{ "Perl",  "Python", "Ruby", "VBScript" },   //Interpreted
	{ "HTML", "JavaScript", "PHP"},   //Web  
	{ "MongoDB", "SQL" }     //Database
 
	};
	

	public CustomAdapter(Context context) {

		this.context = context;

	}

	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean arg2, View arg3, ViewGroup arg4) {

		// this represents one child View
		TextView tv = new TextView(context);

		tv.setText(childList[groupPosition][childPosition]);
		tv.setPadding(30, 10, 10, 10);
		tv.setTextSize(20);
		

		return tv;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// return number of items at this specific group element
		return childList[groupPosition].length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public int getGroupCount() {

		// return number of elements in parent array aka group count
		 return parentList.length;
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean arg1, View arg2,
			ViewGroup arg3) {

		TextView tv = new TextView(context);

		tv.setText(parentList[groupPosition]);
		tv.setBackgroundColor(Color.parseColor("#3059AC")); //cobaltish
		tv.setTextColor(Color.parseColor("#D8D8DB")); //light grey
		
		tv.setTextSize(25);
		tv.setPadding(50, 20, 20, 20);
		

		return tv;

	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

}
