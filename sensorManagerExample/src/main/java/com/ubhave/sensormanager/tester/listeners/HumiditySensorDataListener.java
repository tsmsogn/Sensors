package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class HumiditySensorDataListener extends AbstractSensorDataListener
{
	private static HumiditySensorDataListener instance;

	private HumiditySensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static HumiditySensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new HumiditySensorDataListener(SensorUtils.SENSOR_TYPE_HUMIDITY);
		}
		return instance;
	}
}
