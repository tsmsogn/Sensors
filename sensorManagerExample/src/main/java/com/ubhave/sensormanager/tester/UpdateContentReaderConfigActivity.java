package com.ubhave.sensormanager.tester;

import com.ubhave.sensormanager.tester.pull.AbstractUpdateSensorConfigActivity;

public class UpdateContentReaderConfigActivity extends AbstractUpdateSensorConfigActivity
{
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

		return true;
	}

	@Override
	protected boolean enableTimeLimitProgressBar()
	{

		return true;
	}

	@Override
	protected boolean enableSamplingRateProgressBar()
	{

		return false;
	}

	@Override
	protected boolean enableSoundThresholdProgressBar()
	{

		return false;
	}

	@Override
	protected boolean enableLocationAccuracySpinner()
	{

		return false;
	}

	@Override
	protected boolean enableSampleCycleTimeProgressBar()
	{

		return true;
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

		return false;
	}
}
