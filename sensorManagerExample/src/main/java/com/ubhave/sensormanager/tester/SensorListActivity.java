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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.ubhave.sensormanager.ESException;
import com.ubhave.sensormanager.sensors.SensorUtils;
import com.ubhave.sensormanager.tester.pull.ConfigurablePullSensorExampleActivity;
import com.ubhave.sensormanager.tester.pull.NonConfigurablePullSensorExampleActivity;
import com.ubhave.sensormanager.tester.push.PushSensorExampleActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SensorListActivity extends Activity
{
	public final static String SENSOR_LIST_TYPE = "sensorListType";
	public final static int PULL_SENSOR_TYPE = 1;
	public final static int PUSH_SENSOR_TYPE = 2;
	public final static int ENVIRONMENT_SENSOR_TYPE = 3;
	public final static int USER_SENSOR_TYPE = 4;

	private final static int[] pullSensors = new int[] {
			SensorUtils.SENSOR_TYPE_ACCELEROMETER,
			SensorUtils.SENSOR_TYPE_BLUETOOTH,
			SensorUtils.SENSOR_TYPE_LOCATION,
			SensorUtils.SENSOR_TYPE_MICROPHONE,
			SensorUtils.SENSOR_TYPE_WIFI,
			SensorUtils.SENSOR_TYPE_CALL_CONTENT_READER,
			SensorUtils.SENSOR_TYPE_SMS_CONTENT_READER,
			SensorUtils.SENSOR_TYPE_GYROSCOPE
	};

	private final static int[] pushSensors = new int[] {
			SensorUtils.SENSOR_TYPE_BATTERY,
			SensorUtils.SENSOR_TYPE_CONNECTION_STATE,
			SensorUtils.SENSOR_TYPE_PHONE_STATE,
			SensorUtils.SENSOR_TYPE_PROXIMITY,
			SensorUtils.SENSOR_TYPE_SCREEN,
			SensorUtils.SENSOR_TYPE_SMS
	};

	private final static int[] environmentSensors = new int[] {
			SensorUtils.SENSOR_TYPE_AMBIENT_TEMPERATURE,
			SensorUtils.SENSOR_TYPE_LIGHT,
			SensorUtils.SENSOR_TYPE_PRESSURE,
			SensorUtils.SENSOR_TYPE_HUMIDITY
	};

	private final static int[] userSensors = new int[] {
			SensorUtils.SENSOR_TYPE_INTERACTION
	};

	private final static boolean[] isConfigurablePullSensor = new boolean[] {true, true, true, true, true, true, true, true};

	private final static String TITLE = "title";
	private final static String DESCRIPTION = "description";
	private final static String[] from = new String[] {TITLE, DESCRIPTION};
	private final static int[] to = new int[] {R.id.title, R.id.description};

	private int sensorListType;
	private List<HashMap<String, String>> sensorList;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_main);

		Intent intent = getIntent();
		sensorListType = intent.getIntExtra(SENSOR_LIST_TYPE, -1);
		setListContent(sensorListType);

		ListView sensorListView = (ListView) findViewById(R.id.sensorListView);
		sensorListView.setAdapter(new SimpleAdapter(this, sensorList, R.layout.sensorlist_item, from, to));
		sensorListView.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
			{
				switch (sensorListType)
				{
				case PULL_SENSOR_TYPE:
					launchPullSensorActivity(pullSensors[position], isConfigurablePullSensor[position]);
					break;
				case PUSH_SENSOR_TYPE:
					launchPushSensorActivity(pushSensors[position]);
					break;
				case ENVIRONMENT_SENSOR_TYPE:
					launchEnvironmentSensorActivity(environmentSensors[position]);
					break;
				case USER_SENSOR_TYPE:
					launchUserSensorActivity(userSensors[position]);
					break;
				default:
					break;
				}
			}
		});
	}

	private void launchUserSensorActivity(int sensorType)
	{
		Intent intent = new Intent(this, PushSensorExampleActivity.class);
		intent.putExtra(ExampleAbstractActivity.SENSOR_TYPE_ID, sensorType);
		startActivity(intent);
	}

	private void launchEnvironmentSensorActivity(int sensorType)
	{
		Intent intent = new Intent(this, PushSensorExampleActivity.class);
		intent.putExtra(ExampleAbstractActivity.SENSOR_TYPE_ID, sensorType);
		startActivity(intent);
	}

	private void launchPushSensorActivity(int sensorType)
	{
		Intent intent = new Intent(this, PushSensorExampleActivity.class);
		intent.putExtra(ExampleAbstractActivity.SENSOR_TYPE_ID, sensorType);
		startActivity(intent);
	}

	private void launchPullSensorActivity(int sensorType, boolean isConfigurable)
	{
		Intent intent;
		if (isConfigurable)
		{
			intent = new Intent(this, ConfigurablePullSensorExampleActivity.class);
		}
		else
		{
			intent = new Intent(this, NonConfigurablePullSensorExampleActivity.class);
		}
		intent.putExtra(ExampleAbstractActivity.SENSOR_TYPE_ID, sensorType);
		startActivity(intent);
	}

	private void setListContent(int sensorListType)
	{
		sensorList = new ArrayList<HashMap<String, String>>();
		int[] selectedSensors;
		String[] sensorDescriptions;

		switch (sensorListType)
		{
		case PULL_SENSOR_TYPE:
			selectedSensors = pullSensors;
			sensorDescriptions = getResources().getStringArray(R.array.pull_sensors_descriptions);
			break;
		case PUSH_SENSOR_TYPE:
			selectedSensors = pushSensors;
			sensorDescriptions = getResources().getStringArray(R.array.push_sensors_descriptions);
			break;
		case ENVIRONMENT_SENSOR_TYPE:
			selectedSensors = environmentSensors;
			sensorDescriptions = getResources().getStringArray(R.array.environment_sensors_descriptions);
			break;
		case USER_SENSOR_TYPE:
			selectedSensors = userSensors;
			sensorDescriptions = getResources().getStringArray(R.array.user_sensors_descriptions);
			break;
		default:
			selectedSensors = new int[0];
			sensorDescriptions = new String[0];
			break;
		}

		for (int i = 0; i < selectedSensors.length; i++)
		{
			try
			{
				HashMap<String, String> entry = new HashMap<String, String>();
				entry.put(TITLE, SensorUtils.getSensorName(selectedSensors[i]));
				entry.put(DESCRIPTION, sensorDescriptions[i]);
				sensorList.add(entry);
			}
			catch (ESException e)
			{
				e.printStackTrace();
			}
		}
	}
}
