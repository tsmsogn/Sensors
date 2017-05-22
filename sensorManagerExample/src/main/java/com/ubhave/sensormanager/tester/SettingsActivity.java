package com.ubhave.sensormanager.tester;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;

import com.ubhave.sensormanager.sensors.SensorEnum;

public class SettingsActivity extends PreferenceActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		// Create root preference screen
		PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(this);
		setPreferenceScreen(screen);

		// Create preference category
		PreferenceCategory category = new PreferenceCategory(this);
		category.setTitle("Start sensing on boot");
		screen.addPreference(category);

		// Create preferences
		for (SensorEnum s : SensorEnum.values())
		{
			CheckBoxPreference pref = new CheckBoxPreference(this);
			pref.setKey("pref_"+s.getName());
			pref.setTitle(s.getName());
			category.addPreference(pref);
		}
	}
}
