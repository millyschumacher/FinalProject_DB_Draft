package com.example.owner.moon_observation_logger;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Amelia Schumacher
 * @version 5-5-18
 *
 * This class creates a log of a moon observation
 */

public class Moon implements Serializable {
    private Date date;
    private String phase;
    private String feature;
    private String name;


    public Moon() {
    }


    @Override
    public String toString() {
        return "Moon Log = ";
    }
}