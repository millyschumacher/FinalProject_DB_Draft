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
    private long id;
    private String date;
    private String time;
    private String latitude;
    private String longitude;
    private String location;
    private String object_name;


    public Moon(String id, String date, String time, String latitude, String longitude, String location) {
    }

    /**
     *
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

    public Moon() {

    }

    /**
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public String getTime() {
        return time;
    }

    /**
     *
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     *
     * @return
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @return
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     */
    public void setLongitude(String longitude){
        this.longitude=longitude;
    }

    /**
     *
     * @return
     */
    public String getLocation(){
        return longitude;
    }

    /**
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return
     */
    public String getObject_name() {
        return object_name;
    }

    /**
     *
     * @param object_name
     */
    public void setObject_name(String object_name) {
        this.object_name = object_name;
    }


    /**
     *
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