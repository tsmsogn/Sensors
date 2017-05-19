package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class ProximitySensorDataListener extends AbstractSensorDataListener
{
	private static ProximitySensorDataListener instance;

	private ProximitySensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static ProximitySensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new ProximitySensorDataListener(SensorUtils.SENSOR_TYPE_PROXIMITY);
		}
		return instance;
	}
}
