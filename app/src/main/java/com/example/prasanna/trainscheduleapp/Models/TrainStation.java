package com.example.prasanna.trainscheduleapp.Models;

/**
 * Created by prasanna on 5/30/17.
 */

public class TrainStation {
    private long id;
    private String stationName;
    private String stationID;

    public TrainStation(long id, String stationID, String stationName) {
        this.id = id;
        this.stationID = stationID;
        this.stationName = stationName;
    }

    public TrainStation(String stationID, String stationName) {
        this.stationID = stationID;
        this.stationName = stationName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
