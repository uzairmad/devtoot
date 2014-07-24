package com.ummkjd.devtoot;

import java.util.Comparator;

import android.os.Parcel;
import android.os.Parcelable;
/*
 * Language is a custom holder class that contains String data pertaining to a 
 * particular Language. It contains methods to pass the object of this class and 
 * manipulate its data
 */
public class Language implements Parcelable {

	String name;
	String langURL;
	String programURL;
	String history;
	String description;

	Language(String name) {

		this.name = name;
		
	}

	public void setLangURL(String langURL) {
		this.langURL = langURL;
	}

	public void setProgramURL(String programURL) {
		this.programURL = programURL;
	}

	public void setHistory(String history) {

		this.history = history;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public String getname() {

		return this.name;
	}

	public String getHistory() {

		return this.history;
	}

	public String getLangURL() {

		return this.langURL;
	}

	public String getProgramURL() {

		return this.programURL;
	}

	public String getDescription() {

		return this.description;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// write your object's data to the passed-in Parcel in order they were added
		dest.writeString(name);
		dest.writeString(description);
		dest.writeString(history);
		dest.writeString(langURL);
		dest.writeString(programURL);
		
		
	}

	// this is used to regenerate your object. All Parcelables must have a
	// CREATOR that implements these two methods
	public static final Parcelable.Creator<Language> CREATOR = new Parcelable.Creator<Language>() {
		public Language createFromParcel(Parcel in) {
			return new Language(in);
		}

		public Language[] newArray(int size) {
			return new Language[size];
		}
	};

	// parcel part - needs to be in order that fields were set
	public Language(Parcel in) {

		this.name = in.readString();	
		this.description = in.readString();
		this.history = in.readString();
		this.langURL = in.readString();
		this.programURL = in.readString();
		
	}
	
	//define inner class to compare Authors by name
    static class NameComparator implements Comparator<Language> {
   @Override
   public int compare(Language a, Language b) {
       return a.name.compareToIgnoreCase(b.name);
   }
    }
}
