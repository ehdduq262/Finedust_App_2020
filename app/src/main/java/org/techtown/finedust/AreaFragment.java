package org.techtown.finedust;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.TrafficStats;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.LatLng;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import org.techtown.finedust.MainActivity;

import static android.content.Intent.getIntent;


public class AreaFragment extends Fragment implements OnMapReadyCallback{

    GoogleMap map;
    SupportMapFragment mapFragment;
    MainActivity sender = new MainActivity();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup ar_view = (ViewGroup) inflater.inflate(R.layout.area_dust,container,false);

        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
        sender.getData();
        return ar_view;
    }

    @Override //구글맵을 띄울준비가 됬으면 자동호출된다.
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        //지도타입 - 일반
        MarkerOptions makerOptions = new MarkerOptions();
        //마커 옵션 추가
        makerOptions.position(new LatLng( 35.126632, 128.992852)).title("학장동" ); // 타이틀.
        map.addMarker(makerOptions);

        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @SuppressLint("SetTextI18n")
            @Override
            public View getInfoContents(Marker marker) {

                View v = getLayoutInflater().inflate(R.layout.marker, null);

                TextView info1= (TextView) v.findViewById(R.id.info1);

                info1.setText(sender.hInfo);

                return v;
            }
        });


        makerOptions.position(new LatLng( 35.226888, 129.207371)).title("기장읍" );
        map.addMarker(makerOptions);
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker arg1) {
                return null;
            }

            @SuppressLint("SetTextI18n")
            @Override
            public View getInfoContents(Marker marker) {

                View v = getLayoutInflater().inflate(R.layout.marker, null);

                TextView info2= (TextView) v.findViewById(R.id.info2);

                info2.setText(sender.kInfo);

                return v;
            }
        });


        makerOptions.position(new LatLng(35.100451, 129.032828)).title("광복동" );
        map.addMarker(makerOptions);
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker arg3) {
                return null;
            }

            @SuppressLint("SetTextI18n")
            @Override
            public View getInfoContents(Marker marker) {

                View v = getLayoutInflater().inflate(R.layout.marker, null);

                TextView info3= (TextView) v.findViewById(R.id.info3);

                info3.setText(sender.gInfo);

                return v;
            }
        });


        makerOptions.position(new LatLng(35.217284, 129.015343)).title("덕천동" );
        map.addMarker(makerOptions);
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker arg4) {
                return null;
            }

            @SuppressLint("SetTextI18n")
            @Override
            public View getInfoContents(Marker marker) {

                View v = getLayoutInflater().inflate(R.layout.marker, null);

                TextView info4= (TextView) v.findViewById(R.id.info4);

                info4.setText(sender.dInfo);

                return v;
            }
        });


        makerOptions.position(new LatLng(35.074854, 128.968088)).title("장림동" );
        map.addMarker(makerOptions);
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @SuppressLint("SetTextI18n")
            @Override
            public View getInfoContents(Marker marker) {

                View v = getLayoutInflater().inflate(R.layout.marker2, null);

                TextView info5= (TextView) v.findViewById(R.id.info);

                info5.setText(sender.jInfo);

                return v;
            }
        });



        map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(35.1758354,129.0878155)));
        map.animateCamera(CameraUpdateFactory.zoomTo(11));
    }


}
