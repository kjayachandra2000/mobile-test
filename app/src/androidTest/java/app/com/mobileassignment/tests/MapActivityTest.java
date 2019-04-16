package app.com.mobileassignment.tests;

import android.content.Intent;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;
import app.com.mobileassignment.screens.MapScreen;
import app.com.mobileassignment.views.MapActivity;

import static app.com.mobileassignment.views.MainActivity.CITY_NAME;
import static app.com.mobileassignment.views.MainActivity.COORDINATES_LAT;
import static app.com.mobileassignment.views.MainActivity.COORDINATES_LON;

public class MapActivityTest extends BaseTest {

    @Rule
    public final ActivityTestRule<MapActivity> mActivityRule =
            new ActivityTestRule<>(MapActivity.class, true, false);

    @Override
    @Before
    public void registerIdlingResource() {
        Intent intent = new Intent();
        intent.putExtra(COORDINATES_LAT, 25.258169F);
        intent.putExtra(COORDINATES_LON, 55.304722F);
        intent.putExtra(CITY_NAME, "Dubai");
        mActivityRule.launchActivity(intent);
    }

    @Test
    public void invokeMapActivityTest() {
        new MapScreen()
                .GivenIamOnMapScreen();
    }


    @Test
    public void userShouldBeAbleToZoom() {
        new MapScreen()
                .ShouldBeAbleToZoomIn()
                .ShouldBeAbleToZoomOut();
    }
}
