package com.humber.jobstart.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;
import com.humber.jobstart.R;

import es.dmoral.toasty.Toasty;

/**
 * The type Find us activity.
 * This activity inflates the Google MapView which uses Maps and Location API from Google
 * I have added markers to display at the location of JobStart
 * This map has all functionality of a normal Map except for direction for which I am using a call to inbuilt MAP app of Android
 */
public class FindUsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks {

    private GoogleMap mMap;
    private Button mLakeDirection, mDufferinDirection, mChaunceyDirection;
    private static float DEFAULT_ZOOM = 16;
    private LottieAnimationView mNetworkErr;
    /**
     * The constant TAG.
     */
    public static final String TAG = FindUsActivity.class.getSimpleName();
    private double lakeLat = 43.601055;
    private double lakeLng = -79.505137;
    private double duffLat = 43.636619;
    private double duffLng = -79.426033;
    private double chauLat = 43.636861;
    private double chauLng = -79.525185;

    /**
     * This onCreate Method is the first method called upon on creation of an Activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_us);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
        mNetworkErr = findViewById(R.id.xConnectErrorAnim);
        mLakeDirection = findViewById(R.id.xLakeDirection);
        mDufferinDirection = findViewById(R.id.xDufferinDirection);
        mChaunceyDirection = findViewById(R.id.xChaunceyDirection);
    }

    /**
     * onMapReady method implements markers and other map features after connection to Map api has been successful
     * @param googleMap
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Log.d(TAG, "MAP IS READY");
        mMap.setMinZoomPreference(10);
        mMap.setMaxZoomPreference(DEFAULT_ZOOM);
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.setBuildingsEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        getCurrentLocation();

        LatLng lake = new LatLng(lakeLat, lakeLng);
        mMap.addMarker(new MarkerOptions()
                .position(lake)
                .title(getString(R.string.jobstart_at_lakeshore))
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

        LatLng dufferin = new LatLng(duffLat, duffLng);
        mMap.addMarker(new MarkerOptions()
                .position(dufferin)
                .title(getString(R.string.jobstart_at_dufferin))
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

        LatLng chauncey = new LatLng(chauLat, chauLng);
        mMap.addMarker(new MarkerOptions()
                .position(chauncey)
                .title(getString(R.string.jobstart_at_chauncey))
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

        mLakeDirection.setOnClickListener(v -> mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lake, DEFAULT_ZOOM)));

        mLakeDirection.setOnLongClickListener(v -> {
            String addr = "2930 Lake Shore Blvd. West Toronto, ON M8V1J4";
            String uri = "geo:" + lakeLat + "," + lakeLng + "?q=" + addr;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            getApplicationContext().startActivity(intent);
            return true;
        });

        mDufferinDirection.setOnClickListener(v -> mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dufferin, DEFAULT_ZOOM)));

        mDufferinDirection.setOnLongClickListener(v -> {
            String addr = "219 Dufferin St. #1C King and Dufferin (South of King) Building 201, Suite 1C Toronto, ON M6K3J1";
            String uri = "geo:" + duffLat + "," + duffLng + "?q=" + addr;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            getApplicationContext().startActivity(intent);
            return true;
        });

        mChaunceyDirection.setOnClickListener(v -> mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(chauncey, DEFAULT_ZOOM)));

        mChaunceyDirection.setOnLongClickListener(v -> {
            String addr = "41 Chauncey Ave. Toronto, ON M8Z2Z2";
            String uri = "geo:" + chauLat + "," + chauLng + "?q=" + addr;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            getApplicationContext().startActivity(intent);
            return true;
        });

        Toasty.info(getApplicationContext(), "Long press the location button to get directions", Toasty.LENGTH_LONG).show();
    }

    /**
     * getCurrentLocation gets the current location of the user, by showing a blue dot and a marker on the map
     */

    private void getCurrentLocation() {
        Log.d(TAG, "GET CURRENT LOCATION");
        FusedLocationProviderClient mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        try {
            Task location = mFusedLocationProviderClient.getLastLocation();
            location.addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Log.d(TAG, "GOT CURRENT USER LOCATION");
                    Location currentlocation = (Location) task.getResult();
                    if (currentlocation != null) {
                        double lat = currentlocation.getLatitude();
                        double lng = currentlocation.getLongitude();
                        LatLng cl = new LatLng(lat, lng);
                        mMap.addMarker(new MarkerOptions()
                                .position(cl)
                                .title("Your location"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(cl));
                    }
                } else {
                    Log.d(TAG, "FAILED TO GET CURRENT LOCATION");
                    Toasty.error(getApplicationContext(), "Failed to get current location", Toasty.LENGTH_SHORT).show();
                }
            });
        } catch (SecurityException e) {
            Log.d(TAG, e.toString());
        }

    }

    /**
     * Code to get complete location address etc
     * private String getCompleteAddressString(double LATITUDE, double LONGITUDE) {
     * String strAdd = "";
     * Geocoder geocoder = new Geocoder(this, Locale.getDefault());
     * try {
     * List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
     * if (addresses != null) {
     * Address returnedAddress = addresses.get(0);
     * StringBuilder strReturnedAddress = new StringBuilder("");
     * <p>
     * for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
     * strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
     * }
     * strAdd = strReturnedAddress.toString();
     * Log.w("My Current location address", strReturnedAddress.toString());
     * } else {
     * Log.w("My Current location address", "No Address returned!");
     * }
     * } catch (Exception e) {
     * e.printStackTrace();
     * Log.w("My Current location address", "Cannot get Address!");
     * }
     * return strAdd;
     * }
     **/

    /**
     * If connection is failed then whole app will exit
     * If connection to Google Maps api is successful then it will just show a message of being ready
     * @param connectionResult
     */
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        String connErr = connectionResult.toString();
        Log.e("Connection Error", connErr);
        mNetworkErr.setVisibility(View.VISIBLE);
        finish();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.d(TAG, "CONNECTION SUCCESSFUL");
        Toasty.success(getApplicationContext(), "Ready!", Toasty.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d(TAG, "CONNECTION SUSPENDED");
    }
}
