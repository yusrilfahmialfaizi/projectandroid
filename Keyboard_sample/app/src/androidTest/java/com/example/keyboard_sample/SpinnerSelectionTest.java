package com.example.keyboard_sample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class SpinnerSelectionTest{
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    public void iterateSpinnerItems(){
        String[] myArray =
                mActivityRule.getActivity().getResources()
                .getStringArray(R.array.labels_array);
        int size = myArray.length;
        for(int i = 0;i < size; i++){
            //Find the spinner and click on it
            onView(withId(R.id.label_spinner)).perform(click());
            onData(is(myArray[i])).perform(click());

            onView(withId(R.id.button_Phone)).perform(click());
            onView(withId(R.id.text_phoneLabel)).check(matches(withText(containsString(myArray[i]))));
        }
    }
}
