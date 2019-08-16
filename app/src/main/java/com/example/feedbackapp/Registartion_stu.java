package com.example.feedbackapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Registartion_stu extends AppCompatActivity {

    static final String[] streamArray = new String[]{"Select the Stream", "MCA", "MMS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registartion_stu);

        ArrayAdapter<String> streamsArray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, streamArray);
        streamsArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        spinner.setAdapter(streamsArray);

        spinner.setSelection(0);
    }


}