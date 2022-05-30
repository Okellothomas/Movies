package com.pro.moviescollection;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static java.util.regex.Pattern.matches;

import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainScreenInstrumentationTest {

    @Rule
    public ActivityScenarioRule<MainScreen> activityScenarioRule = new ActivityScenarioRule<MainScreen>(MainScreen.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.name)).perform(typeText("name"))
                .check(ViewAssertions.matches(withText("Nairobi")));
    }

    @Test
    public void nameIsSentRestaurantActivity() {
        String name = "name";

        onView(withId(R.id.name)).perform(typeText(name)).perform(closeSoftKeyboard());
        try {
            // The sleep method requires to be ckecked and handled so we use try block
            Thread.sleep(300);
        }catch (InterruptedException e){
            System.out.println("Got interrupted somewhere i know not");
        }
        onView(withId(R.id.floatingActionButton)).perform(click());
        onView(withId(R.id.listView)).check(ViewAssertions.matches(withText("Here are all the restaurants near: " + name)));
    }
}
