package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class PhoneStateSensorDataListener extends AbstractSensorDataListener
{
	private static PhoneStateSensorDataListener instance;

	private PhoneStateSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static PhoneStateSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new PhoneStateSensorDataListener(SensorUtils.SENSOR_TYPE_PHONE_STATE);
		}
		return instance;
	}
}
