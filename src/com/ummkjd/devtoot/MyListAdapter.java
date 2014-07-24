package com.ummkjd.devtoot;

import java.util.ArrayList;


import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<String> {

	Context context;

	public MyListAdapter(Context context, ArrayList<String> options) {
		super(context, R.layout.option_list_item, options);

		this.context = context;
	}
	
	 @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
		        View view = super.getView(position, convertView, parent);
		    	TextView tv =(TextView) view.findViewById(R.id.rowTextView);
	        if (position == 0) {
	            // set your color
	        	//make description item appear different due to more text	        
	        	tv.setBackgroundColor(Color.parseColor("#3059AC")); //cobaltish
	    		tv.setTextColor(Color.parseColor("#D8D8DB")); //light grey
	    		tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
	        	
	        }else{
    			tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
    		
    		}

	        return view;
	    }
	
}
