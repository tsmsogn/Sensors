package com.ubhave.sensormanager.tester.pull;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.ubhave.sensormanager.ESSensorManagerInterface;
import com.ubhave.sensormanager.config.pull.BluetoothConfig;
import com.ubhave.sensormanager.config.pull.ContentReaderConfig;
import com.ubhave.sensormanager.config.pull.LocationConfig;
import com.ubhave.sensormanager.config.pull.MicrophoneConfig;
import com.ubhave.sensormanager.config.pull.MotionSensorConfig;
import com.ubhave.sensormanager.config.pull.PullSensorConfig;
import com.ubhave.sensormanager.config.push.PassiveLocationConfig;
import com.ubhave.sensormanager.sensors.SensorUtils;

public class SensorConfigUpdater extends ExampleSensorConfigUpdater
{
	private final Context context;
	private final SharedPreferences preferences;
	private final SharedPreferences.Editor editor;
	private int sensorType;
	private ESSensorManagerInterface sensorManager;

	public SensorConfigUpdater(Context context, int sensor)
	{
		super(sensor);
		this.context = context;
		this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
		this.editor = preferences.edit();
	}

	private String createPreferenceKey(String parameter)
	{
		return parameter+"_"+getSensorName();
	}

	@Override
	public void setSensorSampleWindow(long millis)
	{
		super.setSensorSampleWindow(millis);

		String parameter;
		switch (sensorType)
		{
		case SensorUtils.SENSOR_TYPE_BLUETOOTH:
		case SensorUtils.SENSOR_TYPE_WIFI:
			parameter = PullSensorConfig.SENSE_WINDOW_LENGTH_PER_CYCLE_MILLIS;
			editor.putInt(createPreferenceKey(parameter), (int) super.getSensorSampleWindow());
			editor.commit();
			break;
		default:
			parameter = PullSensorConfig.SENSE_WINDOW_LENGTH_MILLIS;
			editor.putLong(createPreferenceKey(parameter), super.getSensorSampleWindow());
			editor.commit();
			break;
		}
	}

	@Override
	public long getSensorSampleWindow()
	{
		String parameter;
		switch (sensorType)
		{
		case SensorUtils.SENSOR_TYPE_BLUETOOTH:
		case SensorUtils.SENSOR_TYPE_WIFI:
			parameter = PullSensorConfig.SENSE_WINDOW_LENGTH_PER_CYCLE_MILLIS;
			return preferences.getInt(createPreferenceKey(parameter), (int) super.getSensorSampleWindow());
		default:
			parameter = PullSensorConfig.SENSE_WINDOW_LENGTH_MILLIS;
			return preferences.getLong(createPreferenceKey(parameter), super.getSensorSampleWindow());
		}
	}

	@Override
	public void setSensorSleepWindow(long millis)
	{
		super.setSensorSleepWindow(millis);

		String parameter = PullSensorConfig.POST_SENSE_SLEEP_LENGTH_MILLIS;
		editor.putLong(createPreferenceKey(parameter), super.getSensorSleepWindow());
		editor.commit();
	}

	@Override
	public long getSensorSleepWindow()
	{
		String parameter = PullSensorConfig.POST_SENSE_SLEEP_LENGTH_MILLIS;
		return preferences.getLong(createPreferenceKey(parameter), super.getSensorSleepWindow());
	}

	@Override
	public void setSamplingDelay(int rate)
	{
		super.setSamplingDelay(rate);

		String parameter = MotionSensorConfig.SAMPLING_DELAY;
		editor.putInt(createPreferenceKey(parameter), super.getSamplingDelay());
		editor.commit();
	}

	@Override
	public int getSamplingDelay()
	{
		String parameter = MotionSensorConfig.SAMPLING_DELAY;
		return preferences.getInt(createPreferenceKey(parameter), super.getSamplingDelay());
	}

	@Override
	public void setLowPassAlpha(Float alpha)
	{
		super.setLowPassAlpha(alpha);

		String parameter = MotionSensorConfig.LOW_PASS_ALPHA;
		editor.putFloat(createPreferenceKey(parameter), super.getLowPassAlpha());
		editor.commit();
	}

	@Override
	public float getLowPassAlpha()
	{
		String parameter = MotionSensorConfig.LOW_PASS_ALPHA;
		return preferences.getFloat(createPreferenceKey(parameter), super.getLowPassAlpha());
	}

	@Override
	public void setMovementThreshold(int threshold)
	{
		super.setMovementThreshold(threshold);

		String parameter = MotionSensorConfig.MOTION_THRESHOLD;
		editor.putInt(createPreferenceKey(parameter), super.getMovementThreshold());
		editor.commit();
	}

	@Override
	public int getMovementThreshold()
	{
		String parameter = MotionSensorConfig.MOTION_THRESHOLD;
		return preferences.getInt(createPreferenceKey(parameter), super.getMovementThreshold());
	}

	@Override
	public void enableSensor(boolean enable)
	{
		super.enableSensor(enable);

		String parameter = BluetoothConfig.FORCE_ENABLE_SENSOR;
		editor.putBoolean(createPreferenceKey(parameter), super.isSensorEnabled());
		editor.commit();
	}

	@Override
	public Boolean isSensorEnabled()
	{
		String parameter = BluetoothConfig.FORCE_ENABLE_SENSOR;
		return preferences.getBoolean(createPreferenceKey(parameter), super.isSensorEnabled());
	}

	@Override
	public void setSampleCycles(int cycles)
	{
		super.setSampleCycles(cycles);

		String parameter = PullSensorConfig.NUMBER_OF_SENSE_CYCLES;
		editor.putInt(createPreferenceKey(parameter), super.getSampleCycles());
		editor.commit();
	}

	@Override
	public int getSampleCycles()
	{
		String parameter = PullSensorConfig.NUMBER_OF_SENSE_CYCLES;
		return preferences.getInt(createPreferenceKey(parameter), super.getSampleCycles());
	}

	@Override
	public void setLocationAccuracy(String locationAccuracy)
	{
		super.setLocationAccuracy(locationAccuracy);

		String parameter = LocationConfig.ACCURACY_TYPE;
		editor.putString(createPreferenceKey(parameter), super.getLocationAccuracy());
		editor.commit();
	}

	@Override
	public String getLocationAccuracy()
	{
		String parameter = LocationConfig.ACCURACY_TYPE;
		return preferences.getString(createPreferenceKey(parameter), super.getLocationAccuracy());
	}

	@Override
	public void setSamplingRate(int rate)
	{
		super.setSamplingRate(rate);

		String parameter = MicrophoneConfig.SAMPLING_RATE;
		editor.putInt(createPreferenceKey(parameter), super.getSamplingRate());
		editor.commit();
	}

	@Override
	public int getSamplingRate()
	{
		String parameter = MicrophoneConfig.SAMPLING_RATE;
		return preferences.getInt(createPreferenceKey(parameter), super.getSamplingRate());
	}

	@Override
	public void setSoundThreshold(int threshold)
	{
		super.setSoundThreshold(threshold);

		String parameter = MicrophoneConfig.SOUND_THRESHOLD;
		editor.putInt(createPreferenceKey(parameter), super.getSoundThreshold());
		editor.commit();
	}

	@Override
	public int getSoundThreshold()
	{
		String parameter = MicrophoneConfig.SOUND_THRESHOLD;
		return preferences.getInt(createPreferenceKey(parameter), super.getSoundThreshold());
	}

	@Override
	public void setTimeLimit(long limit)
	{
		super.setTimeLimit(limit);

		String parameter = ContentReaderConfig.TIME_LIMIT_MILLIS;
		editor.putLong(createPreferenceKey(parameter), super.getTimeLimit());
		editor.commit();
	}

	@Override
	public long getTimeLimit()
	{
		String parameter = ContentReaderConfig.TIME_LIMIT_MILLIS;
		return preferences.getLong(createPreferenceKey(parameter), super.getTimeLimit());
	}

	@Override
	public void setRowLimit(int limit)
	{
		super.setRowLimit(limit);

		String parameter = ContentReaderConfig.ROW_LIMIT;
		editor.putInt(createPreferenceKey(parameter), super.getRowLimit());
		editor.commit();
	}

	@Override
	public int getRowLimit()
	{
		String parameter = ContentReaderConfig.ROW_LIMIT;
		return preferences.getInt(createPreferenceKey(parameter), super.getRowLimit());
	}

	@Override
	public void setTimeThreshold(int millis)
	{
		super.setTimeThreshold(millis);

		String parameter = PassiveLocationConfig.MIN_TIME;
		editor.putLong(createPreferenceKey(parameter), super.getTimeThreshold());
		editor.commit();
	}

	@Override
	public long getTimeThreshold()
	{
		String parameter = PassiveLocationConfig.MIN_TIME;
		return preferences.getLong(createPreferenceKey(parameter), super.getTimeThreshold());
	}

	@Override
	public void setDistanceThreshold(float maters)
	{
		super.setDistanceThreshold(maters);

		String parameter = PassiveLocationConfig.MIN_DISTANCE;
		editor.putFloat(createPreferenceKey(parameter), super.getDistanceThreshold());
		editor.commit();
	}

	@Override
	public float getDistanceThreshold()
	{
		String parameter = PassiveLocationConfig.MIN_DISTANCE;
		return preferences.getFloat(createPreferenceKey(parameter), super.getDistanceThreshold());
	}
}
