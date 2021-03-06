package com.ubhave.sensormanager.tester.listeners;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

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
import com.ubhave.sensormanager.data.SensorData;
import com.ubhave.sensormanager.sensors.SensorUtils;
import com.ubhave.sensormanager.tester.ApplicationContext;
import com.ubhave.sensormanager.tester.SensorDataSender;
import com.ubhave.sensormanager.tester.loggers.AsyncUnencryptedFiles;
import com.ubhave.sensormanager.tester.pull.SensorConfigUpdater;

public abstract class AbstractSensorDataListener implements SensorDataListener, SensorDataSender
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
		new SensorConfigUpdater(context, sensorType).set();

		try
		{
			sensorManager = ESSensorManager.getSensorManager(context);
			sensorManager.setGlobalConfig(GlobalConfig.LOW_BATTERY_THRESHOLD, 25);
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
	public void onDataSensed(final SensorData data)
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

		try
		{
			send(formatter.toString(data));
		}
		catch (DataHandlerException e)
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

	public boolean isSubscribed()
	{
		return isSubscribed;
	}

	@Override
	public void onCrossingLowBatteryThreshold(boolean isBelowThreshold)
	{
	}

	@Override
	public void send(String data)
	{
		Intent intent = new Intent("receiveSensorData");
		intent.putExtra("sensorType", sensorType);
		intent.putExtra("sensorData", data);
		LocalBroadcastManager.getInstance(ApplicationContext.getContext()).sendBroadcastSync(intent);
	}
}
