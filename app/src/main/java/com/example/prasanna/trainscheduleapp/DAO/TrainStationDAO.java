package com.example.prasanna.trainscheduleapp.DAO;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;

import com.example.prasanna.trainscheduleapp.Fragment.TrainScheduleFragment;
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

    private class addTrainStations extends AsyncTask<Void,Void,Void> {
        ProgressDialog pd;
        ArrayList<TrainStation> arrTrainStations;
        TrainScheduleFragment fragment;
        addTrainStations(ProgressDialog pd, ArrayList<TrainStation> arrTrainStations,TrainScheduleFragment fragment){
            this.pd = pd;
            this.arrTrainStations = arrTrainStations;
            this.fragment = fragment;
        }
        @Override
        protected void onPreExecute() {
            printLog("Train station insert process started");
            pd.setIndeterminate(true);
            pd.setCanceledOnTouchOutside(false);
            pd.setMessage("Initializing..");
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            for(TrainStation station : arrTrainStations){
                ContentValues contentValues = new ContentValues();
                contentValues.put("station_code",station.getStationID());
                contentValues.put("station_name",station.getStationName());
                sqldb.insert(
                        tableName, null, contentValues
                );
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            pd.dismiss();
            printLog(arrTrainStations.size() + " data successfully inserted");
            printLog("Train station insert process completed");
            fragment.reInitializeObjects();
        }
    }

    public void addStations (ArrayList<TrainStation> arrTrainStations, ProgressDialog pd, TrainScheduleFragment fragment){
        addTrainStations addStationProcess = new addTrainStations(pd,arrTrainStations,fragment);
        addStationProcess.execute();
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
