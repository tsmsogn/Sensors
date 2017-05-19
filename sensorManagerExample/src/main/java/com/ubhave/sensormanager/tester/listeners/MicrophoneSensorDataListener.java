package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class MicrophoneSensorDataListener extends AbstractSensorDataListener
{
	private static MicrophoneSensorDataListener instance;

	private MicrophoneSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static MicrophoneSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new MicrophoneSensorDataListener(SensorUtils.SENSOR_TYPE_MICROPHONE);
		}
		return instance;
	}
}
