package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class BatterySensorDataListener extends AbstractSensorDataListener
{
	private static BatterySensorDataListener instance;

	private BatterySensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static BatterySensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new BatterySensorDataListener(SensorUtils.SENSOR_TYPE_BATTERY);
		}
		return instance;
	}
}
