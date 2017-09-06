package com.example.konrad.aplikacjadotestow;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * Created by Konrad on 05.08.2017.
 */
@RunWith(AndroidJUnit4.class)
public class AndroidTest {
    private Solo solo;

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setUp() throws Exception{
        solo = new Solo(InstrumentationRegistry.getInstrumentation(), activityActivityTestRule.getActivity());
    }

    @After
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}
