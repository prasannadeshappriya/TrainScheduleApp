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

    //Feedback Server Constants
    public static final String SERVER_TOKEN = "sd832onsas9d1n23ld2ffwefwefcwfadlsnnio21dNEJNOCFOIEWOFJOIJOQIEWJFQ8156516516!@#@$@#%^$l23n4l23";
    public static final String SERVER_HOST_URL = "http://train-schedule-v10.herokuapp.com/train_schedule_feedback";
    public static final String SERVER_LOCAL_URL = "http://10.0.2.2:8000/train_schedule_feedback";

    //Fragment Tag names
    public static final String FRAGMENT_TRAIN_SCHEDULE = "train_schedule";
    public static final String FRAGMENT_FEEDBACK = "feedback";
    public static final String FRAGMENT_TRAIN_SCHEDULE_VIEW = "train_schedule_view";
}
