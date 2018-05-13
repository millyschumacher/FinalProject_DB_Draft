package com.example.owner.moon_observation_logger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Amelia Schumacher
 * This is the datafile for the moon logs
 */

public class MoonDataSource {

    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    private List<Moon> moonList;
    public List<Moon> getMoonList() {
        return moonList;
    }


    public MoonDataSource(Context context){
        dbHelper=new MySQLiteHelper(context);
        open();
        moonList = getAllLogs();
    }

    /**
     *
     * @throws SQLException
     */
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {

        dbHelper.close();
    }

    /**
     *
     * @param date
     * @param time
     * @param latitude
     * @param longitude
     * @param location
     * @param object_name
     * @return
     */
    public Moon createLog(String date, String time, String latitude, String longitude, String location, String object_name) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_DATE, date);
        values.put(MySQLiteHelper.COLUMN_TIME, time);
        values.put(MySQLiteHelper.COLUMN_LATITUDE, latitude);
        values.put(MySQLiteHelper.COLUMN_LONGITUDE, longitude);
        values.put(MySQLiteHelper.COLUMN_LOCATION, location);
        values.put(MySQLiteHelper.COLUMN_OBJECT_NAME, object_name);

        //This is an insert statement to put the new moon log into the table
        long insertId = database.insert(MySQLiteHelper.TABLE_LOG, null, values);
        Moon newLog = new Moon(insertId, date, time, latitude, longitude, location, object_name);
        moonList.add(newLog);
        return newLog;
    }

    /**
     *
     * @param log
     */
    public void deleteLog(Moon log) {
        long id=log.getId();
        database.delete(MySQLiteHelper.TABLE_LOG, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    private Moon cursorToLog(Cursor cursor) {
        Moon log=new Moon();
        log.setId(cursor.getLong(cursor.getColumnIndex(MySQLiteHelper.COLUMN_ID)));
        log.setDate(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_DATE)));
        log.setTime(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_TIME)));
        log.setLatitude(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_LATITUDE)));
        log.setLongitude(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_LONGITUDE)));
        log.setLocation(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_LOCATION)));
        log.setObject_name(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_OBJECT_NAME)));
        return log;
    }


    public List<Moon>getAllLogs() {
        List<Moon>logList=new ArrayList<Moon>();
        Cursor cursor = database.query(MySQLiteHelper.TABLE_LOG, null, null,
                null, null, null, null, null);
        //A while loop is used to go through a potentially unknown number of comments
        //As long as the cursor isn't the last column, this will go through
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Moon log = cursorToLog(cursor);
            logList.add(log);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return logList;
    }
}
