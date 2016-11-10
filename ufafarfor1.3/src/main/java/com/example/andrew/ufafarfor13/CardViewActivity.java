package com.example.andrew.ufafarfor13;

/**
 * Created by Andrew on 30.10.2016.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CardViewActivity extends AppCompatActivity {

    TextView cafeName;
    TextView cafeAddress;
    String cafeLatlng;
    TextView cafeTelLandLine;
    TextView cafeTelVel;
    TextView cafeTelMts;
    TextView cafeWorkHours;
    ImageView cafePhoto;
    Button btnShowOnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.card_view_4_bottom_sheet);

        cafeName = (TextView)findViewById(R.id.cafe_name);
        cafeAddress = (TextView)findViewById(R.id.cafe_adr);
        cafeTelLandLine = (TextView)findViewById(R.id.cafe_tel_land_line);
        cafeTelVel = (TextView)findViewById(R.id.cafe_tel_vel);
        cafeTelMts = (TextView)findViewById(R.id.cafe_tel_mts);
        cafeWorkHours = (TextView)findViewById(R.id.cafe_working_hours);
        cafePhoto = (ImageView)findViewById(R.id.cafe_photo);
        btnShowOnMap = (Button)findViewById(R.id.btnShowOnMap);

        cafeName.setText("Los Pollos Hermanos");
        cafeAddress.setText("12000 – 12100 Coors Rd SW, Albuquerque NM, 87045");
        cafeLatlng = "53.9380199,27.6620839";
        cafeTelLandLine.setText("(017) 2666666");
        cafeTelVel.setText("(029) 3666666");
        cafeTelMts.setText("(029) 5666666");
        cafeWorkHours.setText("пн-вс: 8-23");
        cafePhoto.setImageResource(R.drawable.header_ufafarfor);
        /*btnShowOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Button pushed1", cafeName.toString());
                Intent showOnMap = new Intent(v.getContext(), MapsActivity.class);
                showOnMap.putExtra("cafeLatlng", cafeLatlng);
            }
        });*/


    }
}