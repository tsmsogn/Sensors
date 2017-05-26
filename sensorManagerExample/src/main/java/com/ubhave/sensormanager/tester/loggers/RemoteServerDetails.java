package com.ubhave.sensormanager.tester.loggers;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.ubhave.sensormanager.tester.ApplicationContext;

public class RemoteServerDetails
{
	public static final String POST_FILE = "post_file";
	public static final String FILE_POST_URL = "file_post_url";
	public static final String FILE_KEY = "FILE_KEY";
	public static final String RESPONSE_ON_SUCCESS = "response_on_success";

	public static boolean postFile()
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ApplicationContext.getContext());
		return preferences.getBoolean(POST_FILE, false);
	}

	public static String getFilePostUrl()
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ApplicationContext.getContext());
		return preferences.getString(FILE_POST_URL, "");
	}

	public static String getFileKey()
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ApplicationContext.getContext());
		return preferences.getString(FILE_KEY, "file");
	}

	public static String getResponseOnSuccess()
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ApplicationContext.getContext());
		return preferences.getString(RESPONSE_ON_SUCCESS, "");
	}
}
