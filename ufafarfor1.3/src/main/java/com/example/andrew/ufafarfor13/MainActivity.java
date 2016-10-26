package com.example.andrew.ufafarfor13;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import org.simpleframework.xml.core.Persister;
import java.io.Reader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    ProgressDialog mProgressDialog;
    ImageView sets;
    ImageView rolls;
    ImageView susi;
    ImageView adds;
    ImageView snacks;
    ImageView deserts;
    ImageView drinks;
    ImageView pizza;
    ImageView shashly;
    ImageView patymaker;
    ImageView lapsha;
    ImageView soup;
    ImageView salat;
    ImageView warm;
    String categoryId = "";
    String setsToolbarName = "";
    SharedPreferences sPref;
    String SAVED_DATE = "saved_date";
    boolean checkDate;
    private static final String TAG = "myLogs";
    String currentDate;
    Date currentServerDate;
    String currentServerDateStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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


        //Find current date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        currentDate = sdf.format(new Date());
        //Log.i("TAG current date", currentDate);


        //get menu updating date from Shared Preferences
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_DATE, "");

        checkDate = false;

        try {
            //get date to proper format
            currentServerDate = sdf.parse(savedText);
            //Log.i("TAG current S date", currentServerDate.toString());
            currentServerDateStr = sdf.format(currentServerDate);

            /*for (Offer offer : Database.getInstance().getCatalog().getShop().getOffers()) {
                Log.i("TAG database", offer.getName());
            }*/


            //compare current date and date of updating. if not equal = update menu
            if (currentDate.equals(currentServerDateStr) | Database.getInstance().getCatalog().getShop().getOffers() != null) {
                //Log.i("TAG date equals", currentDate + " " + currentServerDateStr);
                checkDate = true;
            } else {
                //Log.i("TAG date not equals", currentDate + " " + currentServerDateStr);

            }

        } catch (Exception e) {
            Log.i(TAG, "чот не работает");
        }


        // update menu
        if (!checkDate) {

            new DownloadXML().execute();
        }

        sets = (ImageView) findViewById(R.id.sets);
        rolls = (ImageView) findViewById(R.id.rolls);
        susi = (ImageView) findViewById(R.id.susi);
        adds = (ImageView) findViewById(R.id.adds);
        snacks = (ImageView) findViewById(R.id.snacks);
        deserts = (ImageView) findViewById(R.id.deserts);
        drinks = (ImageView) findViewById(R.id.drinks);
        pizza = (ImageView) findViewById(R.id.pizza);
        shashly = (ImageView) findViewById(R.id.shashly);
        patymaker = (ImageView) findViewById(R.id.patymaker);
        lapsha = (ImageView) findViewById(R.id.lapsha);
        soup = (ImageView) findViewById(R.id.soup);
        salat = (ImageView) findViewById(R.id.salat);
        warm = (ImageView) findViewById(R.id.warm);

        sets.setOnClickListener(this);
        rolls.setOnClickListener(this);
        susi.setOnClickListener(this);
        adds.setOnClickListener(this);
        snacks.setOnClickListener(this);
        deserts.setOnClickListener(this);
        drinks.setOnClickListener(this);
        pizza.setOnClickListener(this);
        shashly.setOnClickListener(this);
        patymaker.setOnClickListener(this);
        lapsha.setOnClickListener(this);
        soup.setOnClickListener(this);
        salat.setOnClickListener(this);
        warm.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_catalogue) {

        } else if (id == R.id.nav_contact) {

            Intent contact = new Intent(getApplicationContext(), MapsActivity.class);
            startActivity(contact);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.sets:
                categoryId = "2";
                setsToolbarName = "Сеты";
                break;
            case R.id.rolls:
                categoryId = "18";
                setsToolbarName = "Роллы";
                break;
            case R.id.susi:
                categoryId = "5";
                setsToolbarName = "Суши";
                break;
            case R.id.adds:
                categoryId = "23";
                setsToolbarName = "Добавки";
                break;
            case R.id.snacks:
                categoryId = "20";
                setsToolbarName = "Закуски";
                break;
            case R.id.deserts:
                categoryId = "10";
                setsToolbarName = "Десерты";
                break;
            case R.id.drinks:
                categoryId = "9";
                setsToolbarName = "Напитки";
                break;
            case R.id.pizza:
                categoryId = "1";
                setsToolbarName = "Пицца";
                break;
            case R.id.shashly:
                categoryId = "24";
                setsToolbarName = "Шашлыки";
                break;
            case R.id.patymaker:
                categoryId = "25";
                setsToolbarName = "Эй, диджей! Эй, битмейкер!";
                break;
            case R.id.lapsha:
                categoryId = "3";
                setsToolbarName = "Лапша";
                break;
            case R.id.soup:
                categoryId = "6";
                setsToolbarName = "Супы";
                break;
            case R.id.salat:
                categoryId = "7";
                setsToolbarName = "Салаты";
                break;
            case R.id.warm:
                categoryId = "8";
                setsToolbarName = "Тёплое";
                break;
        }


        Intent isets = new Intent(getApplicationContext(), Sets.class);
        isets.putExtra("category_id", categoryId);
        isets.putExtra("sets_toolbar_name", setsToolbarName);
        startActivity(isets);

    }

    // DownloadXML AsyncTask
    private class DownloadXML extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(MainActivity.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Loading from server");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            // Create parser
            XMLParser parser = new XMLParser();
            // Retrieve xml from the given URL address and read it
            String xml = parser.getXmlFromUrl("http://ufa.farfor.ru/getyml/?key=ukAXxeJYZN");
            Reader readerer = new StringReader(xml);
            Persister serializer = new Persister();

            try {
                Yml_Catalog yml_catalog = serializer.read(Yml_Catalog.class, readerer, false);
                Database.getInstance().setCatalog(yml_catalog);
                // for (Offer offer : Database.getInstance().getCatalog().getShop().getOffers()) {Log.i("TAG database", offer.getName()); }
                //Log.i("TAG database date", yml_catalog.getDate());

                // Find date of updating menu and wright it in Shared Preferences
                sPref = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor ed = sPref.edit();
                ed.putString(SAVED_DATE, yml_catalog.getDate());
                ed.apply();

            } catch (Exception e) {

                //Log.e("SimpleTest", e.getMessage());

                Log.e("MY_APP_error!", "Error!", e);
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void args) {

            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }
}
