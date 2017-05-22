package com.ubhave.sensormanager.tester;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.ubhave.sensormanager.ESException;
import com.ubhave.sensormanager.sensors.SensorInterface;
import com.ubhave.sensormanager.sensors.SensorUtils;
import com.ubhave.sensormanager.tester.listeners.AbstractSensorDataListener;
import com.ubhave.sensormanager.tester.listeners.SensorDataListenerUtils;

public class StartupReceiver extends BroadcastReceiver
{
	private final static String TAG = "StartupReceiver";

	@Override
	public void onReceive(Context context, Intent intent)
	{
		Log.d(TAG, "onReceive");

		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

		for (SensorInterface s : SensorUtils.getAllSensors(context.getApplicationContext()))
		{
			AbstractSensorDataListener sensorDataListener;
			try
			{
				sensorDataListener = SensorDataListenerUtils.getSensorDataListener(s.getSensorType());

				String sensorName = SensorUtils.getSensorName(s.getSensorType());

				boolean startSensing = prefs.getBoolean("pref_"+sensorName, false);

				if (startSensing && !sensorDataListener.isSubscribed())
				{
					Log.d(TAG, "Start sensing:"+sensorName);
					sensorDataListener.subscribeToSensorData();
				}
			}
			catch (ESException e)
			{
				e.printStackTrace();
			}
		}
	}
}
