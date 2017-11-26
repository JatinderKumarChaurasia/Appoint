package com.example.jatinderkumar.appoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    private ShareActionProvider shareActionProvider;
    TextView txtIntentMainName;
    ImageView imgConsultation,imgEmergency,imgQuery,imgAppointment,imgHomeDoctor,imgMedicine;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtIntentMainName =(TextView)  findViewById( R.id.txtIntentMainName );
        imgAppointment =(ImageView) findViewById( R.id.imgAppointment );
        imgConsultation =(ImageView) findViewById( R.id.imgConsultation);
        imgEmergency =(ImageView) findViewById( R.id. imgEmergency);
        imgHomeDoctor =(ImageView) findViewById( R.id.imgHomeDoctor );
        imgMedicine =(ImageView) findViewById( R.id.imgMedicine );
        imgQuery =(ImageView) findViewById( R.id.imgQuery );
        imgEmergency.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoEmergency =new Intent( MainActivity.this,Emergency.class );
                startActivity( gotoEmergency );
            }
        } );
        drawerLayout =(DrawerLayout) findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        drawerLayout.setFocusableInTouchMode(true);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.topmenu,menu);

        MenuItem menuItem = menu.findItem(R.id.share);
        //shareActionProvider = (ShareActionProvider)MenuItemCompat.getActionProvider(menuItem);
        // setIntent("Testing Share Feature");

        return true;
    }

   /* private void setIntent(String s) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_TEXT, s);
        shareActionProvider.setShareIntent(intent);
    }
*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
