package com.ubhave.sensormanager.tester;

import com.ubhave.sensormanager.tester.pull.AbstractUpdateSensorConfigActivity;

public class UpdateMicrophoneConfigActivity extends AbstractUpdateSensorConfigActivity
{
	@Override
	protected boolean enableSampCheckBox()
	{
		return true;
	}

	@Override
	protected boolean enableDistanceThresholdProgressBar()
	{
		return false;
	}

	@Override
	protected boolean enableTimeThresholdProgressBar()
	{
		return false;
	}

	@Override
	protected boolean enableRowLimitProgressBar()
	{

		return false;
	}

	@Override
	protected boolean enableTimeLimitProgressBar()
	{

		return false;
	}

	@Override
	protected boolean enableSamplingRateProgressBar()
	{

		return true;
	}

	@Override
	protected boolean enableSoundThresholdProgressBar()
	{

		return true;
	}

	@Override
	protected boolean enableLocationAccuracySpinner()
	{

		return false;
	}

	@Override
	protected boolean enableSampleCycleTimeProgressBar()
	{

		return false;
	}

	@Override
	protected boolean enableSensorCheckBox()
	{

		return false;
	}

	@Override
	protected boolean enableMovementThresholdProgressBar()
	{

		return false;
	}

	@Override
	protected boolean enableLowPassAlphaProgressBar()
	{

		return false;
	}

	@Override
	protected boolean enableMotionDelayRateSpinner()
	{

		return false;
	}

	@Override
	protected boolean enableSleepTimeProgressBar()
	{

		return true;
	}

	@Override
	protected boolean enableSampleTimeProgressBar()
	{

		return true;
	}
}
