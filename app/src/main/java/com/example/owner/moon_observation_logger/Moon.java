package com.example.owner.moon_observation_logger;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Amelia Schumacher
 * @version 5-5-18
 *
 * This class creates a log of a moon observation with all of the mandatory items for a valid log
 */

public class Moon implements Serializable {
    //Declare all of the fields
    private long id;
    private String date;
    private String time;
    private String latitude;
    private String longitude;
    private String location;
    private String object_name;


    /**
     * Moon()
     *
     * This is a constructor to set up a moon observation log
     * @param id
     * @param date
     * @param time
     * @param latitude
     * @param longitude
     * @param location
     * @param object_name
     */
    public Moon(long id, String date, String time, String latitude, String longitude, String location, String object_name) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.location = location;
        this.object_name = object_name;
    }

    /**
     * Moon()
     *
     * AN empty default constructor
     */
    public Moon() {

    }

    /**
     * A getter for the ID
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * A setter for the ID
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * A getter for the date
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * A setter for the date
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * A getter for the time
     * @return
     */
    public String getTime() {
        return time;
    }

    /**
     * A setter for the time
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * A getter for the latitude
     * @return
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * A setter for the latitude
     * @param latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * A getter for the longitude
     * @return
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * A setter for the longitude
     * @param longitude
     */
    public void setLongitude(String longitude){
        this.longitude=longitude;
    }

    /**
     * A getter for the location
     * @return
     */
    public String getLocation(){
        return longitude;
    }

    /**
     * A setter for the location
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * A getter for the object name or ID
     * @return
     */
    public String getObject_name() {
        return object_name;
    }

    /**
     * A setter for the object name or ID
     * @param object_name
     */
    public void setObject_name(String object_name) {
        this.object_name = object_name;
    }


    /**
     * toString()
     *
     * A method to return the values of the log in a string
     * @return
     */
    @Override
    public String toString() {

        return "Moon Log[" +
                "date: '" + date + '\'' +
                ", time: '" + time + '\'' +
                ", latitude: '" + latitude + '\'' +
                ", longitude: '" + longitude + '\'' +
                ", location: '" + location + '\'' +
                ", object: '" + object_name + '\'' +
                ']';
    }
}