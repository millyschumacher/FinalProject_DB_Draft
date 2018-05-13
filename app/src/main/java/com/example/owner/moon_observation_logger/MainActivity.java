package com.example.owner.moon_observation_logger;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * This is the main activity that will allow a user to log data for a moon observation and
 * access the data that's previously entered. They can delete and view the logs.
 *
 * @author Reference: template from Tom Gibbons https://github.com/tgibbons-css/FishTrackerSampleProject
 * @modified Amelia Schumacher
 */

public class MainActivity extends AppCompatActivity {

    //Variables for the components and classes are declared
    MoonDataSource moonDataSource;
    Button btnDelete, btnAddLog, btnViewDetails, btnViewMoon;
    ListView lvMoon;
    ArrayAdapter<Moon> moonAdapter;
    int positionSelected;
    //This is a header for the observation logs and not for data
    TextView tvLogHeader;

    //A key to connect the serializing to the moon logs
    public static final String MOON_OBSERVATION_KEY="MOON";

    /**
     * onCreate()
     * This sets up the main activity
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moonDataSource=new MoonDataSource(this);
        moonDataSource.open();

        lvMoon = (ListView) findViewById(R.id.listvMoon);
        tvLogHeader = (TextView) findViewById(R.id.tvLogHeader);


        moonAdapter = new MoonAdapter(this, R.layout.moon_row_layout, R.id.tvDate, moonDataSource.getMoonList());
        lvMoon.setAdapter(moonAdapter);
        lvMoon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                positionSelected=position;
            }
        });

        btnAddLog = (Button) findViewById(R.id.btnAddLog);
        btnAddLog.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent addLogIntent = new Intent(view.getContext(), AddLogActivity.class);
                finish();
                startActivity(addLogIntent);

            }
        });

        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //An alert is created for this activity
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);

                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        moonDataSource.deleteLog(moonDataSource.getMoonList().get(positionSelected));
                        moonAdapter.remove(moonDataSource.getMoonList().get(positionSelected));
                        moonAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });


        btnViewDetails = (Button) findViewById(R.id.btnViewDetails);
        btnViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewDetailIntent=new Intent(v.getContext(),LogsDetailActivity.class);
                viewDetailIntent.putExtra("MOON",moonDataSource.getMoonList().get(positionSelected));
                finish();
                startActivity(viewDetailIntent);
            }
        });
    }


    /**
     *
     */
    @Override
    protected void onResume() {
        moonDataSource.open();
        moonAdapter.notifyDataSetChanged();
        super.onResume();
    }

    /**
     *
     */
    @Override
    protected void onPause() {
        moonDataSource.close();
        super.onPause();
    }
}
