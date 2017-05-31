package com.example.prasanna.trainscheduleapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.provider.SyncStateContract;
import android.util.Log;

import com.example.prasanna.trainscheduleapp.Models.TrainStation;
import com.example.prasanna.trainscheduleapp.Utilities.Constants;

import java.util.ArrayList;

/**
 * Created by prasanna on 5/30/17.
 */

public class TrainStationDAO extends DAO {
    private Context context;
    private String tableName = "train_stations";
    private String command;

    public TrainStationDAO(Context context) {
        super(context);
        this.context = context;
    }

    public String getTrainStationID(String trainStationName){
        command = "SELECT station_code FROM " + tableName + " WHERE station_name = \"" + trainStationName + "\";";
        printLog("Query[getTrainStationID] :- " + command);
        Cursor c = sqldb.rawQuery(command,null);
        printLog("Cursor count [getTrainStationID] :- " + c.getCount());

        if(c.moveToFirst()) {
            do {
                return c.getString(c.getColumnIndex("station_code"));
            } while (c.moveToNext());
        }
        return "null";
    }

    public String getTrainStationName(String trainStationID){
        command = "SELECT station_name FROM " + tableName + " WHERE station_code = \"" + trainStationID + "\";";
        printLog("Query[getTrainStationName] :- " + command);
        Cursor c = sqldb.rawQuery(command,null);
        printLog("Cursor count [getTrainStationName] :- " + c.getCount());

        if(c.moveToFirst()) {
            do {
                return c.getString(c.getColumnIndex("station_name"));
            } while (c.moveToNext());
        }
        return "null";
    }

    private void printLog(String message){
        Log.i(Constants.TAG,"[TrainStationDAO] " + message);
    }

    public boolean isEmpty(){
        command = "SELECT * FROM " + tableName + ";";
        printLog("Check for train station table availability :- " + command);
        Cursor c = sqldb.rawQuery(command,null);
        if(c.getCount()>0){
            c.close();
            return false;
        }else{
            c.close();
            return true;
        }
    }

    private void addStation(TrainStation station){
        ContentValues contentValues = new ContentValues();
        contentValues.put("station_code",station.getStationID());
        contentValues.put("station_name",station.getStationName());
        sqldb.insert(
                tableName, null, contentValues
        );
    }

    public void addTrainStations(ArrayList<TrainStation> arrTrainStations){
        printLog("Train station insert process started");
        for(TrainStation station : arrTrainStations){
            addStation(station);
        }
        printLog(arrTrainStations.size() + " data successfully inserted");
        printLog("Train station insert process completed");
    }

    public ArrayList<String> getTrainStationNameArray(){
        command = "SELECT station_name FROM " + tableName + " WHERE 1;";
        printLog("Query[getTrainStationNameArray] :- " + command);
        Cursor c = sqldb.rawQuery(command,null);
        printLog("Cursor count [getTrainStationNameArray] :- " + c.getCount());

        ArrayList<String> arrTrainStations = new ArrayList<>();
        if(c.moveToFirst()) {
            do {
                arrTrainStations.add(
                        c.getString(c.getColumnIndex("station_name")));
            } while (c.moveToNext());
        }
        return arrTrainStations;
    }
}
