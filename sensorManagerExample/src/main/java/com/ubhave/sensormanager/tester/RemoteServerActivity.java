package com.ubhave.sensormanager.tester;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.support.v7.widget.Toolbar;

import com.ubhave.sensormanager.tester.loggers.RemoteServerDetails;

public class RemoteServerActivity extends PreferenceActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_remote_server);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle(R.string.title_activity_remote_server);

		// Create root preference screen
		PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(this);
		setPreferenceScreen(screen);

		CheckBoxPreference postFile = new CheckBoxPreference(this);
		postFile.setKey(RemoteServerDetails.POST_FILE);
		postFile.setDefaultValue(RemoteServerDetails.DEFAULT_VALUE_POST_FILE);
		postFile.setTitle("Post data to remote server");
		screen.addPreference(postFile);

		EditTextPreference filePostURL = new EditTextPreference(this);
		filePostURL.setKey(RemoteServerDetails.FILE_POST_URL);
		filePostURL.setDefaultValue(RemoteServerDetails.DEFAULT_VALUE_FILE_POST_URL);
		filePostURL.setTitle("URL");
		filePostURL.setSummary("File post URL");
		screen.addPreference(filePostURL);

		EditTextPreference fileKey = new EditTextPreference(this);
		fileKey.setKey(RemoteServerDetails.FILE_KEY);
		fileKey.setDefaultValue(RemoteServerDetails.DEFAULT_VALUE_FILE_KEY);
		fileKey.setTitle("Key");
		fileKey.setSummary("Key of parameter which includes file data.");
		screen.addPreference(fileKey);

		EditTextPreference responseOnSuccess = new EditTextPreference(this);
		responseOnSuccess.setKey(RemoteServerDetails.RESPONSE_ON_SUCCESS);
		responseOnSuccess.setDefaultValue(RemoteServerDetails.DEFAULT_VALUE_RESPONSE_ON_SUCCESS);
		responseOnSuccess.setTitle("Response data on success");
		responseOnSuccess.setSummary("Whether or not the post has been completed successfully.");
		screen.addPreference(responseOnSuccess);
	}
}
