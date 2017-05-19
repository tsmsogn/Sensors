package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class PressureSensorDataListener extends AbstractSensorDataListener
{
	private static PressureSensorDataListener instance;

	private PressureSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static PressureSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new PressureSensorDataListener(SensorUtils.SENSOR_TYPE_PRESSURE);
		}
		return instance;
	}
}
