package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class LightSensorDataListener extends AbstractSensorDataListener
{
	private static LightSensorDataListener instance;

	private LightSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static LightSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new LightSensorDataListener(SensorUtils.SENSOR_TYPE_LIGHT);
		}
		return instance;
	}
}
