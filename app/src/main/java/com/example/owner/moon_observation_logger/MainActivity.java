package com.example.owner.moon_observation_logger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    MoonDataSource moonDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       moonDataSource=new MoonDataSource();
       moonDataSource.open();

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
