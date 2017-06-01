/* **************************************************
 Copyright (c) 2012, University of Cambridge
 Neal Lathia, neal.lathia@cl.cam.ac.uk

This demo application was developed as part of the EPSRC Ubhave (Ubiquitous and
Social Computing for Positive Behaviour Change) Project. For more
information, please visit http://www.emotionsense.org

Permission to use, copy, modify, and/or distribute this software for any
purpose with or without fee is hereby granted, provided that the above
copyright notice and this permission notice appear in all copies.

THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 ************************************************** */

package com.ubhave.sensormanager.tester;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity implements Toolbar.OnMenuItemClickListener
{

	private static final String TAG = "MainActicity";

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Setup toolbar
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle(R.string.title_activity_main);
		toolbar.inflateMenu(R.menu.activity_main);
		toolbar.setOnMenuItemClickListener(this);

		TabHost tabHost = getTabHost();

		TabSpec pullSensors = tabHost.newTabSpec("Pull Sensors");
		pullSensors.setIndicator("Pull Sensors", null);
		Intent pullSensorIntent = new Intent(this, SensorListActivity.class);
		pullSensorIntent.putExtra(SensorListActivity.SENSOR_LIST_TYPE, SensorListActivity.PULL_SENSOR_TYPE);
		pullSensors.setContent(pullSensorIntent);

		tabHost.addTab(pullSensors);

		TabSpec pushSensors = tabHost.newTabSpec("Push Sensors");
		pushSensors.setIndicator("Push Sensors", null);
		Intent pushSensorIntent = new Intent(this, SensorListActivity.class);
		pushSensorIntent.putExtra(SensorListActivity.SENSOR_LIST_TYPE, SensorListActivity.PUSH_SENSOR_TYPE);
		pushSensors.setContent(pushSensorIntent);

		tabHost.addTab(pushSensors);

		TabSpec environmentSensors = tabHost.newTabSpec("Environment Sensors");
		environmentSensors.setIndicator("Environment Sensors", null);
		Intent environmentSensorIntent = new Intent(this, SensorListActivity.class);
		environmentSensorIntent.putExtra(SensorListActivity.SENSOR_LIST_TYPE, SensorListActivity.ENVIRONMENT_SENSOR_TYPE);
		environmentSensors.setContent(environmentSensorIntent);

		tabHost.addTab(environmentSensors);

		TabSpec userSensors = tabHost.newTabSpec("User Sensors");
		userSensors.setIndicator("User Sensors", null);
		Intent userSensorIntent = new Intent(this, SensorListActivity.class);
		userSensorIntent.putExtra(SensorListActivity.SENSOR_LIST_TYPE, SensorListActivity.USER_SENSOR_TYPE);
		userSensors.setContent(userSensorIntent);

		tabHost.addTab(userSensors);
	}

	private void launchSettingsActivity()
	{
		startActivity(new Intent(this, SensorActivity.class));
	}

	@Override
	public boolean onMenuItemClick(MenuItem item)
	{
		switch (item.getItemId())
		{
		case R.id.menu_settings:
			launchSettingsActivity();
			break;
		case R.id.menu_remote_server:
			launchRemoteServerActivity();
			break;
		case R.id.menu_device:
			launchDeviceActivity();
			break;
		}

		return false;
	}

	private void launchDeviceActivity()
	{
		startActivity(new Intent(this, DeviceActivity.class));
	}

	private void launchRemoteServerActivity()
	{
		startActivity(new Intent(this, RemoteServerActivity.class));
	}
}
