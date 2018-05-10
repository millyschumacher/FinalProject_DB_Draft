package com.example.owner.moon_observation_logger;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
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

    private final Context context;
    private List<Moon> moonList;
    private int rowLayout;


    /**
     *
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
     *
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

        TextView tvDate=(TextView)view.findViewById(R.id.tvDate);
        TextView tvTime=(TextView)view.findViewById(R.id.tvTime);
        TextView tvLatitude=(TextView)view.findViewById(R.id.tvLatitude);
        TextView tvLongitude=(TextView)view.findViewById(R.id.tvLongitude);
        TextView tvLocation=(TextView)view.findViewById(R.id.tvLocation);
        TextView tvObject=(TextView)view.findViewById(R.id.tvObject);
        tvDate.setText(moon.getDate());
        tvTime.setText(moon.getTime());
        tvLatitude.setText(moon.getLatitude());
        tvLongitude.setText(moon.getLongitude());
        tvLocation.setText(moon.getLocation());
        tvObject.setText(moon.getObject_name());

        return(view);
    }

}