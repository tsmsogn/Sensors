package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.sensors.SensorUtils;

public class StepCounterSensorDataListener extends AbstractSensorDataListener
{
	private static StepCounterSensorDataListener instance;

	private StepCounterSensorDataListener(int sensorType)
	{
		super(sensorType);
	}

	public static StepCounterSensorDataListener getInstance()
	{
		if (instance == null)
		{
			instance = new StepCounterSensorDataListener(SensorUtils.SENSOR_TYPE_STEP_COUNTER);
		}
		return instance;
	}
}
