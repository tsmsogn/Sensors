package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class ConnectionStrengthSensorDataListener extends AbstractSensorDataListener
{
	private static ConnectionStrengthSensorDataListener instance;

	private ConnectionStrengthSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static ConnectionStrengthSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new ConnectionStrengthSensorDataListener(SensorUtils.SENSOR_TYPE_CONNECTION_STRENGTH);
		}
		return instance;
	}
}
