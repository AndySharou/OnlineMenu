package com.example.andrew.ufafarfor13;

/**
 * Created by Andrew on 12.09.2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemView extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    // Declare Variables
    String name;
    String price;
    String description;
    String picture;
    String weight;

    ImageLoader imageLoader = new ImageLoader(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        Intent i = getIntent();
        // Get the result of name
        name = i.getStringExtra("name");
        // Get the result of price
        price = i.getStringExtra("price");
        // Get the result of price
        weight = i.getStringExtra("weight");
        // Get the result of description
        description = i.getStringExtra("description");
        // Get the result of picture
        picture = i.getStringExtra("picture");

        getSupportActionBar().setTitle(name);

        // Locate the TextViews in singleitemview.xml
        TextView txtname = (TextView) findViewById(R.id.name);
        TextView txtprice = (TextView) findViewById(R.id.price);
        TextView txtweight = (TextView) findViewById(R.id.weight);
        TextView txtdescription = (TextView) findViewById(R.id.description);

        // Locate the ImageView in singleitemview.xml
        ImageView imgpic = (ImageView) findViewById(R.id.picture);

        // Set results to the TextViews
        txtname.setText(name);
        txtprice.setText(price + " руб.");
        txtweight.setText(weight);
        txtdescription.setText(description);

        // Capture position and set results to the ImageView
        // Passes images URL into ImageLoader.class
        imageLoader.DisplayImage(picture, imgpic);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        } return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        //finish();

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_catalogue) {
            Intent catalogue = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(catalogue);

        } else if (id == R.id.nav_contact) {

            Intent contact = new Intent(getApplicationContext(), MapsActivity.class);
            startActivity(contact);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
