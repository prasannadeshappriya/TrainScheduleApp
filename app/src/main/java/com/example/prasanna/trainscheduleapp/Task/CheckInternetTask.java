package com.example.prasanna.trainscheduleapp.Task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.example.prasanna.trainscheduleapp.DAO.SearchHistoryDAO;
import com.example.prasanna.trainscheduleapp.DAO.SearchHistoryDetailsDAO;
import com.example.prasanna.trainscheduleapp.DAO.TrainStationDAO;
import com.example.prasanna.trainscheduleapp.Fragment.TrainScheduleFragment;
import com.example.prasanna.trainscheduleapp.Models.TrainSchedule;
import com.example.prasanna.trainscheduleapp.Utilities.Constants;

import java.util.ArrayList;

/**
 * Created by prasanna on 5/31/17.
 */

public class CheckInternetTask extends Task {

    private boolean con = false;
    private String fromStationCode;
    private String toStationCode;
    private String startTime;
    private String endTime;
    private String currentDate;
    private ArrayList<TrainSchedule> arrTrainSchedle;
    private TrainScheduleFragment fragment;
    private String fromStationName;
    private SearchHistoryDAO historyDAO;
    private SearchHistoryDetailsDAO historyDetailsDAO;
    private TrainStationDAO stationDAO;
    private boolean isRequiredFiltered;

    public CheckInternetTask(Context _context, ProgressDialog _pd,
                            String fromStationCode,
                            String toStationCode,
                            String startTime,
                            String endTime,
                            String currentDate,
                            TrainScheduleFragment fragment,
                            String fromStationName, boolean isRequiredFiltered){
        super(_context, _pd);
        this.fromStationCode = fromStationCode;
        this.toStationCode = toStationCode;
        this.startTime = startTime;
        this.endTime = endTime;
        this.currentDate = currentDate;
        this.fragment = fragment;
        this.fromStationName = fromStationName;
        this.isRequiredFiltered = isRequiredFiltered;
    }

    @Override
    protected void onPreExecute() {
        historyDAO = new SearchHistoryDAO(context);
        historyDetailsDAO = new SearchHistoryDetailsDAO(context);
        stationDAO = new TrainStationDAO(context);
        pd.setIndeterminate(true);
        pd.setCanceledOnTouchOutside(false);
        pd.setMessage("Connecting");
        pd.show();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if(con) {
            GetScheduleTask sheduleTask = new GetScheduleTask(
                    context,pd,
                    fromStationCode,toStationCode,
                    startTime, endTime,
                    currentDate, fragment,
                    fromStationName, isRequiredFiltered
            );
            sheduleTask.execute();
        }else{
            printLog("No internet connection available, loading offline details");
            String  fromStationName = stationDAO.getTrainStationName(fromStationCode);
            String toStationName = stationDAO.getTrainStationName(toStationCode);
            Long id = historyDAO.getID(fromStationName, toStationName);
            if(isRequiredFiltered){
                arrTrainSchedle = historyDetailsDAO.getFilteredTrainScheduleArray(id,startTime);
            }else {
                arrTrainSchedle = historyDetailsDAO.getTrainScheduleArray(id);
            }
            fragment.viewTrainScheduleFragment(arrTrainSchedle, false);
            pd.dismiss();
        }
    }

    @Override
    protected Void doInBackground(Void... params) {
        //Ping is not working for emulator
        //Check weather the app is running on emulator or not
        if(Build.PRODUCT.matches(".*_?sdk_?.*")){
            con = true;
        }else {
            Runtime runtime = Runtime.getRuntime();
            try {
                Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
                int exitValue = ipProcess.waitFor();
                con = (exitValue == 0);
            } catch (Exception e) {
                printLog("Error :- " + e.toString());
                con = false;
            }
        }
        return null;
    }

    private void printLog(String message){
        Log.i(Constants.TAG,"[CheckInternetTask] " + message);
    }
}
