package com.example.owner.moon_observation_logger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 *
 */
public class LogsDetailActivity extends AppCompatActivity {

    Button btnBack;
    MoonDataSource moonDataSource;
    EditText etDate, etTime, etLatitude, etLongitude, etLocation, etObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs_detail);
    }

    Bundle bundle = getIntent().getExtras();
    Moon moon=(Moon)bundle.getSerializable("Moon");



}
