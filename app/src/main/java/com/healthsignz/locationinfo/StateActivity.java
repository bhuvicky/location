package com.healthsignz.locationinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StateActivity extends AppCompatActivity {
    Spinner spinner;
    String[] indianStates= {"Hariyana","Rajesthan","Bihar","Orissa"};
    String[] pakistanStates = {"Aazad J&K","Sindh","Capital Territory Islamabad","Punjab"};
    String[] americanStates = {"Alaska","California","New York","Washington"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);
        Intent stateIntent = getIntent();
        String countryName = stateIntent.getStringExtra("CountrySelected");
        spinner = (Spinner)findViewById(R.id.spinner_state);
        setSpinnerValues(countryName);
        Button backButton = new Button(this);
        backButton.setText("BACK");
        backButton.setHeight(15);
        backButton.setWidth(80);
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.layout_views);
        relativeLayout.addView(backButton);
    }

    private void setSpinnerValues(String countryName) {
        countryName = countryName.toLowerCase();
        List<String> stateList = new ArrayList<String>();
        switch (countryName){
            case "india"     : stateList = Arrays.asList(indianStates);break;
            case "pakistan"  : stateList = Arrays.asList(pakistanStates);break;
            case "america"  : stateList = Arrays.asList(americanStates);break;
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(StateActivity.this,android.R.layout.simple_spinner_item,stateList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }


}
