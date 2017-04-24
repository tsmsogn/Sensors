package com.ubhave.sensormanager.tester;

import android.util.Log;
import android.widget.Toast;

import com.ubhave.datahandler.loggertypes.AbstractDataLogger;
import com.ubhave.sensormanager.data.SensorData;
import com.ubhave.sensormanager.tester.loggers.AsyncUnencryptedDatabase;

import static com.ubhave.datastore.db.DatabaseStorage.TAG;

public class MySensorDataListener extends ExampleSensorDataListener
{
	private final static String LOG_TAG = "MySensorListener";
	private AbstractDataLogger logger = null;

	public MySensorDataListener(int sensorType, SensorDataUI userInterface)
	{
		super(sensorType, userInterface);
		try
		{
			logger = AsyncUnencryptedDatabase.getInstance();
		} catch (Exception e)
		{
			Toast.makeText(ApplicationContext.getContext(), "" + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
			Log.d(TAG, e.getLocalizedMessage());
			e.printStackTrace();
			e.printStackTrace();
		}
	}

	@Override
	public void onDataSensed(SensorData data)
	{
		super.onDataSensed(data);

		logger.logSensorData(data);
	}
}
