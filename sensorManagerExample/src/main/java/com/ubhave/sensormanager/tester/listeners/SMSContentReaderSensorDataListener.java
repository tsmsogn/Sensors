package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class SMSContentReaderSensorDataListener extends AbstractSensorDataListener
{
	private static SMSContentReaderSensorDataListener instance;

	private SMSContentReaderSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static SMSContentReaderSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new SMSContentReaderSensorDataListener(SensorUtils.SENSOR_TYPE_SMS_CONTENT_READER);
		}
		return instance;
	}
}
