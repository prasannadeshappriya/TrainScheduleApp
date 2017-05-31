package com.example.prasanna.trainscheduleapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.prasanna.trainscheduleapp.Models.TrainHistory;
import com.example.prasanna.trainscheduleapp.Models.TrainSchedule;
import com.example.prasanna.trainscheduleapp.Utilities.Constants;

import java.util.ArrayList;

/**
 * Created by prasanna on 5/31/17.
 */

public class SearchHistoryDAO extends DAO {
    private Context context;
    private String tableName = "search_history";
    private String command;

    public SearchHistoryDAO(Context context) {
        super(context);
        this.context = context;
    }

    private void printLog(String message){
        Log.i(Constants.TAG,"[SearchHistoryDAO] " + message);
    }

    public long getID(String fromStation, String toStation){
        command = "SELECT id FROM " + tableName + " WHERE start_station=\"" + fromStation + "\" AND end_station=\"" + toStation + "\";";
        printLog("Query[getID] :- " + command);
        Cursor c = sqldb.rawQuery(command,null);
        printLog("Cursor count [getID] :- " + c.getCount());

        if(c.moveToFirst()) {
            do {
                return Long.parseLong(c.getString(c.getColumnIndex("id")));
            } while (c.moveToNext());
        }
        return 0;
    }

    public boolean isHistoryNull(){
        command = "SELECT * FROM " + tableName + " WHERE 1;";
        printLog("Check for train History null :- " + command);
        Cursor c = sqldb.rawQuery(command,null);
        if(c.getCount()>0){
            c.close();
            return false;
        }else{
            c.close();
            return true;
        }
    }

    public boolean isHistoryExist(String fromStation, String toStation){
        command = "SELECT * FROM " + tableName + " WHERE start_station=\"" + fromStation + "\" AND end_station=\"" + toStation + "\";";
        printLog("Check for train History availability :- " + command);
        Cursor c = sqldb.rawQuery(command,null);
        if(c.getCount()>0){
            c.close();
            return true;
        }else{
            c.close();
            return false;
        }
    }

    public Long addSearchHistory(String fromStation, String toStation){
        ContentValues contentValues = new ContentValues();
        contentValues.put("start_station",fromStation);
        contentValues.put("end_station",toStation);
        sqldb.insert(
                tableName, null, contentValues
        );
        return getID(fromStation,toStation);
    }

    public ArrayList<TrainHistory> getTrainHistoryArray(){
        command = "SELECT * FROM " + tableName + " WHERE 1;";
        printLog("Query[getTrainHistoryArray] :- " + command);
        Cursor c = sqldb.rawQuery(command,null);
        printLog("Cursor count [getTrainHistoryArray] :- " + c.getCount());

        ArrayList<TrainHistory> arrTrainHistory = new ArrayList<>();
        if(c.moveToFirst()) {
            do {
                arrTrainHistory.add(
                        new TrainHistory(
                                c.getString(c.getColumnIndex("start_station")),
                                c.getString(c.getColumnIndex("end_station"))
                        ));
            } while (c.moveToNext());
        }
        return arrTrainHistory;
    }
}
