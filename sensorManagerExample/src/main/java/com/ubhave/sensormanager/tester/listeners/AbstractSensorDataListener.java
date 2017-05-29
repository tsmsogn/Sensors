package com.ubhave.sensormanager.tester.listeners;

import android.content.Context;

import com.ubhave.dataformatter.DataFormatter;
import com.ubhave.dataformatter.json.JSONFormatter;
import com.ubhave.datahandler.except.DataHandlerException;
import com.ubhave.datahandler.loggertypes.DataStoreCallback;
import com.ubhave.datahandler.transfer.DataUploadCallback;
import com.ubhave.sensormanager.ESException;
import com.ubhave.sensormanager.ESSensorManager;
import com.ubhave.sensormanager.ESSensorManagerInterface;
import com.ubhave.sensormanager.SensorDataListener;
import com.ubhave.sensormanager.config.GlobalConfig;
import com.ubhave.sensormanager.config.pull.LocationConfig;
import com.ubhave.sensormanager.data.SensorData;
import com.ubhave.sensormanager.sensors.SensorUtils;
import com.ubhave.sensormanager.tester.ApplicationContext;
import com.ubhave.sensormanager.tester.loggers.AsyncUnencryptedFiles;

public abstract class AbstractSensorDataListener implements SensorDataListener
{
	private final int sensorType;
	private AsyncUnencryptedFiles logger = null;

	private ESSensorManagerInterface sensorManager;
	protected final JSONFormatter formatter;

	private int sensorSubscriptionId;
	private boolean isSubscribed;

	public AbstractSensorDataListener(int sensorType)
	{
		this.sensorType = sensorType;
		isSubscribed = false;

		Context context = ApplicationContext.getContext();
		formatter = DataFormatter.getJSONFormatter(context, sensorType);

		try
		{
			sensorManager = ESSensorManager.getSensorManager(context);
			sensorManager.setGlobalConfig(GlobalConfig.LOW_BATTERY_THRESHOLD, 25);

			if (sensorType == SensorUtils.SENSOR_TYPE_LOCATION)
			{
				sensorManager.setSensorConfig(SensorUtils.SENSOR_TYPE_LOCATION, LocationConfig.ACCURACY_TYPE, LocationConfig.LOCATION_ACCURACY_FINE);
			}
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}

		try
		{
			logger = AsyncUnencryptedFiles.getInstance();
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
		catch (DataHandlerException e)
		{
			e.printStackTrace();
		}
	}

	public void subscribeToSensorData()
	{
		try
		{
			sensorSubscriptionId = sensorManager.subscribeToSensorData(sensorType, this);
			isSubscribed = true;
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
	}

	public void unsubscribeFromSensorData()
	{
		try
		{
			sensorManager.unsubscribeFromSensorData(sensorSubscriptionId);
			isSubscribed = false;
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onDataSensed(SensorData data)
	{
		logger.logSensorData(data, new DataStoreCallback()
		{
			@Override
			public void onDataStored()
			{
				try
				{
					logger.flush(new DataUploadCallback()
					{
						@Override
						public void onDataUploaded()
						{

						}

						@Override
						public void onDataUploadFailed()
						{

						}
					});
				}
				catch (DataHandlerException e)
				{
					e.printStackTrace();
				}
			}

			@Override
			public void onDataStoreFailed()
			{

			}
		});
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

	public boolean isSubscribed()
	{
		return isSubscribed;
	}

	@Override
	public void onCrossingLowBatteryThreshold(boolean isBelowThreshold)
	{
	}
}
