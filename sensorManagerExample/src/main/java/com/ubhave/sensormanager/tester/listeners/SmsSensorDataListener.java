package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class SmsSensorDataListener extends AbstractSensorDataListener
{
	private static SmsSensorDataListener instance;

	private SmsSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static SmsSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new SmsSensorDataListener(SensorUtils.SENSOR_TYPE_SMS);
		}
		return instance;
	}
}
