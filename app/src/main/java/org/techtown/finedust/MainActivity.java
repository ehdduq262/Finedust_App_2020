package org.techtown.finedust;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.TrafficStats;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.material.tabs.TabLayout;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity  {
    private  static final String TAG = "MainActivity";
    private static final int THREAD_ID = 10000;

    Toolbar toolbar;
    AreaFragment fragment1;
    MeasuredFragment fragment2;

    public String kInfo = null, jInfo = null, gInfo = null,
            hInfo = null, dInfo = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.enableDefaults();
        TrafficStats.setThreadStatsTag(THREAD_ID);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar aBar = getSupportActionBar();
        aBar.setDisplayShowTitleEnabled(false);

        fragment1 = new AreaFragment();
        fragment2 = new MeasuredFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("미세먼지 현황"));
        tabs.addTab(tabs.newTab().setText("측정된 미세먼지"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int postion = tab.getPosition();
                Log.d("MainActivity","선택된 탭 : "+ postion);
                Fragment selected = null;
                if(postion ==0){
                    selected = fragment1;
                }
                else if(postion == 1){
                    selected = fragment2;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        ActionBar ab = getSupportActionBar() ;

    }


    public void getData(){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String query = "http://apis.data.go.kr/6260000/AirQualityInfoService/getAirQualityInfoClassifiedByStation?serviceKey=rXI0krTiDJuLEcJAgJj9KNmI87z%2FBz06ZcrGbWKiS%2BRQPEj3NnWEiKxAOAN3uPvWYTQnCn0IIVXw4Tv3YHuraA%3D%3D&pageNo=1&numOfRows=5&resultCode=1&resultMsg=50&totalCount=4";

        String site = null, no2Cai = null, o3Cai = null, pm25Cai = null, repltem = null, o3 = null, repCai = null, so2Cai = null, coCai = null,
                controlnumber = null, co = null, repVal = null, no2 = null, pm10Cai = null, pm10 = null, pm25 = null, areaIndex = null;


        Boolean isSite = false, isNo2Cai = false, isO3Cai = false, isPm25Cai = false, isRepltem = false, isO3 = false, isRepCai = false,
                isSo2Cai = false, isCoCai = false, isControlnumber = false, isCo = false, isRepVal = false, isNo2 = false, isPm10Cai = false,
                isPm10 = false, isPm25 = false, isAreaIndex = false;

        try {
            String tag;
            URL url = new URL("http://apis.data.go.kr/6260000/AirQualityInfoService/getAirQualityInfoClassifiedByStation?serviceKey=rXI0krTiDJuLEcJAgJj9KNmI87z%2FBz06ZcrGbWKiS%2BRQPEj3NnWEiKxAOAN3uPvWYTQnCn0IIVXw4Tv3YHuraA%3D%3D&resultType=xml&pageNo=1&numOfRows=5&resultCode=1&resultMsg=50&totalCount=4");


            Log.d(TAG, "hello2");
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();

            XmlPullParser parser = parserCreator.newPullParser();
            Log.d(TAG, "hello3");
            parser.setInput(url.openStream(), null);
            
            Log.d(TAG, "hello4");
            int parserEvent = parser.getEventType();

            while (parserEvent != XmlPullParser.END_DOCUMENT) {
                Log.d(TAG, "hello5");
                switch (parserEvent) {
                    case XmlPullParser.START_TAG://parser가 시작 태그를 만나면
                        tag = parser.getName();
                        if(tag.equals("site")){ //title 만나면 내용을 받을수 있게 하자
                            isSite = true;
                            Log.d(TAG, "hello6");
                        }
                        if(parser.getName().equals("controlnumber")){ //title 만나면 내용을 받을수 있게 하자
                            isControlnumber = true;
                            Log.d(TAG, "hello7");
                        }
                        if(parser.getName().equals("pm25")){ //title 만나면 내용을 받을수 있게 하자
                            isPm25 = true;
                            Log.d(TAG, "hello8");
                        }
                        if(parser.getName().equals("pm25Cai")){ //title 만나면 내용을 받을수 있게 하자
                            isPm25Cai = true;
                            Log.d(TAG, "hello9");
                        }
                        if(parser.getName().equals("pm10")){ //title 만나면 내용을 받을수 있게 하자
                            isPm10 = true;
                            Log.d(TAG, "hello10");
                        }
                        if(parser.getName().equals("pm10Cai")){ //title 만나면 내용을 받을수 있게 하자
                            isPm10Cai = true;
                            Log.d(TAG, "hello11");
                        }
                        break;
                    case XmlPullParser.TEXT://parser가 내용에 접근했을때
                        if(isSite){ //isTitle이 true일 때 태그의 내용을 저장.
                            site = parser.getText().toString();
                            isSite = false;
                        }
                        if(isControlnumber){ //isAddress이 true일 때 태그의 내용을 저장.
                            controlnumber = parser.getText().toString();
                            isControlnumber = false;
                        }
                        if(isPm25){ //isMapx이 true일 때 태그의 내용을 저장.
                            pm25 = parser.getText().toString();
                            isPm25 = false;
                        }
                        if(isPm25Cai){ //isMapy이 true일 때 태그의 내용을 저장.
                            pm25Cai = parser.getText().toString();
                            isPm25Cai = false;
                        }
                        if(isPm10){ //isMapy이 true일 때 태그의 내용을 저장.
                            pm10 = parser.getText().toString();
                            isPm10Cai = false;
                        }
                        if(isPm10Cai){ //isMapy이 true일 때 태그의 내용을 저장.
                            pm10Cai = parser.getText().toString();
                            isPm10Cai = false;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if(parser.getName().equals("item")){
                            if(site.equals("기장읍")){
                                kInfo = "위치 : " + site + "\n측정 시간 :  " + controlnumber + "\npm10 수치 :  "+ pm10 +
                                        "\npm10 지수 : "+pm10Cai  + "\npm25 수치 : "+pm25  + "\npm25 지수 :"+ pm25Cai;


                            }
                            if(site.equals("장림동")){
                                jInfo = "위치 : " + site + "\n측정 시간 :  " + controlnumber + "\npm10 수치 :  "+ pm10 +
                                        "\npm10 지수 : "+pm10Cai  + "\npm25 수치 : "+pm25  + "\npm25 지수 :"+ pm25Cai;

                            }
                            if(site.equals("광복동")){
                                gInfo = "위치 : " + site + "\n측정 시간 :  " + controlnumber + "\npm10 수치 :  "+ pm10 +
                                        "\npm10 지수 : "+pm10Cai  + "\npm25 수치 : "+pm25  + "\npm25 지수 :"+ pm25Cai;

                            }
                            if(site.equals("학장동")){
                                hInfo = "위치 : " + site + "\n측정 시간 :  " + controlnumber + "\npm10 수치 :  "+ pm10 +
                                        "\npm10 지수 : "+pm10Cai  + "\npm25 수치 : "+pm25  + "\npm25 지수 :"+ pm25Cai;

                            }
                            if(site.equals("덕천동")){
                                dInfo = "위치 : " + site + "\n측정 시간 :  " + controlnumber + "\npm10 수치 :  "+ pm10 +
                                        "\npm10 지수 : "+pm10Cai  + "\npm25 수치 : "+pm25  + "\npm25 지수 :"+ pm25Cai;

                            }
                        }
                        break;

                }

                parserEvent = parser.next();

                Log.d(TAG, dInfo + "\n" + kInfo + "\n" + gInfo +"\n" + jInfo+"\n"+hInfo);
            }


        }catch(Exception e){
            e.printStackTrace();

        }

    }


}
