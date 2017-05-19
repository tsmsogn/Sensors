package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class CallContentReaderSensorDataListener extends AbstractSensorDataListener
{
	private static CallContentReaderSensorDataListener instance;

	private CallContentReaderSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static CallContentReaderSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new CallContentReaderSensorDataListener(SensorUtils.SENSOR_TYPE_CALL_CONTENT_READER);
		}
		return instance;
	}
}
