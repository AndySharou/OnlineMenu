package com.example.andrew.ufafarfor13;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static com.google.android.gms.wearable.DataMap.TAG;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CafeViewHolder> {

    private AdapterShowOnMap listener;

    public  interface AdapterShowOnMap {
        void initialShowOnMap();
    }


    public static class CafeViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView cafeName;
        TextView cafeAddress;
        String cafeLatlng;
        TextView cafeTelLandLine;
        TextView cafeTelVel;
        TextView cafeTelMts;
        TextView cafeWorkHours;
        ImageView cafePhoto;
        Button btnShowOnMap;
        String categoryId = "";
        private Context mContext;
        private static final String TAG = "myLogs";



        CafeViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            cafeName = (TextView)itemView.findViewById(R.id.cafe_name);
            cafeAddress = (TextView)itemView.findViewById(R.id.cafe_adr);
            cafeTelLandLine = (TextView)itemView.findViewById(R.id.cafe_tel_land_line);
            cafeTelVel = (TextView)itemView.findViewById(R.id.cafe_tel_vel);
            cafeTelMts = (TextView)itemView.findViewById(R.id.cafe_tel_mts);
            cafeWorkHours = (TextView)itemView.findViewById(R.id.cafe_working_hours);
            cafePhoto = (ImageView)itemView.findViewById(R.id.cafe_photo);
            btnShowOnMap = (Button)itemView.findViewById(R.id.btnShowOnMap);
        }
    }

    List<Cafe> cafes;

    public RVAdapter(List<Cafe> cafes, Context context){
        this.cafes = cafes;
        try {
            this.listener = ((AdapterShowOnMap) context);
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement AdapterShowOnMap.");
        }

    }

    /*public RVAdapter(AdapterShowOnMap listener){
        this.listener = listener;
    }*/

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public CafeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_4_bottom_sheet, viewGroup, false);
        CafeViewHolder cvh = new CafeViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(final CafeViewHolder cafeViewHolder, int i) {
        cafeViewHolder.cafeName.setText(cafes.get(i).name);
        cafeViewHolder.cafeAddress.setText(cafes.get(i).address);
        cafeViewHolder.cafeLatlng = (cafes.get(i).cafeLatlng);
        cafeViewHolder.cafeTelLandLine.setText(cafes.get(i).telLandLine);
        cafeViewHolder.cafeTelVel.setText(cafes.get(i).telVel);
        cafeViewHolder.cafeTelMts.setText(cafes.get(i).telMts);
        cafeViewHolder.cafeWorkHours.setText(cafes.get(i).workHours);
        cafeViewHolder.cafePhoto.setImageResource(cafes.get(i).photoId);
        cafeViewHolder.btnShowOnMap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Log.i("Button pushed1", cafeViewHolder.cafeLatlng);
                //String Temp = cafeViewHolder.cafeLatlng;
                Intent showOnMap = new Intent(v.getContext(), MapsActivity.class);
                showOnMap.putExtra("cafeLatlng", cafeViewHolder.cafeLatlng);
                //showOnMap.putExtra("justToCheck", String.valueOf(cafeViewHolder.cafeName));
                Log.i("Button pushed2", cafeViewHolder.cafeLatlng);
                //Log.i("Button here is Temp", cafeViewHolder.cafeLatlng);
                v.getContext().startActivity(showOnMap);

                try {
                    listener.initialShowOnMap();
                } catch (ClassCastException exception) {
                    // do something
                    Log.i(TAG, "чот не работает");
                }


                /*if(mContext instanceof MapsActivity){
                    ((MapsActivity)mContext).initialShowOnMap();
                }*/



            }
        });
    }



    @Override
    public int getItemCount() {
        return cafes.size();
    }



}