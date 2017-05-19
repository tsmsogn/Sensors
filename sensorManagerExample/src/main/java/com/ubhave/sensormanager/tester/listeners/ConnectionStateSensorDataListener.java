package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class ConnectionStateSensorDataListener extends AbstractSensorDataListener
{
	private static ConnectionStateSensorDataListener instance;

	private ConnectionStateSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static ConnectionStateSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new ConnectionStateSensorDataListener(SensorUtils.SENSOR_TYPE_CONNECTION_STATE);
		}
		return instance;
	}
}
