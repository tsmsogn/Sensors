package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class PassiveLocationSensorDataListener extends AbstractSensorDataListener
{
	private static PassiveLocationSensorDataListener instance;

	private PassiveLocationSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static PassiveLocationSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new PassiveLocationSensorDataListener(SensorUtils.SENSOR_TYPE_PASSIVE_LOCATION);
		}
		return instance;
	}
}
