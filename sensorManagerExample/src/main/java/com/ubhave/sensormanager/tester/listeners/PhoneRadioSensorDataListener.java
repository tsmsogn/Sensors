package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class PhoneRadioSensorDataListener extends AbstractSensorDataListener
{
	private static PhoneRadioSensorDataListener instance;

	private PhoneRadioSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static PhoneRadioSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new PhoneRadioSensorDataListener(SensorUtils.SENSOR_TYPE_PHONE_RADIO);
		}
		return instance;
	}
}
