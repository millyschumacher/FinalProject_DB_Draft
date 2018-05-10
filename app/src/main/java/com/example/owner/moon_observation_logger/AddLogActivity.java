package com.example.owner.moon_observation_logger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddLogActivity extends AppCompatActivity {

    EditText etDate, etTime, etLatitude, etLongitude, etLocation, etObject_Name;
    Button btnSave;
    MoonDataSource moonDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_log);

        moonDataSource = new MoonDataSource(this);
        moonDataSource.open();

        etDate = (EditText) findViewById(R.id.etDate);
        etTime = (EditText) findViewById(R.id.etTime);
        etLatitude = (EditText) findViewById(R.id.etLatitude);
        etLongitude = (EditText) findViewById(R.id.etLongitude);
        etLatitude = (EditText) findViewById(R.id.etLocation);
        etLatitude = (EditText) findViewById(R.id.etObject);


        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String date = etDate.getText().toString();
                String time = etTime.getText().toString();
                String latitude = etLatitude.getText().toString();
                String longitude = etLongitude.getText().toString();
                String location = etLocation.getText().toString();
                String object_name = etObject_Name.getText().toString();
                moonDataSource.createLog(date, time, latitude, longitude, location, object_name);
                Intent toMainIntent = new Intent(view.getContext(), MainActivity.class);
                finish();
                startActivity(toMainIntent);
            }
        });

    }

    @Override
    protected void onResume() {
        moonDataSource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        moonDataSource.close();
        super.onPause();
    }
}
