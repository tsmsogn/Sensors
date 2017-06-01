/* **************************************************
Copyright (c) 2015
Neal Lathia, @nlathia

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

package com.ubhave.sensormanager.tester.loggers;

import android.content.Context;

import com.ubhave.datahandler.config.DataStorageConfig;
import com.ubhave.datahandler.except.DataHandlerException;
import com.ubhave.datahandler.loggertypes.AbstractAsyncTransferLogger;
import com.ubhave.sensormanager.ESException;
import com.ubhave.sensormanager.tester.ApplicationContext;
import com.ubhave.sensormanager.tester.datahandler.config.DeviceHandlerConfig;

import java.util.HashMap;

public class AsyncUnencryptedDatabase extends AbstractAsyncTransferLogger
{
	private static AsyncUnencryptedDatabase instance;

	public static AsyncUnencryptedDatabase getInstance() throws ESException, DataHandlerException
	{
		if (instance == null)
		{
			instance = new AsyncUnencryptedDatabase(ApplicationContext.getContext());
		}
		return instance;
	}

	protected AsyncUnencryptedDatabase(Context context) throws DataHandlerException, ESException
	{
		super(context, DataStorageConfig.STORAGE_TYPE_DB);
	}

	@Override
	protected String getDataPostURL()
	{
		return RemoteServerDetails.getFilePostUrl();
	}

	@Override
	protected String getPostKey()
	{
		return RemoteServerDetails.getFileKey();
	}

	@Override
	protected String getSuccessfulPostResponse()
	{
		return RemoteServerDetails.getResponseOnSuccess();
	}

	@Override
	protected HashMap<String, String> getPostParameters()
	{
		// Note: any additional parameters (e.g., API key-value) that your URL
		// requires
		HashMap<String, String> params = new HashMap<String, String>();
//		params.put(RemoteServerDetails.API_KEY_KEY, RemoteServerDetails.API_KEY_VALUE);
		return params;
	}

	@Override
	protected long getDataLifeMillis()
	{
		// Note: all data that is more than 1 hour old will be transferred
		return 1000L * 60 * 60 * 1;
	}

	@Override
	protected long getTransferAlarmLengthMillis()
	{
		// Note: transfer alarm will fire every 2 hours
		return 1000L * 60 * 60 * 2;
	}

	@Override
	protected String getFileStorageName()
	{
		// Unused for database storage
		return null;
	}

	@Override
	protected String getUniqueUserId()
	{
		// Note: this should not be a static string
		return DeviceHandlerConfig.getUserId();
	}

	@Override
	protected String getDeviceId()
	{
		// Note: this should not be a static string
		return DeviceHandlerConfig.getDeviceId();
	}

	@Override
	protected boolean shouldPrintLogMessages()
	{
		// Note: return false to turn off Log.d messages
		return true;
	}

	@Override
	protected String getEncryptionPassword()
	{
		// Note: return non-null password to encrypt data
		return null;
	}
	
	@Override
	protected long getWaitForWiFiMillis()
	{
		// Note: wait for a Wi-Fi connection for a maximum of 4 hours
		return 1000L * 60 * 60 * 4;
	}
}
