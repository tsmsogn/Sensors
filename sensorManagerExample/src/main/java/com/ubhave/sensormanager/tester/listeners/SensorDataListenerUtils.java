package com.ubhave.sensormanager.tester.listeners;

import com.ubhave.sensormanager.ESException;
import com.ubhave.sensormanager.sensors.SensorUtils;

public class SensorDataListenerUtils
{
	public static AbstractSensorDataListener getSensorDataListener(int id) throws ESException
	{
		switch (id)
		{
		case SensorUtils.SENSOR_TYPE_ACCELEROMETER:
			return AccelerometerSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_BATTERY:
			return BatterySensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_BLUETOOTH:
			return BluetoothSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_LOCATION:
			return LocationSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_MICROPHONE:
			return MicrophoneSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_PHONE_STATE:
			return PhoneStateSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_PROXIMITY:
			return ProximitySensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_SCREEN:
			return ScreenSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_SMS:
			return SmsSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_WIFI:
			return WifiSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_CONNECTION_STATE:
			return ConnectionStateSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_SMS_CONTENT_READER:
			return SMSContentReaderSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_CALL_CONTENT_READER:
			return CallContentReaderSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_GYROSCOPE:
			return GyroscopeSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_LIGHT:
			return LightSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_PHONE_RADIO:
			return PhoneRadioSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_CONNECTION_STRENGTH:
			return ConnectionStrengthSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_PASSIVE_LOCATION:
			return PassiveLocationSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_AMBIENT_TEMPERATURE:
			return AmbientTemperatureSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_PRESSURE:
			return PressureSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_HUMIDITY:
			return HumiditySensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_MAGNETIC_FIELD:
			return MagneticFieldSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_STEP_COUNTER:
			return StepCounterSensorDataListener.getInstance();
		case SensorUtils.SENSOR_TYPE_INTERACTION:
			return InteractionSensorDataListener.getInstance();
		default:
			throw new ESException(ESException.UNKNOWN_SENSOR_TYPE, "Unknown sensor id: "+id);
		}
	}
}
