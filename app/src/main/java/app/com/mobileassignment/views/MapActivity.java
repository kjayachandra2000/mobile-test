package app.com.mobileassignment.views;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.appcompat.app.AppCompatActivity;
import app.com.mobileassignment.R;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private float latitude;
    private float longitude;
    private String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent intent = getIntent();
        latitude = intent.getFloatExtra(MainActivity.COORDINATES_LAT, 0.0f);
        longitude = intent.getFloatExtra(MainActivity.COORDINATES_LON, 0.0f);
        cityName = intent.getStringExtra(MainActivity.CITY_NAME);

        MapFragment mMapFragment = MapFragment.newInstance();
        FragmentTransaction fragmentTransaction =
                getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.insert_point, mMapFragment);
        fragmentTransaction.commit();

        mMapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMinZoomPreference(5);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude))
                .title(cityName)).showInfoWindow();
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(latitude, longitude)));

    }
}
