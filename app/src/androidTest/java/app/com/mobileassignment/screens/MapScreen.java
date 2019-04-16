package app.com.mobileassignment.screens;

import app.com.mobileassignment.R;

import static com.google.android.gms.maps.CameraUpdateFactory.zoomOut;

public class MapScreen extends ScreenActions {

    private int pointer = R.id.insert_point;

    public void GivenIamOnMapScreen() {

        assertViewIsDisplayed(pointer);
    }

    public MapScreen ShouldBeAbleToZoomIn() {
        zoomIn();
        return this;
    }

    public void ShouldBeAbleToZoomOut() {
        zoomOut();
    }
}
