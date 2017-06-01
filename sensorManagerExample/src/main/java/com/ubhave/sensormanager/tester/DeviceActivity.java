package com.ubhave.sensormanager.tester;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.support.v7.widget.Toolbar;

import com.ubhave.sensormanager.tester.datahandler.config.DeviceHandlerConfig;

public class DeviceActivity extends PreferenceActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_remote_server);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle(R.string.title_activity_device);

		// Create root preference screen
		PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(this);
		setPreferenceScreen(screen);

		// user id
		EditTextPreference userId = new EditTextPreference(this);
		userId.setKey(DeviceHandlerConfig.USER_ID);
		userId.setDefaultValue(DeviceHandlerConfig.DEFAULT_VALUE_USER_ID);
		userId.setTitle("User ID");
		screen.addPreference(userId);

		// device id
		EditTextPreference deviceId = new EditTextPreference(this);
		deviceId.setKey(DeviceHandlerConfig.DEVICE_ID);
		deviceId.setDefaultValue(DeviceHandlerConfig.DEFAULT_VALUE_DEVICE_ID);
		deviceId.setTitle("Device ID");
		screen.addPreference(deviceId);
	}
}
