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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;


public class Sets extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // Declare Variables
    ListView listview;
    ListViewAdapter adapter;
    ArrayList<Offer> offerlist;
    String setsId;
    String setsName;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sets);
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

        offerlist = new ArrayList<Offer>();

        Intent isets = getIntent();
        setsId = isets.getStringExtra("category_id");
        setsName = isets.getStringExtra("sets_toolbar_name");
        getSupportActionBar().setTitle(setsName);



        try {

            for (Offer offer : Database.getInstance().getCatalog().getShop().getOffers()) {

                //Log.i("CategoryId", offer.getCategoryId());

                if (setsId.equals(offer.getCategoryId())) {

                  offerlist.add(offer);

                }

            }
        } catch ( Exception e ) {

            Log.e("MY_APP_error!", "Error!", e);
            e.printStackTrace();
        }

        // Locate the listview in activity_sets.xml
        listview = (ListView) findViewById(R.id.listview);
        // Pass the results into ListViewAdapter.java
        //adapter = new ListViewAdapter(Sets.this, arraylist);
        adapter = new ListViewAdapter(Sets.this, offerlist);
        // Binds the Adapter to the ListView
        listview.setAdapter(adapter);


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