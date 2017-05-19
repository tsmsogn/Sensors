package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class WifiSensorDataListener extends AbstractSensorDataListener
{
	private static WifiSensorDataListener instance;

	private WifiSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static WifiSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new WifiSensorDataListener(SensorUtils.SENSOR_TYPE_WIFI);
		}
		return instance;
	}
}
