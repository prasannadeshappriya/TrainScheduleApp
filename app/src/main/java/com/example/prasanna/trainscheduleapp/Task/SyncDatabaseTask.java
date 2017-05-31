package com.example.prasanna.trainscheduleapp.Task;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.example.prasanna.trainscheduleapp.DAO.SearchHistoryDAO;
import com.example.prasanna.trainscheduleapp.DAO.SearchHistoryDetailsDAO;
import com.example.prasanna.trainscheduleapp.DAO.TrainStationDAO;
import com.example.prasanna.trainscheduleapp.Models.TrainSchedule;
import com.example.prasanna.trainscheduleapp.Utilities.CompareTime;
import com.example.prasanna.trainscheduleapp.Utilities.Constants;

import java.util.ArrayList;

/**
 * Created by prasanna on 5/31/17.
 */

public class SyncDatabaseTask extends Task {
    private ArrayList<TrainSchedule> arrTrainSchedle;
    private TrainStationDAO stationDAO;
    private SearchHistoryDAO historyDAO;
    private SearchHistoryDetailsDAO historyDetailsDAO;
    private String toCode, fromCode;
    private String toStationName, fromStationName;
    private long id;

    public SyncDatabaseTask(Context _context, ProgressDialog _pd, ArrayList<TrainSchedule> _arrTrainSchedle,
                            String _toCode, String _fromCode) {
        super(_context, _pd);
        this.arrTrainSchedle = _arrTrainSchedle;
        this.toCode = _toCode; this.fromCode = _fromCode;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        stationDAO = new TrainStationDAO(context);
        historyDAO = new SearchHistoryDAO(context);
        historyDetailsDAO = new SearchHistoryDetailsDAO(context);
        toStationName = stationDAO.getTrainStationName(toCode);
        fromStationName = stationDAO.getTrainStationName(fromCode);
        if(historyDAO.isHistoryExist(fromStationName,toStationName)){
            id = historyDAO.getID(fromStationName,toStationName);
        }else{
            id = historyDAO.addSearchHistory(fromStationName,toStationName);
        }
    }

    @Override
    protected Void doInBackground(Void... params) {
        if(historyDetailsDAO.isHistoryDetailsExist(id)){
            //Sync Details
            ArrayList<TrainSchedule> arrStoredHistry = historyDetailsDAO.getTrainScheduleArray(id);
            for(TrainSchedule schedule:arrTrainSchedle){
                boolean con = true;
                for(int i=0; i<arrStoredHistry.size();i++){
                    String a = schedule.getArrival();
                    String b = arrStoredHistry.get(i).getArrival();
                    if(CompareTime.isEqual(schedule.getArrival(),arrStoredHistry.get(i).getArrival())){
                        con = false;
                        break;
                    }
                }
                if(con) {
                    arrStoredHistry.add(schedule);
                }
            }
            historyDetailsDAO.deleteTrainHistory(id);
            for(TrainSchedule schedule:arrStoredHistry){
                historyDetailsDAO.addSearchHistoryDetails(schedule,id);
            }
        }else{
            for(TrainSchedule schedule: arrTrainSchedle){
                historyDetailsDAO.addSearchHistoryDetails(schedule,id);
            }
        }
        return super.doInBackground(params);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        printLog("Process Completed");
    }

    private void printLog(String message){
        Log.i(Constants.TAG,"[SyncDatabaseTask] " + message);
    }
}
