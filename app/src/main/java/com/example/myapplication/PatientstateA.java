package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PatientstateA extends AppCompatActivity {

    TextView heart_value = (TextView)findViewById(R.id.heart_value);
    TextView heart_state = (TextView)findViewById(R.id.heart_state);
    TextView oxygen_value = (TextView)findViewById(R.id.oxygen_value);
    TextView oxygen_state = (TextView)findViewById(R.id.oxygen_state);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientstate_a);
    }
}