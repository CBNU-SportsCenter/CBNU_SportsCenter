package com.example.cbnu_sportscenter;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class DirectionActivity extends Fragment {

    public SupportMapFragment mapFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_direction, container, false);

        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    LatLng latLng = new LatLng(36.62731438736138, 127.4605258575477);
                    googleMap.setMinZoomPreference(6.0f);
                    googleMap.setMaxZoomPreference(18.0f);
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(36.62724140000011, 127.45646389999949),15));

                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(new LatLng(36.62731438736138, 127.4605258575477));
                    markerOptions.title("스포츠센터");


                    BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.drawable.wang1);
                    Bitmap b=bitmapdraw.getBitmap();
                    Bitmap smallMarker = Bitmap.createScaledBitmap(b,100, 100, false);
                    markerOptions  .icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
                    googleMap.addMarker(markerOptions);

                }
            });
        }

        // R.id.map is a FrameLayout, not a Fragment
        getChildFragmentManager().beginTransaction().replace(R.id.map, mapFragment).commit();


        return view;
    }









}