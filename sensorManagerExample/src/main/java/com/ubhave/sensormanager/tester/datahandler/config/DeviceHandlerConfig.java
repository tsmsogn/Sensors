package com.ubhave.sensormanager.tester.datahandler.config;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.ubhave.sensormanager.tester.ApplicationContext;

public class DeviceHandlerConfig
{
	public static final String USER_ID = "user_id";
	public static final String DEVICE_ID = "device_id";

	public static final String DEFAULT_VALUE_USER_ID = "test-user-id";
	public static final String DEFAULT_VALUE_DEVICE_ID = "test-device-id";

	public static String getUserId()
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ApplicationContext.getContext());
		return preferences.getString(USER_ID, DEFAULT_VALUE_USER_ID);
	}

	public static String getDeviceId()
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ApplicationContext.getContext());
		return preferences.getString(DEVICE_ID, DEFAULT_VALUE_DEVICE_ID);
	}
}
