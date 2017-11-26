package com.example.jatinderkumar.appoint;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Emergency_Call extends AppCompatActivity {
    TextView txtHospitalName,txtHospitalPhone,txtHospitalAddress;
    Button btn;
    static final int REQUEST_CODE =1;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_emergency__call );

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);


        txtHospitalName =(TextView) findViewById( R.id.txtHospitalName );
        txtHospitalAddress =(TextView) findViewById( R.id.txtAddress );
        txtHospitalPhone =(TextView) findViewById( R.id.txtPhoneNo );
        btn =(Button) findViewById( R.id.btnCall );
        final Intent intent = getIntent();

        final String Phone =intent.getStringExtra( "Phone" );
        final String name = intent.getStringExtra( "Name" );
        String Address =intent.getStringExtra( "Address" );
        txtHospitalName.setText( name );
        txtHospitalAddress.setText( Address );
        txtHospitalPhone.setText( Phone );
        txtHospitalName.setTextColor( Color.BLACK );
        txtHospitalPhone.setTextColor( Color.BLACK );
        txtHospitalAddress.setTextColor( Color.BLACK );
        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder( Emergency_Call.this );
                alertDialog.setTitle( name);
                alertDialog.setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent dialIntent = new Intent();
                        dialIntent.setAction(Intent.ACTION_CALL);
                        dialIntent.setData(Uri.parse("tel:"+Phone));
                        if(ActivityCompat.checkSelfPermission( getApplicationContext(), Manifest.permission.CALL_PHONE )!= PackageManager.PERMISSION_GRANTED)
                        {
                            ActivityCompat.requestPermissions( Emergency_Call.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CODE );
                        }
                        startActivity( dialIntent );

                    }
                } );
                alertDialog.setNegativeButton( "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                } );
                alertDialog.show();

            }
        } );


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}