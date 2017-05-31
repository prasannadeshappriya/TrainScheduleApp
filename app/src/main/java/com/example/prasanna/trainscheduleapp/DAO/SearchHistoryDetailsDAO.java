package com.example.prasanna.trainscheduleapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.prasanna.trainscheduleapp.Models.TrainSchedule;
import com.example.prasanna.trainscheduleapp.Utilities.CompareTime;
import com.example.prasanna.trainscheduleapp.Utilities.Constants;

import java.util.ArrayList;

/**
 * Created by prasanna on 5/31/17.
 */

public class SearchHistoryDetailsDAO extends DAO{
    private Context context;
    private String tableName = "search_history_details";
    private String command;

    public SearchHistoryDetailsDAO(Context context) {
        super(context);
        this.context = context;
    }

    private void printLog(String message){
        Log.i(Constants.TAG,"[SearchHistoryDetailsDAO] " + message);
    }

    public boolean isHistoryDetailsExist(Long search_id){
        command = "SELECT * FROM " + tableName + " WHERE search_id=\"" + String.valueOf(search_id) + "\";";
        printLog("Check for train History detail availability :- " + command);
        Cursor c = sqldb.rawQuery(command,null);
        if(c.getCount()>0){
            c.close();
            return true;
        }else{
            c.close();
            return false;
        }
    }

    public void addSearchHistoryDetails(TrainSchedule schedule, Long search_id){
        ContentValues contentValues = new ContentValues();
        contentValues.put("search_id",String.valueOf(search_id));
        contentValues.put("train_name",schedule.getName());
        contentValues.put("train_arrival",schedule.getArrival());
        contentValues.put("train_destination",schedule.getDestination());
        contentValues.put("train_type",schedule.getType());
        contentValues.put("train_number",schedule.getNumber());
        contentValues.put("train_description",schedule.getDescription());
        contentValues.put("train_end",schedule.getEnd());
        sqldb.insert(
                tableName, null, contentValues
        );
    }

    public ArrayList<TrainSchedule> getTrainScheduleArray(Long search_id){
        command = "SELECT * FROM " + tableName + " WHERE search_id=\"" + String.valueOf(search_id) + "\";";
        printLog("Query[getTrainScheduleArray] :- " + command);
        Cursor c = sqldb.rawQuery(command,null);
        printLog("Cursor count [getTrainScheduleArray] :- " + c.getCount());

        ArrayList<TrainSchedule> arrTrainStations = new ArrayList<>();
        if(c.moveToFirst()) {
            do {
                arrTrainStations.add(
                        new TrainSchedule(
                                c.getString(c.getColumnIndex("train_number")),
                                c.getString(c.getColumnIndex("train_arrival")),
                                c.getString(c.getColumnIndex("train_end")),
                                c.getString(c.getColumnIndex("train_destination")),
                                c.getString(c.getColumnIndex("train_type")),
                                c.getString(c.getColumnIndex("train_name")),
                                c.getString(c.getColumnIndex("train_description"))
                        ));
            } while (c.moveToNext());
        }
        return arrTrainStations;
    }

    public ArrayList<TrainSchedule> getFilteredTrainScheduleArray(Long search_id, String fromTime){
        command = "SELECT * FROM " + tableName + " WHERE search_id=\"" + String.valueOf(search_id) + "\";";
        printLog("Query[getTrainScheduleArray] :- " + command);
        Cursor c = sqldb.rawQuery(command,null);
        printLog("Cursor count [getTrainScheduleArray] :- " + c.getCount());

        ArrayList<TrainSchedule> arrTrainStations = new ArrayList<>();
        if(c.moveToFirst()) {
            do {
                if(CompareTime.compareTime(c.getString(c.getColumnIndex("train_arrival")),fromTime)) {
                    arrTrainStations.add(
                            new TrainSchedule(
                                    c.getString(c.getColumnIndex("train_number")),
                                    c.getString(c.getColumnIndex("train_arrival")),
                                    c.getString(c.getColumnIndex("train_end")),
                                    c.getString(c.getColumnIndex("train_destination")),
                                    c.getString(c.getColumnIndex("train_type")),
                                    c.getString(c.getColumnIndex("train_name")),
                                    c.getString(c.getColumnIndex("train_description"))
                            ));
                }
            } while (c.moveToNext());
        }
        return arrTrainStations;
    }
}
