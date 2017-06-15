package com.ubhave.sensormanager.tester.config;

import com.ubhave.sensormanager.config.AbstractConfig;
import com.ubhave.sensormanager.config.SensorConfig;

public class AppSensorConfig extends AbstractConfig implements Cloneable
{
	private static final boolean DEFAULT_START_SENSING_ON_BOOT = false;
	public static final String START_SENSING_ON_BOOT_PARAMETER = "START_SENSING_ON_BOOT_PARAMETER";

	public static SensorConfig getDefaultConfig(int sensorType)
	{
		SensorConfig sensorConfig = new SensorConfig();
		sensorConfig.setParameter(START_SENSING_ON_BOOT_PARAMETER, DEFAULT_START_SENSING_ON_BOOT);
		return sensorConfig;
	}
}
