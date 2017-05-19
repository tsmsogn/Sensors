package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class LocationSensorDataListener extends AbstractSensorDataListener
{
	private static LocationSensorDataListener instance;

	private LocationSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static LocationSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new LocationSensorDataListener(SensorUtils.SENSOR_TYPE_LOCATION);
		}
		return instance;
	}
}
