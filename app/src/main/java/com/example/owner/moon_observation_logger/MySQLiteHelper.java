package com.example.owner.moon_observation_logger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * MySQLiteHelper()
 * This class performs database actions such as creating a table
 * and upgrading to a current version if applicable
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    //Table name
    public static final String TABLE_LOG = "logs";
    //Database name
    private static final String DATABASE_NAME = "logs.db";
    //This is the version number
    private static final int DATABASE_VERSION = 1;

    //Columns of the table
    public static final String COLUMN_ID="id";
    public static final String COLUMN_DATE="date";
    public static final String COLUMN_TIME="time";
    public static final String COLUMN_LATITUDE="latitude";
    public static final String COLUMN_LONGITUDE="longitude";
    public static final String COLUMN_LOCATION="location";
    public static final String COLUMN_OBJECT_NAME="object_name";

    /**
     * Create TABLE
     *
     * This is the SQL statement required to create the empty table
     */
    private static final String DATABASE_CREATE = String.format(
                    "Create TABLE %s( " +
                            "%sinteger primary key autoincrement, " +
                            "%s text not null,%s text not null," +
                            "%s text not null,%s text not null," +
                            "%s text not null,%s text not null," +
                            "%s text not null,);",
                    TABLE_LOG,
                    COLUMN_ID,
                    COLUMN_DATE,
                    COLUMN_TIME,
                    COLUMN_LATITUDE,
                    COLUMN_LONGITUDE,
                    COLUMN_LOCATION,
                    COLUMN_OBJECT_NAME);

//    private static MySQLiteHelper sInstance;
//    public static synchronized MySQLiteHelper getInstance(Context context) {
//
//        // Use the application context, which will ensure that you
//        // don't accidentally leak an Activity's context.
//        // See this article for more information: http://bit.ly/6LRzfx
//        if (sInstance == null) {
//            sInstance = new MySQLiteHelper(context.getApplicationContext());
//        }
//        return sInstance;
//    }

    /**
     * MySQLiteHelper()
     * This method calls the MySQLiteOpenHelper() constructor
     * @param context
     */
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * The method executes the creation of a database
     * @param database
     */
    @Override
    public void onCreate(SQLiteDatabase database) {

        database.execSQL(DATABASE_CREATE);
    }

    /**
     * Upon an upgrade, this method performs the task of dropping the old table
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOG);
        onCreate(db);
    }

}
