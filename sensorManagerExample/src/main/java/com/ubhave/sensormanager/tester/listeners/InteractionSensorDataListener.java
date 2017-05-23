package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class InteractionSensorDataListener extends AbstractSensorDataListener
{
	private static InteractionSensorDataListener instance;

	private InteractionSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static InteractionSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new InteractionSensorDataListener(SensorUtils.SENSOR_TYPE_INTERACTION);
		}
		return instance;
	}
}
