package com.example.prasanna.trainscheduleapp.Models;

/**
 * Created by prasanna on 5/31/17.
 */

public class TrainHistory {
    private long id;
    private String startStation;
    private String endStation;

    public TrainHistory(long id, String startStation, String endStation) {
        this.id = id;
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public TrainHistory(String startStation, String endStation) {
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }
}
