package com.example.andrew.ufafarfor13;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CafeViewHolder> {

    public static class CafeViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView cafeName;
        TextView cafeAddress;
        TextView cafeTelLandLine;
        TextView cafeTelVel;
        TextView cafeTelMts;
        TextView cafeWorkHours;
        ImageView cafePhoto;

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
        }
    }

    List<Cafe> cafes;

    RVAdapter(List<Cafe> cafes){
        this.cafes = cafes;
    }

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
    public void onBindViewHolder(CafeViewHolder cafeViewHolder, int i) {
        cafeViewHolder.cafeName.setText(cafes.get(i).name);
        cafeViewHolder.cafeAddress.setText(cafes.get(i).address);
        cafeViewHolder.cafeTelLandLine.setText(cafes.get(i).telLandLine);
        cafeViewHolder.cafeTelVel.setText(cafes.get(i).telVel);
        cafeViewHolder.cafeTelMts.setText(cafes.get(i).telMts);
        cafeViewHolder.cafeWorkHours.setText(cafes.get(i).workHours);
        cafeViewHolder.cafePhoto.setImageResource(cafes.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return cafes.size();
    }
}