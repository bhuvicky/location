package com.healthsignz.locationinfo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class CountryActivity extends AppCompatActivity {

    Spinner mSpinnerCountryName;
    boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        mSpinnerCountryName = (Spinner) findViewById(R.id.spinner_country_name);
        mSpinnerCountryName.setBackgroundColor(Color.BLUE);
        mSpinnerCountryName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(!firstTime) {
                    String countryName = parent.getItemAtPosition(position).toString();
                    Intent countryIntent = new Intent(CountryActivity.this, StateActivity.class);
                    countryIntent.putExtra("CountrySelected", countryName);
                    startActivity(countryIntent);
                }

                firstTime = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}