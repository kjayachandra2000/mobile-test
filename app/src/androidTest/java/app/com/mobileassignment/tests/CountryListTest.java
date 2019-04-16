package app.com.mobileassignment.tests;

import org.junit.Test;

import app.com.mobileassignment.screens.ListScreen;

public class CountryListTest extends BaseTest {


    private static final String CITY_NAME = "Dubai";
    private static final int POSITION = 0;

    @Test
    public void userShouldBeAbleToSearch() {

        new ListScreen()
                .GivenISearchFor(CITY_NAME)
                .ThenIShouldSeeResultsFor(CITY_NAME, POSITION);
    }

    @Test
    public void userShouldBeSelectSearchCity() {

        new ListScreen()
                .GivenISearchFor(CITY_NAME)
                .WhenISelectTheCity(CITY_NAME, POSITION)
                .ThenIShouldSeeGooglePointerWithTitleAs(CITY_NAME);
    }
}
