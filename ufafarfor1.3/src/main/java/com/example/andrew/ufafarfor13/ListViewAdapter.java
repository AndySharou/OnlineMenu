package com.example.andrew.ufafarfor13;

/**
 * Created by Andrew on 12.09.2016.
 */

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
    //ArrayList<HashMap<String, String>> data;
    ArrayList<Offer> data;
    ImageLoader imageLoader;
    //HashMap<String, String> resultp = new HashMap<String, String>();
    Offer offer = new Offer();
    String category = "";



    //public ListViewAdapter(Context context, ArrayList<HashMap<String, String>> arraylist) {
    public ListViewAdapter(Context context, ArrayList<Offer> offerlist) {

        this.context = context;
        data = offerlist;
        imageLoader = new ImageLoader(context);

        //Log.i("category = ", category);

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
        TextView description;
        ImageView picture;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.listviewitem, parent, false);


        // Get the position

        offer = data.get(position);
        //resultp = data.get();
        // Locate the TextViews in listview_item.xml
        name = (TextView) itemView.findViewById(R.id.name);
        price = (TextView) itemView.findViewById(R.id.price);
        weight = (TextView) itemView.findViewById(R.id.weight);
        //description = (TextView) itemView.findViewById(R.id.description);
        // Locate the ImageView in listview_item.xml
        picture = (ImageView) itemView.findViewById(R.id.picture);

        // Capture position and set results to the TextViews
        name.setText(offer.getName());
        //price.setText(resultp.get("price"));
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
        //weight.setText(resultp.get(Sets.PARAM));
        //description.setText(resultp.get(Sets.DESCRIPTION));
        // Capture position and set results to the ImageView
        // Passes images URL into ImageLoader.class
        //imageLoader.DisplayImage(resultp.get("picture"), picture);
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
                //intent.putExtra("name", resultp.get(Sets.NAME));
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
