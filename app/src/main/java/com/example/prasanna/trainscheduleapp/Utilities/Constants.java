package com.example.prasanna.trainscheduleapp.Utilities;

/**
 * Created by prasanna on 5/30/17.
 */

public abstract class Constants {
    //Log Tag String
    public static final String TAG = "Train-Schedule";

    //Database Constants
    public static final String DATABASE_NAME = "train_schedule";
    public static final int DATABASE_VERSION = 1;

    //WebScrapping Constants
    public static final String LANKA_GATEWAY_URL = "http://eservices.railway.gov.lk/schedule/searchTrain.action?lang=en";
    public static final String START_STATION_FORM_ID = "searchCriteria.startStationID";
    public static final String END_STATION_FORM_ID = "searchCriteria.endStationID";
    public static final String START_TIME_FORM_ID = "searchCriteria.startTime";
    public static final String END_TIME_FORM_ID = "searchCriteria.endTime";
    public static final String DATE_FORM_ID = "searchDateId";
}
