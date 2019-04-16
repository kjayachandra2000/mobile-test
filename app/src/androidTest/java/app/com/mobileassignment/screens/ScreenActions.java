package app.com.mobileassignment.screens;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import androidx.test.espresso.ViewInteraction;
import app.com.mobileassignment.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

class ScreenActions {

    public ViewInteraction findView(Integer viewId) {
        return onView(withId(viewId));
    }

    public void enterText(Integer viewId, String text) {
        findView(viewId).perform(typeText(text), closeSoftKeyboard());
    }

    public void assertViewIsDisplayed(Integer viewId) {
        findView(viewId).check(matches(isDisplayed()));
    }

    public void clickOn(Integer viewId) {
        findView(viewId).perform(click());
    }

    public void scrollToTheBottom() {
        findView(R.id.citiesList).perform(swipeUp());
    }

    public void zoomIn() {
        ViewInteraction imageView = onView(
                allOf(withContentDescription("Zoom in"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        2),
                                0),
                        isDisplayed()));
        imageView.perform(click());
    }

    public void zoomOut() {
        ViewInteraction imageView = onView(
                allOf(withContentDescription("Zoom out"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        2),
                                1),
                        isDisplayed()));
        imageView.perform(click());
    }

    public static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
