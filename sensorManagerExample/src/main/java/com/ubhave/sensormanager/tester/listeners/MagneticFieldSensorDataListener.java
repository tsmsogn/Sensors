package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class MagneticFieldSensorDataListener extends AbstractSensorDataListener
{
	private static MagneticFieldSensorDataListener instance;

	private MagneticFieldSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static MagneticFieldSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new MagneticFieldSensorDataListener(SensorUtils.SENSOR_TYPE_MAGNETIC_FIELD);
		}
		return instance;
	}
}
