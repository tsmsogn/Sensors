package com.ubhave.sensormanager.tester;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.ubhave.sensormanager.sensors.SensorUtils;
import com.ubhave.sensormanager.tester.pull.AbstractUpdateSensorConfigActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class UpdateContentReaderConfigActivityTest
{
	@Rule
	public ActivityTestRule<UpdateContentReaderConfigActivity> mActivityRule = new ActivityTestRule<>(
			UpdateContentReaderConfigActivity.class, false, false);

	@Before
	public void setUp() throws Exception
	{
		Intent intent = new Intent();
		intent.putExtra(AbstractUpdateSensorConfigActivity.SENSOR_TYPE_ID, SensorUtils.SENSOR_TYPE_CALL_CONTENT_READER);
		mActivityRule.launchActivity(intent);
	}

	@Test
	public void ui()
	{
		onView(withId(R.id.startSamplingOnBootCheckBox))
				.check(matches(isEnabled()));
		onView(withId(R.id.sampleProgressBar))
				.check(matches(not(isEnabled())));
		onView(withId(R.id.sleepProgressBar))
				.check(matches(isEnabled()));
		onView(withId(R.id.motionDelayTypeSpinner))
				.check(matches(not(isEnabled())));
		onView(withId(R.id.lowPassAlphaProgressBar))
				.check(matches(not(isEnabled())));
		onView(withId(R.id.movementThresholdProgressBar))
				.check(matches(not(isEnabled())));
		onView(withId(R.id.enableSensorCheckBox))
				.check(matches(not(isEnabled())));
		onView(withId(R.id.sampleCyclesProgressBar))
				.check(matches(isEnabled()));
		onView(withId(R.id.locationAccuracySpinner))
				.check(matches(not(isEnabled())));
		onView(withId(R.id.soundThresholdProgressBar))
				.check(matches(not(isEnabled())));
		onView(withId(R.id.samplingRateProgressBar))
				.check(matches(not(isEnabled())));
		onView(withId(R.id.timeLimitProgressBar))
				.check(matches(isEnabled()));
		onView(withId(R.id.rowLimitProgressBar))
				.check(matches(isEnabled()));
		onView(withId(R.id.timeThresholdProgressBar))
				.check(matches(not(isEnabled())));
		onView(withId(R.id.distanceThresholdProgressBar))
				.check(matches(not(isEnabled())));
	}
}
