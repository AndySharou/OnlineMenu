package com.example.andrew.ufafarfor13;



import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    ArrayList<Offer> data;
    ImageLoader imageLoader;
    Offer offer = new Offer();


    //public ListViewAdapter(Context context, ArrayList<HashMap<String, String>> arraylist) {
    public ListViewAdapter(Context context, ArrayList<Offer> offerlist) {

        this.context = context;
        data = offerlist;
        imageLoader = new ImageLoader(context);

    }

    @Override
    public int getCount() {
        //if(data.size()<=0)
          // return 1;
        return data.size();

    }

    @Override
    public Object getItem(int position) {
        //return null;
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

     public View getView(final int position, View convertView, ViewGroup parent) {
        // Declare Variables
        TextView name;
        TextView price;
        TextView weight;
        ImageView picture;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.listviewitem, parent, false);

        // Get the position
        offer = data.get(position);

        // Locate the TextViews in listview_item.xml
        name = (TextView) itemView.findViewById(R.id.name);
        price = (TextView) itemView.findViewById(R.id.price);
        weight = (TextView) itemView.findViewById(R.id.weight);

        // Locate the ImageView in listview_item.xml
        picture = (ImageView) itemView.findViewById(R.id.picture);

        // Capture position and set results to the TextViews
        name.setText(offer.getName());
        price.setText(offer.getPrice());
        try {
            weight.setText(offer.getMapParam().get("Вес"));

        } catch (Exception e) {

             //Log.e("SimpleTest", e.getMessage());

             Log.e("MY_APP_error!", "Error!", e);
             e.printStackTrace();
        }

        if (offer.getMapParam() == null) {
             weight.setText("");
        }

        // Capture position and set results to the ImageView
        // Passes images URL into ImageLoader.class

        imageLoader.DisplayImage(offer.getPicture(), picture);




        // Capture ListView item click
        itemView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Get the position
                //resultp = data.get(position);
                offer = data.get(position);
                Intent intent = new Intent(context, SingleItemView.class);
                // Pass all data name
                intent.putExtra("name", offer.getName());
                // Pass all data price
                intent.putExtra("price", offer.getPrice());
                // Pass all weight price

                if (offer.getMapParam() == null) {
                    intent.putExtra("weight", "");
                } else {
                intent.putExtra("weight", offer.getMapParam().get("Вес"));}
                // Pass all data description
                intent.putExtra("description", offer.getDescription());
                // Pass all data picture
                intent.putExtra("picture", offer.getPicture());
                // Start SingleItemView Class
                context.startActivity(intent);

            }
        });


        return itemView;

    }
}
