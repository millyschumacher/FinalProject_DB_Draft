package com.example.owner.moon_observation_logger;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * This class sets up the display of the list of moon logs
 */
public class MoonAdapter extends ArrayAdapter<Moon> {

    //Declared fields for the list of observations
    private final Context context;
    private List<Moon> moonList;
    private int rowLayout;


    /**
     * MoonAdapter()
     *
     * A constructor to set up the display for the array list of logs
     * @param context
     * @param rowLayout
     * @param moonList
     */
    public MoonAdapter(Context context, int rowLayout, List<Moon> moonList) {
        super(context, rowLayout, moonList);
        this.context = context;
        this.moonList= moonList;
        this.rowLayout=rowLayout;
    }

    /**
     * Moon Adapter()
     *
     * Am overloaded constructor to set up the display for the logs
     * @param context
     * @param resource
     * @param tvID
     * @param moonList
     */
    public MoonAdapter(Context context, int resource, int tvID, List<Moon> moonList) {
        super(context, resource, tvID, moonList);
        this.context = context;
        this.moonList = moonList;
    }

    /**
     * getView()
     *
     * This method sets up the layout view using the XML file and connects the variables
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.moon_row_layout, null);
        Moon moon = moonList.get(position);

        TextView tvDate= view.findViewById(R.id.tvDate);
        TextView tvTime= view.findViewById(R.id.tvTime);
        TextView tvLatitude= view.findViewById(R.id.tvLatitude);
        TextView tvLongitude= view.findViewById(R.id.tvLongitude);
        TextView tvLocation= view.findViewById(R.id.tvLocation);
        TextView tvObject= view.findViewById(R.id.tvObject);
        tvDate.setText(moon.getDate());
        tvTime.setText(moon.getTime());
        tvLatitude.setText(moon.getLatitude());
        tvLongitude.setText(moon.getLongitude());
        tvLocation.setText(moon.getLocation());
        tvObject.setText(moon.getObject_name());

        return(view);
    }

}