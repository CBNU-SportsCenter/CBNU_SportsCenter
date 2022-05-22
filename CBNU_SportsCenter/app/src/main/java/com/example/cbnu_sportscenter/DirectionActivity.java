package com.example.cbnu_sportscenter;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class DirectionActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    MapFragment mapFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);

        mapFrag= (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFrag.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map){
        gMap = map;
        gMap.setMinZoomPreference(6.0f);   //최소 줌 크기 설정
        gMap.setMaxZoomPreference(14.0f);  //최대 줌 크기 설정
        gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(36.62724140000011, 127.45646389999949),15));


        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(36.62731438736138, 127.4605258575477));
        markerOptions.title("스포츠센터");


        BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.drawable.wang1);
        Bitmap b=bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b,90, 90, false);
        markerOptions  .icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        gMap.addMarker(markerOptions);


    }






}