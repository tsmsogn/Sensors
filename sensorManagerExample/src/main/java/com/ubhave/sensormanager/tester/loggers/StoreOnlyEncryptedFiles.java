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
import android.util.Log;

import com.ubhave.datahandler.config.DataStorageConfig;
import com.ubhave.datahandler.except.DataHandlerException;
import com.ubhave.datahandler.loggertypes.AbstractStoreOnlyLogger;
import com.ubhave.sensormanager.ESException;
import com.ubhave.sensormanager.tester.ApplicationContext;
import com.ubhave.sensormanager.tester.datahandler.config.DeviceHandlerConfig;

public class StoreOnlyEncryptedFiles extends AbstractStoreOnlyLogger
{
	private static StoreOnlyEncryptedFiles instance;
	
	public static StoreOnlyEncryptedFiles getInstance() throws ESException, DataHandlerException
	{
		if (instance == null)
		{
			instance = new StoreOnlyEncryptedFiles(ApplicationContext.getContext());
		}
		return instance;
	}

	protected StoreOnlyEncryptedFiles(final Context context) throws DataHandlerException, ESException
	{
		super(context, DataStorageConfig.STORAGE_TYPE_FILES);
	}

	@Override
	protected String getFileStorageName()
	{
		return "Demo-Encrypted-File-Storage";
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
		Log.d("MainActivity", "getEncryptionPassword()");
		// Note: return non-null password to encrypt data
		return "password";
	}
}
