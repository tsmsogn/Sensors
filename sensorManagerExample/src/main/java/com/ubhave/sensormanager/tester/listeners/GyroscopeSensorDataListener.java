package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class GyroscopeSensorDataListener extends AbstractSensorDataListener
{
	private static GyroscopeSensorDataListener instance;

	private GyroscopeSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static GyroscopeSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new GyroscopeSensorDataListener(SensorUtils.SENSOR_TYPE_GYROSCOPE);
		}
		return instance;
	}
}
