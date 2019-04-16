package app.com.mobileassignment.screens;

import android.view.View;

import org.hamcrest.Matcher;

import androidx.test.espresso.ViewInteraction;
import app.com.mobileassignment.R;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.allOf;

public class ListScreen extends ScreenActions {

    private int txtSearch = R.id.search;
    private Matcher<View> lstCityName = withId(R.id.cityName);
    private Matcher<View> lstCity = withId(R.id.citiesList);

    public ListScreen GivenISearchFor(String cityName) {
        enterText(txtSearch, cityName);
        closeSoftKeyboard();
        return this;
    }

    public void ThenIShouldSeeResultsFor(String cityName, int position) {
        getItemByPosition(position).check(matches(withText(containsString(cityName))));
    }

    public ListScreen WhenISelectTheCity(String cityName, int position) {
        getItemByPosition(position).check(matches(withText(containsString(cityName)))).perform(click());
        return this;
    }

    public void ThenIShouldSeeGooglePointerWithTitleAs(String cityName) {
        assertViewIsDisplayed(R.id.insert_point);
        onView(withContentDescription("Google Map")).check(matches(isDisplayed()));
    }

    private ViewInteraction getItemByPosition(int position) {

        return onView(
                allOf(lstCityName,
                        childAtPosition(
                                childAtPosition(
                                        lstCity,
                                        position),
                                0),
                        isDisplayed()));
    }
}
