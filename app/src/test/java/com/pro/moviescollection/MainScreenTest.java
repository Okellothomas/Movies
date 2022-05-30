package com.pro.moviescollection;

import static org.junit.Assert.*;

import android.content.Intent;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

@Config(manifest=Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class MainScreenTest {

    // declare the variable activity.
    private MainScreen mainScreen;
    @Before
    public void setUp() throws Exception {
        mainScreen = Robolectric.buildActivity(MainScreen.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void validateTextViewContent_true() {
        TextView name = mainScreen.findViewById(R.id.textView2);
        assertTrue("user".equals(name.getText().toString()));
    }

    @Test
    public void secondActivityStarted() {
        mainScreen.findViewById(R.id.floatingActionButton).performClick();
        Intent expectedIntent = new Intent(mainScreen, MoviesActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(mainScreen);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }

    @After
    public void tearDown() throws Exception {
    }
}