package com.example.owner.moon_observation_logger;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddLogActivity extends AppCompatActivity {

    EditText etDate, etTime, etLatitude, etLongitude, etLocation, etObject_Name;
    Button btnSave, btnBacktoMain;
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
        etLocation = (EditText) findViewById(R.id.etLocation);
        etObject_Name = (EditText) findViewById(R.id.etObject);

        //The save button has a two fold purpose, to save the log and catch any invalid logs the user wants to save
        btnSave = (Button) findViewById(R.id.btnSaveLog);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final String date = etDate.getText().toString();
                final String time = etTime.getText().toString();
                final String latitude = etLatitude.getText().toString();
                final String longitude = etLongitude.getText().toString();
                final String location = etLocation.getText().toString();
                final String object_name = etObject_Name.getText().toString();

                //An alert is created for this activity to catch an incomplete log
                //This is to remind the user to fill out a complete log, per The Astronomical League guidelines
                AlertDialog.Builder alert = new AlertDialog.Builder(AddLogActivity.this);
                alert.setMessage(R.string.alert_message).setTitle(R.string.alert_title);

                alert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        moonDataSource.createLog(date, time, latitude, longitude, location, object_name);
                        Intent toMainIntent = new Intent(v.getContext(), MainActivity.class);
                        finish();
                        startActivity(toMainIntent);
                    }
                });
                alert.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                alert.show();
            }
        });


        //The button listener detects if the user wants to go back to the main screen without saving a new log
        btnBacktoMain=(Button)findViewById(R.id.btnBacktoMain);
        btnBacktoMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent backToMainIntent=new Intent(v.getContext(),MainActivity.class);
                finish();
                startActivity(backToMainIntent);
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