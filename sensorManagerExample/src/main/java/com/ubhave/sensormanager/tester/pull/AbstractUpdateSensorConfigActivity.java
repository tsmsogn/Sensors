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

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.ubhave.sensormanager.ESException;
import com.ubhave.sensormanager.tester.R;
import com.ubhave.sensormanager.tester.listeners.AbstractSensorDataListener;
import com.ubhave.sensormanager.tester.listeners.SensorDataListenerUtils;

import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class AbstractUpdateSensorConfigActivity extends Activity
{
	public final static String SENSOR_TYPE_ID = "sensorTypeId";
	private static final String TAG = "UpdateSensorConfig";

	private int selectedSensorType;
	private DecimalFormat formatter;
	private SensorConfigUpdater updater;
	private AbstractSensorDataListener sensorDataListener;
	private String[] samplingDelayTypes;
	private String[] enableLocationAccuracyTypes;

	private static final String TIME = "TIME";
	private static final String PERCENTAGE = "PERCENTAGE";

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		/*
		 * Instantiate the sensor data listener
		 */
		selectedSensorType = getIntent().getIntExtra(SENSOR_TYPE_ID, -1);
		try
		{
			sensorDataListener = SensorDataListenerUtils.getSensorDataListener(selectedSensorType);
		}
		catch (ESException e)
		{
			e.printStackTrace();
		}
		updater = new SensorConfigUpdater(this, selectedSensorType);

		enableLocationAccuracyTypes = getResources().getStringArray(R.array.location_accuracy_types);

		/*
		 * Create the user interface
		 */
		formatter = new DecimalFormat("#.##");

		setContentView(R.layout.config_sensor_layout);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle(sensorDataListener.getSensorName()+" Config");

		enableCheckBox(R.id.startSamplingOnBootCheckBox, enableSampCheckBox());
		enableProgressBar(R.id.sampleValue, TIME, R.id.sampleProgressBar, enableSampleTimeProgressBar());
		enableProgressBar(R.id.sleepValue, TIME, R.id.sleepProgressBar, enableSleepTimeProgressBar());
		enableSamplingDelaySpinner(R.id.motionDelayTypeSpinner, enableMotionDelayRateSpinner());
		enableProgressBar(R.id.lowPassAlphaValue, PERCENTAGE, R.id.lowPassAlphaProgressBar, enableLowPassAlphaProgressBar());
		enableProgressBar(R.id.movementThresholdValue, "", R.id.movementThresholdProgressBar, enableMovementThresholdProgressBar());
		enableCheckBox(R.id.enableSensorCheckBox, enableSensorCheckBox());
		enableProgressBar(R.id.sampleCyclesValue, "", R.id.sampleCyclesProgressBar, enableSampleCycleTimeProgressBar());
		enableLocationAccuracySpinner(R.id.locationAccuracySpinner, enableLocationAccuracySpinner());
		enableProgressBar(R.id.samplingRateValue, "", R.id.samplingRateProgressBar, enableSamplingRateProgressBar());
		enableProgressBar(R.id.soundThresholdValue, "", R.id.soundThresholdProgressBar, enableSoundThresholdProgressBar());
		enableProgressBar(R.id.timeLimitValue, TIME, R.id.timeLimitProgressBar, enableTimeLimitProgressBar());
		enableProgressBar(R.id.rowLimitValue, "", R.id.rowLimitProgressBar, enableRowLimitProgressBar());
		enableProgressBar(R.id.timeThresholdValue, TIME, R.id.timeThresholdProgressBar, enableTimeThresholdProgressBar());
		enableProgressBar(R.id.distanceThresholdValue, "", R.id.distanceThresholdProgressBar, enableDistanceThresholdProgressBar());
	}

	protected abstract boolean enableSampCheckBox();

	protected abstract boolean enableDistanceThresholdProgressBar();

	protected abstract boolean enableTimeThresholdProgressBar();

	protected abstract boolean enableRowLimitProgressBar();

	protected abstract boolean enableTimeLimitProgressBar();

	protected abstract boolean enableSamplingRateProgressBar();

	protected abstract boolean enableSoundThresholdProgressBar();

	protected abstract boolean enableLocationAccuracySpinner();

	protected abstract boolean enableSampleCycleTimeProgressBar();

	protected abstract boolean enableSensorCheckBox();

	protected abstract boolean enableMovementThresholdProgressBar();

	protected abstract boolean enableLowPassAlphaProgressBar();

	protected abstract boolean enableMotionDelayRateSpinner();

	protected abstract boolean enableSleepTimeProgressBar();

	protected abstract boolean enableSampleTimeProgressBar();

	private void enableProgressBar(int textId, final String unit, final int progressId, final boolean enabled)
	{
		final TextView currentStatus = (TextView) findViewById(textId);

		SeekBar progress = (SeekBar) findViewById(progressId);
		progress.setEnabled(enabled);

		if (enabled)
		{
			int initialValue = 0;

			switch (progressId)
			{
			case R.id.sampleProgressBar:
				initialValue = (int) (updater.getSensorSampleWindow() / 1000);
				break;
			case R.id.sleepProgressBar:
				initialValue = (int) (updater.getSensorSleepWindow() / 1000);
				break;
			case R.id.lowPassAlphaProgressBar:
				initialValue = (int) (updater.getLowPassAlpha() * 100);
				break;
			case R.id.movementThresholdProgressBar:
				initialValue = updater.getMovementThreshold();
				break;
			case R.id.sampleCyclesProgressBar:
				initialValue = updater.getSampleCycles();
				break;
			case R.id.samplingRateProgressBar:
				initialValue = updater.getSamplingRate();
				break;
			case R.id.soundThresholdProgressBar:
				initialValue = updater.getSoundThreshold();
				break;
			case R.id.timeLimitProgressBar:
				initialValue = (int) (updater.getTimeLimit() / 1000);
				break;
			case R.id.rowLimitProgressBar:
				initialValue = updater.getRowLimit();
				break;
			case R.id.timeThresholdProgressBar:
				initialValue = (int) (updater.getTimeThreshold() / 1000);
				break;
			case R.id.distanceThresholdProgressBar:
				initialValue = (int) updater.getDistanceThreshold();
				break;
			}

			currentStatus.setText(getFormatted(initialValue, unit));

			progress.setProgress(initialValue);

			progress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			{
				public void onStopTrackingTouch(SeekBar seekBar)
				{
					int value = seekBar.getProgress();
					// TODO
					switch (progressId)
					{
					case R.id.sampleProgressBar:
					case R.id.sleepProgressBar:
					case R.id.sampleCyclesProgressBar:
					case R.id.samplingRateProgressBar:
					case R.id.timeLimitProgressBar:
						if (value == 0)
						{
							value++;
						}
						break;
					}

					switch (progressId)
					{
					case R.id.sampleProgressBar:
						updater.setSensorSampleWindow(value * 1000);
						break;
					case R.id.sleepProgressBar:
						updater.setSensorSleepWindow(value * 1000);
						break;
					case R.id.lowPassAlphaProgressBar:
						updater.setLowPassAlpha((float) value / 100);
						break;
					case R.id.movementThresholdProgressBar:
						updater.setMovementThreshold(value);
						break;
					case R.id.sampleCyclesProgressBar:
						updater.setSampleCycles(value);
						break;
					case R.id.soundThresholdProgressBar:
						updater.setSoundThreshold(value);
						break;
					case R.id.samplingRateProgressBar:
						updater.setSamplingRate(value);
						break;
					case R.id.timeLimitProgressBar:
						updater.setTimeLimit(value * 1000);
						break;
					case R.id.rowLimitProgressBar:
						updater.setRowLimit(value);
						break;
					case R.id.timeThresholdProgressBar:
						updater.setTimeThreshold(value * 1000);
						break;
					case R.id.distanceThresholdProgressBar:
						updater.setDistanceThreshold((float) value);
						break;
					}
				}

				public void onStartTrackingTouch(SeekBar seekBar)
				{
				}

				public void onProgressChanged(SeekBar seekBar, int rating, boolean fromUser)
				{
					// TODO
					switch (progressId)
					{
					case R.id.sampleProgressBar:
					case R.id.sleepProgressBar:
					case R.id.sampleCyclesProgressBar:
					case R.id.samplingRateProgressBar:
					case R.id.timeLimitProgressBar:
						if (rating == 0)
						{
							rating++;
						}
						break;
					}
					currentStatus.setText(getFormatted(rating, unit));
				}
			});
		}
	}

	private void enableSamplingDelaySpinner(final int spinnerId, final boolean enabled)
	{
		final Spinner spinner = (Spinner) findViewById(spinnerId);
		spinner.setEnabled(enabled);

		if (enabled)
		{
			int initialValue = updater.getSamplingDelay();

			spinner.setSelection(initialValue);

			spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
			{
				@Override
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
				{
					updater.setSamplingDelay(position);
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent)
				{

				}
			});
		}
	}

	private void enableLocationAccuracySpinner(final int spinnerId, final boolean enabled)
	{
		final Spinner spinner = (Spinner) findViewById(spinnerId);
		spinner.setEnabled(enabled);

		if (enabled)
		{
			String initialValue = updater.getLocationAccuracy();

			int position = Arrays.asList(enableLocationAccuracyTypes).indexOf(initialValue);

			spinner.setSelection(position);

			spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
			{
				@Override
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
				{
					String locationAccuracy = parent.getItemAtPosition(position).toString();
					updater.setLocationAccuracy(locationAccuracy);
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent)
				{

				}
			});
		}
	}

	private void enableCheckBox(final int checkBoxId, final boolean enabled)
	{
		CheckBox checkBox = (CheckBox) findViewById(checkBoxId);
		checkBox.setEnabled(enabled);

		if (enabled)
		{
			Boolean initialValue = false;

			switch (checkBoxId)
			{
			case R.id.startSamplingOnBootCheckBox:
				initialValue = updater.isStartSensingOnBoot();
				break;
			case R.id.enableSensorCheckBox:
				initialValue = updater.isSensorEnabled();
				break;
			}

			checkBox.setChecked(initialValue);

			checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
			{
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
				{
					switch (checkBoxId)
					{
					case R.id.startSamplingOnBootCheckBox:
						updater.startSensingOnBoot(isChecked);
						break;
					case R.id.enableSensorCheckBox:
						updater.enableSensor(isChecked);
						break;
					}
				}
			});
		}
	}

	private String getFormatted(int value, String unit)
	{
		switch (unit)
		{
		case TIME:
			if (value == 1)
			{
				return "1 second";
			}
			if (value <= 120)
			{
				return value+" seconds";
			}
			else
			{
				double minutes = (double) value / 60;
				return formatter.format(minutes)+" minutes";
			}
		case PERCENTAGE:
			return value+" %";
		}
		return value+unit;
	}
}
