package com.example.prasanna.trainscheduleapp.Models;

/**
 * Created by prasanna on 4/22/17.
 */

public class TrainSchedule {
    private int id;
    private String number;
    private String arrival;
    private String end;
    private String destination;
    private String type;
    private String name;
    private String description;

    public TrainSchedule() {}

    public TrainSchedule(String number, String arrival, String end, String destination, String type, String name, String description) {
        this.number = number;
        this.arrival = arrival;
        this.end = end;
        this.destination = destination;
        this.type = type;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

