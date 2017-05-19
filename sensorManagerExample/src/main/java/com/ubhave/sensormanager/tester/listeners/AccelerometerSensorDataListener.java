package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class AccelerometerSensorDataListener extends AbstractSensorDataListener
{
	private static AccelerometerSensorDataListener instance;

	private AccelerometerSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static AccelerometerSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new AccelerometerSensorDataListener(SensorUtils.SENSOR_TYPE_ACCELEROMETER);
		}
		return instance;
	}
}
