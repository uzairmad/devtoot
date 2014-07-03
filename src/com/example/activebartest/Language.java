package com.example.activebartest;

import android.os.Parcel;
import android.os.Parcelable;

public class Language implements Parcelable {

	String name;
	String langURL;
	String programURL;
	String history;
	String description;

	Language(String name, String langURL, String programURL) {

		this.name = name;
		this.langURL = langURL;
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
		// write your object's data to the passed-in Parcel
		dest.writeString(name);
		dest.writeString(langURL);
		dest.writeString(programURL);
		dest.writeString(history);
		dest.writeString(description);
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

	// parcel part
	public Language(Parcel in) {

		this.name = in.readString();
		this.langURL = in.readString();
		this.programURL = in.readString();
		this.history = in.readString();
		this.description = in.readString();
	}

}
