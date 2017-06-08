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

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ubhave.sensormanager.sensors.SensorUtils;
import com.ubhave.sensormanager.tester.R;
import com.ubhave.sensormanager.tester.UpdateBluetoothConfigActivity;
import com.ubhave.sensormanager.tester.UpdateContentReaderConfigActivity;
import com.ubhave.sensormanager.tester.UpdateLocationConfigActivity;
import com.ubhave.sensormanager.tester.UpdateMicrophoneConfigActivity;
import com.ubhave.sensormanager.tester.UpdateMotionSensorConfigActivity;
import com.ubhave.sensormanager.tester.UpdatePassiveLocationConfigActivity;
import com.ubhave.sensormanager.tester.UpdatePhoneRadioConfigActivity;
import com.ubhave.sensormanager.tester.UpdateSensorConfigActivity;
import com.ubhave.sensormanager.tester.UpdateStepCounterConfigActivity;
import com.ubhave.sensormanager.tester.UpdateWifiConfigActivity;

public class ConfigurablePullSensorExampleActivity extends AbstractPullSensorExampleActivity
{

	protected void enableUpdateConfigButton()
	{
		Button button = (Button) findViewById(R.id.changeConfigButton);
		button.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				updateSensorConfig();
			}
		});
	}

	private void updateSensorConfig()
	{
		Intent intent;
		switch (selectedSensorType)
		{
		case SensorUtils.SENSOR_TYPE_ACCELEROMETER:
		case SensorUtils.SENSOR_TYPE_GYROSCOPE:
		case SensorUtils.SENSOR_TYPE_MAGNETIC_FIELD:
			intent = new Intent(this, UpdateMotionSensorConfigActivity.class);
			intent.putExtra(AbstractUpdateSensorConfigActivity.SENSOR_TYPE_ID, selectedSensorType);
			startActivity(intent);
			break;
		case SensorUtils.SENSOR_TYPE_BLUETOOTH:
			intent = new Intent(this, UpdateBluetoothConfigActivity.class);
			intent.putExtra(AbstractUpdateSensorConfigActivity.SENSOR_TYPE_ID, selectedSensorType);
			startActivity(intent);
			break;
		case SensorUtils.SENSOR_TYPE_LOCATION:
			intent = new Intent(this, UpdateLocationConfigActivity.class);
			intent.putExtra(AbstractUpdateSensorConfigActivity.SENSOR_TYPE_ID, selectedSensorType);
			startActivity(intent);
			break;
		case SensorUtils.SENSOR_TYPE_MICROPHONE:
			intent = new Intent(this, UpdateMicrophoneConfigActivity.class);
			intent.putExtra(AbstractUpdateSensorConfigActivity.SENSOR_TYPE_ID, selectedSensorType);
			startActivity(intent);
			break;
		case SensorUtils.SENSOR_TYPE_WIFI:
			intent = new Intent(this, UpdateWifiConfigActivity.class);
			intent.putExtra(AbstractUpdateSensorConfigActivity.SENSOR_TYPE_ID, selectedSensorType);
			startActivity(intent);
			break;
		case SensorUtils.SENSOR_TYPE_SMS_CONTENT_READER:
		case SensorUtils.SENSOR_TYPE_CALL_CONTENT_READER:
			intent = new Intent(this, UpdateContentReaderConfigActivity.class);
			intent.putExtra(AbstractUpdateSensorConfigActivity.SENSOR_TYPE_ID, selectedSensorType);
			startActivity(intent);
			break;
		case SensorUtils.SENSOR_TYPE_PHONE_RADIO:
			intent = new Intent(this, UpdatePhoneRadioConfigActivity.class);
			intent.putExtra(AbstractUpdateSensorConfigActivity.SENSOR_TYPE_ID, selectedSensorType);
			startActivity(intent);
			break;
		case SensorUtils.SENSOR_TYPE_PASSIVE_LOCATION:
			intent = new Intent(this, UpdatePassiveLocationConfigActivity.class);
			intent.putExtra(AbstractUpdateSensorConfigActivity.SENSOR_TYPE_ID, selectedSensorType);
			startActivity(intent);
			break;
		case SensorUtils.SENSOR_TYPE_STEP_COUNTER:
			intent = new Intent(this, UpdateStepCounterConfigActivity.class);
			intent.putExtra(AbstractUpdateSensorConfigActivity.SENSOR_TYPE_ID, selectedSensorType);
			startActivity(intent);
			break;
		default:
			intent = new Intent(this, UpdateSensorConfigActivity.class);
			intent.putExtra(AbstractUpdateSensorConfigActivity.SENSOR_TYPE_ID, selectedSensorType);
			startActivity(intent);
			break;
		}
	}
}
