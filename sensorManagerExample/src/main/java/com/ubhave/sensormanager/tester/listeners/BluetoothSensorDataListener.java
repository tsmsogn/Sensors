package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class BluetoothSensorDataListener extends AbstractSensorDataListener
{
	private static BluetoothSensorDataListener instance;

	private BluetoothSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static BluetoothSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new BluetoothSensorDataListener(SensorUtils.SENSOR_TYPE_BLUETOOTH);
		}
		return instance;
	}
}
