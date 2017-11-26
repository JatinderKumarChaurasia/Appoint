package com.example.jatinderkumar.appoint;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Jatinder Kumar on 22-11-2017.
 */

public class DisplayScreen extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_info);


        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String display = preferences.getString("display", "");


        TextView displayInfo = (TextView) findViewById(R.id.textViewName);
        displayInfo.setText(display);
    }
}
