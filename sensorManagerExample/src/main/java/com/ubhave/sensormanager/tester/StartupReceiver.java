package com.ubhave.sensormanager.tester;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

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

		for (SensorInterface s : SensorUtils.getAllSensors(context.getApplicationContext()))
		{
			Log.d(TAG, "SensorUtils :"+s.getSensorType());

			try
			{
				AbstractSensorDataListener sensorDataListener = SensorDataListenerUtils.getSensorDataListener(s.getSensorType());
				// TODO
				if (false && !sensorDataListener.isSubscribed())
				{
					sensorDataListener.subscribeToSensorData();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
