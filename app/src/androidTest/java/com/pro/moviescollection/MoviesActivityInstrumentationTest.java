package com.pro.moviescollection;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.not;

import android.view.View;
import android.widget.ListView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MoviesActivityInstrumentationTest {

    private ListView listView;

    @Rule
    public ActivityScenarioRule<MoviesActivity> activityScenarioRule  = new ActivityScenarioRule<MoviesActivity>(MoviesActivity.class);

    private View activityDecorView;
    @Before
    public void setUp(){
        activityScenarioRule.getScenario().onActivity(new ActivityScenario.ActivityAction<MoviesActivity>() {
            @Override
            public void perform(MoviesActivity activity) {
                activityDecorView = activity.getWindow().getDecorView();
            }
        });
    }

    @Test
    public void listItemClickDisplaysToastWithCorrectMoviesName() {
        String moviesName = "The Oval";
        onData(anything())
                .inAdapterView(withId(R.id.listView))
                .atPosition(0)
                .perform(click());
        onView(withText(moviesName)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(moviesName)));
    }
}
