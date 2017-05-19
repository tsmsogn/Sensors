package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class ScreenSensorDataListener extends AbstractSensorDataListener
{
	private static ScreenSensorDataListener instance;

	private ScreenSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static ScreenSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new ScreenSensorDataListener(SensorUtils.SENSOR_TYPE_SCREEN);
		}
		return instance;
	}
}
