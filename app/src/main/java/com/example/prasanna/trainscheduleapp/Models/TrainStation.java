package com.example.prasanna.trainscheduleapp.Models;

/**
 * Created by prasanna on 5/30/17.
 */

public class TrainStation {
    private long id;
    private String stationName;
    private String stationID;
    private String stationCode;

    public TrainStation(long id, String stationID, String stationName) {
        this.id = id;
        this.stationID = stationID;
        this.stationName = stationName;
    }

    public TrainStation(String stationID, String stationName, String stationCode) {
        this.stationID = stationID;
        this.stationName = stationName;
        this.stationCode = stationCode;
    }

    public TrainStation(String stationID, String stationName) {
        this.stationID = stationID;
        this.stationName = stationName;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
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
