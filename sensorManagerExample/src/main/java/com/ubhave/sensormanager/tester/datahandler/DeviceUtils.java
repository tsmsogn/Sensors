package com.ubhave.sensormanager.tester.datahandler;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.ubhave.sensormanager.ESException;
import com.ubhave.sensormanager.tester.ApplicationContext;
import com.ubhave.sensormanager.tester.datahandler.config.SensorConfigPreferenceKeyEnum;

public class DeviceUtils
{
	public final static String SENSOR_START_SAMPLING_ON_BOOT_ACCELEROMETER = "StartSamplingOnBootAccelerometer";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_BATTERY = "StartSamplingOnBootBattery";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_BLUETOOTH = "StartSamplingOnBootBluetooth";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_LOCATION = "StartSamplingOnBootLocation";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_MICROPHONE = "StartSamplingOnBootMicrophone";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_PHONE_STATE = "StartSamplingOnBootPhoneState";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_PROXIMITY = "StartSamplingOnBootProximity";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_SCREEN = "StartSamplingOnBootScreen";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_SMS = "StartSamplingOnBootSMS";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_WIFI = "StartSamplingOnBootWiFi";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_CONNECTION_STATE = "StartSamplingOnBootConnectionState";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_CONNECTION_STRENGTH = "StartSamplingOnBootConnectionStrength";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_SMS_CONTENT_READER = "StartSamplingOnBootSMSContentReader";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_CALL_CONTENT_READER = "StartSamplingOnBootCallContentReader";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_GYROSCOPE = "StartSamplingOnBootGyroscope";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_LIGHT = "StartSamplingOnBootLight";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_PHONE_RADIO = "StartSamplingOnBootPhoneRadio";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_PASSIVE_LOCATION = "StartSamplingOnBootPassiveLocation";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_AMBIENT_TEMPERATURE = "StartSamplingOnBootAmbientTemperature";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_PRESSURE = "StartSamplingOnBootPressure";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_HUMIDITY = "StartSamplingOnBootHumidity";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_MAGNETIC_FIELD = "StartSamplingOnBootMagneticField";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_STEP_COUNTER = "StartSamplingOnBootStepCounter";
	public final static String SENSOR_START_SAMPLING_ON_BOOT_INTERACTION = "StartSamplingOnBootInteraction";

	static public SensorConfigPreferenceKeyEnum getSensorConfig(int sensorType) throws ESException
	{
		for (SensorConfigPreferenceKeyEnum s : SensorConfigPreferenceKeyEnum.values())
		{
			if (s.getType() == sensorType)
			{
				return s;
			}
		}
		throw new ESException(ESException.UNKNOWN_SENSOR_TYPE, "Unknown sensor type "+sensorType);
	}

	public static boolean startSamplingOnBoot(int sensorType) throws ESException
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ApplicationContext.getContext());
		String key = getSensorConfig(sensorType).getStarSamplingOnBootPreferenceKey();
		return preferences.getBoolean(key, false);
	}
}
