/* **************************************************
 Copyright (c) 2012, University of Cambridge
 Neal Lathia, neal.lathia@cl.cam.ac.uk

This demo application was developed as part of the EPSRC Ubhave (Ubiquitous and
Social Computing for Positive Behaviour Change) Project. For more
information, please visit http://www.emotionsense.org

Permission to use, copy, modify, and/or distribute this software for any
purpose with or without fee is hereby granted, provided that the above
copyright notice and this permission notice appear in all copies.

THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 ************************************************** */

package com.ubhave.sensormanager.tester.pull;

import com.ubhave.sensormanager.ESException;
import com.ubhave.sensormanager.ESSensorManager;
import com.ubhave.sensormanager.ESSensorManagerInterface;
import com.ubhave.sensormanager.config.pull.BluetoothConfig;
import com.ubhave.sensormanager.config.pull.ContentReaderConfig;
import com.ubhave.sensormanager.config.pull.LocationConfig;
import com.ubhave.sensormanager.config.pull.MicrophoneConfig;
import com.ubhave.sensormanager.config.pull.MotionSensorConfig;
import com.ubhave.sensormanager.config.pull.PullSensorConfig;
import com.ubhave.sensormanager.config.push.PassiveLocationConfig;
import com.ubhave.sensormanager.sensors.SensorUtils;
import com.ubhave.sensormanager.tester.ApplicationContext;

public class ExampleSensorConfigUpdater
{
	private final int sensorType;
	private ESSensorManagerInterface sensorManager;

	public ExampleSensorConfigUpdater(int sensor)
	{
		this.sensorType = sensor;
		try
		{
			sensorManager = ESSensorManager.getSensorManager(ApplicationContext.getContext());
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
	}

	public String getSensorName()
	{
		try
		{
			return SensorUtils.getSensorName(sensorType);
		}
		catch (ESException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public void setSensorSampleWindow(long millis)
	{
		try
		{
			switch (sensorType)
			{
			case SensorUtils.SENSOR_TYPE_BLUETOOTH:
			case SensorUtils.SENSOR_TYPE_WIFI:
				sensorManager.setSensorConfig(sensorType, PullSensorConfig.SENSE_WINDOW_LENGTH_PER_CYCLE_MILLIS, (int) millis);
				break;
			default:
				sensorManager.setSensorConfig(sensorType, PullSensorConfig.SENSE_WINDOW_LENGTH_MILLIS, millis);
				break;
			}
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
	}

	public long getSensorSampleWindow()
	{
		try
		{
			switch (sensorType)
			{
			case SensorUtils.SENSOR_TYPE_BLUETOOTH:
			case SensorUtils.SENSOR_TYPE_WIFI:
				return (int) sensorManager.getSensorConfigValue(sensorType, PullSensorConfig.SENSE_WINDOW_LENGTH_PER_CYCLE_MILLIS);
			default:
				return (Long) sensorManager.getSensorConfigValue(sensorType, PullSensorConfig.SENSE_WINDOW_LENGTH_MILLIS);
			}
		}
		catch (ESException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	public void setSensorSleepWindow(long millis)
	{
		try
		{
			sensorManager.setSensorConfig(sensorType, PullSensorConfig.POST_SENSE_SLEEP_LENGTH_MILLIS, millis);
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
	}

	public long getSensorSleepWindow()
	{
		try
		{
			return (Long) sensorManager.getSensorConfigValue(sensorType, PullSensorConfig.POST_SENSE_SLEEP_LENGTH_MILLIS);
		}
		catch (ESException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	public void setSamplingDelay(int rate)
	{
		try
		{
			sensorManager.setSensorConfig(sensorType, MotionSensorConfig.SAMPLING_DELAY, rate);
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
	}

	public int getSamplingDelay()
	{
		try
		{
			return (int) sensorManager.getSensorConfigValue(sensorType, MotionSensorConfig.SAMPLING_DELAY);
		}
		catch (ESException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	public void setLowPassAlpha(Float alpha)
	{
		try
		{
			sensorManager.setSensorConfig(sensorType, MotionSensorConfig.LOW_PASS_ALPHA, alpha);
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
	}

	public float getLowPassAlpha()
	{
		try
		{
			return (Float) sensorManager.getSensorConfigValue(sensorType, MotionSensorConfig.LOW_PASS_ALPHA);
		}
		catch (ESException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	public void setMovementThreshold(int threshold)
	{
		try
		{
			sensorManager.setSensorConfig(sensorType, MotionSensorConfig.MOTION_THRESHOLD, threshold);
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
	}

	public int getMovementThreshold()
	{
		try
		{
			int movementThreshold = (int) sensorManager.getSensorConfigValue(sensorType, MotionSensorConfig.MOTION_THRESHOLD);
			return movementThreshold;
		}
		catch (ESException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	public void enableSensor(boolean enable)
	{
		try
		{
			sensorManager.setSensorConfig(sensorType, BluetoothConfig.FORCE_ENABLE_SENSOR, enable);
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
	}

	public Boolean isSensorEnabled()
	{
		try
		{
			return (Boolean) sensorManager.getSensorConfigValue(sensorType, BluetoothConfig.FORCE_ENABLE_SENSOR);
		}
		catch (ESException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public void setSampleCycles(int cycles)
	{
		try
		{
			sensorManager.setSensorConfig(sensorType, PullSensorConfig.NUMBER_OF_SENSE_CYCLES, cycles);
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
	}

	public int getSampleCycles()
	{
		try
		{
			return (int) sensorManager.getSensorConfigValue(sensorType, PullSensorConfig.NUMBER_OF_SENSE_CYCLES);
		}
		catch (ESException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	public void setLocationAccuracy(String locationAccuracy)
	{
		try
		{
			sensorManager.setSensorConfig(sensorType, LocationConfig.ACCURACY_TYPE, locationAccuracy);
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
	}

	public String getLocationAccuracy()
	{
		try
		{
			return (String) sensorManager.getSensorConfigValue(sensorType, LocationConfig.ACCURACY_TYPE);
		}
		catch (ESException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public void setSamplingRate(int rate)
	{
		try
		{
			sensorManager.setSensorConfig(sensorType, MicrophoneConfig.SAMPLING_RATE, rate);
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
	}

	public int getSamplingRate()
	{
		try
		{
			return (int) sensorManager.getSensorConfigValue(sensorType, MicrophoneConfig.SAMPLING_RATE);
		}
		catch (ESException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	public void setSoundThreshold(int threshold)
	{
		try
		{
			sensorManager.setSensorConfig(sensorType, MicrophoneConfig.SOUND_THRESHOLD, threshold);
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
	}

	public int getSoundThreshold()
	{
		try
		{
			return (int) sensorManager.getSensorConfigValue(sensorType, MicrophoneConfig.SOUND_THRESHOLD);
		}
		catch (ESException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	public void setTimeLimit(long limit)
	{
		try
		{
			sensorManager.setSensorConfig(sensorType, ContentReaderConfig.TIME_LIMIT_MILLIS, limit);
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
	}

	public long getTimeLimit()
	{
		try
		{
			return (Long) sensorManager.getSensorConfigValue(sensorType, ContentReaderConfig.TIME_LIMIT_MILLIS);
		}
		catch (ESException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	public void setRowLimit(int limit)
	{
		try
		{
			sensorManager.setSensorConfig(sensorType, ContentReaderConfig.ROW_LIMIT, limit);
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
	}

	public int getRowLimit()
	{
		try
		{
			return (int) sensorManager.getSensorConfigValue(sensorType, ContentReaderConfig.ROW_LIMIT);
		}
		catch (ESException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	public void setTimeThreshold(long millis)
	{
		try
		{
			sensorManager.setSensorConfig(sensorType, PassiveLocationConfig.MIN_TIME, millis);
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
	}

	public long getTimeThreshold()
	{
		try
		{
			return (Long) sensorManager.getSensorConfigValue(sensorType, PassiveLocationConfig.MIN_TIME);
		}
		catch (ESException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	public void setDistanceThreshold(float maters)
	{
		try
		{
			sensorManager.setSensorConfig(sensorType, PassiveLocationConfig.MIN_DISTANCE, maters);
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
	}

	public float getDistanceThreshold()
	{
		try
		{
			return (float) sensorManager.getSensorConfigValue(sensorType, PassiveLocationConfig.MIN_DISTANCE);
		}
		catch (ESException e)
		{
			e.printStackTrace();
			return 0;
		}
	}
}
