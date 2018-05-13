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
    EditText etDate, etTime, etLatitude, etLongitude, etLocation, etObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs_detail);

        Bundle bundle = getIntent().getExtras();
        Moon moon = (Moon) bundle.getSerializable(MainActivity.MOON_OBSERVATION_KEY);

        //Connects the variables to the string values in the XML file
        etDate=(EditText)findViewById(R.id.etDate);
        etTime=(EditText)findViewById(R.id.etTime);
        etLatitude=(EditText)findViewById(R.id.etLatitude);
        etLongitude=(EditText)findViewById(R.id.etLongitude);
        etObject=(EditText)findViewById(R.id.etObject);
        btnBack=(Button)findViewById(R.id.buttonBack);

        //This calls the methods in the Moon file for each variable
        etDate.setText(moon.getDate());
        etTime.setText(moon.getTime());
        etLatitude.setText(moon.getLatitude());
        etLongitude.setText(moon.getLongitude());
        etObject.setText(moon.getObject_name());

        //The button listener detects if the user wants to go back to the main screen
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent backToMainIntent=new Intent(v.getContext(),MainActivity.class);
                finish();
                startActivity(backToMainIntent);
            }
        });

    }
}
