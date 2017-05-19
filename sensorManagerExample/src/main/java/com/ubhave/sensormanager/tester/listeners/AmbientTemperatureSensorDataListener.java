package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class AmbientTemperatureSensorDataListener extends AbstractSensorDataListener
{
	private static AmbientTemperatureSensorDataListener instance;

	private AmbientTemperatureSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static AmbientTemperatureSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new AmbientTemperatureSensorDataListener(SensorUtils.SENSOR_TYPE_AMBIENT_TEMPERATURE);
		}
		return instance;
	}
}
