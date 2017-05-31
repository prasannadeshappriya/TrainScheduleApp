package com.example.prasanna.trainscheduleapp.Task;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.example.prasanna.trainscheduleapp.DAO.SearchHistoryDAO;
import com.example.prasanna.trainscheduleapp.DAO.SearchHistoryDetailsDAO;
import com.example.prasanna.trainscheduleapp.DAO.TrainStationDAO;
import com.example.prasanna.trainscheduleapp.Fragment.TrainScheduleFragment;
import com.example.prasanna.trainscheduleapp.Models.TrainSchedule;
import com.example.prasanna.trainscheduleapp.Utilities.Constants;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by prasanna on 5/30/17.
 */

public class GetScheduleTask extends Task {
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

    public GetScheduleTask(Context _context, ProgressDialog _pd,
                           String fromStationCode,
                           String toStationCode,
                           String startTime,
                           String endTime,
                           String currentDate,
                           TrainScheduleFragment fragment,
                           String fromStationName, boolean isRequiredFiltered) {
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
        pd.setMessage("Please wait");
        printLog("Web Scrapping started");
        arrTrainSchedle = new ArrayList<>();
        historyDAO = new SearchHistoryDAO(context);
        historyDetailsDAO = new SearchHistoryDetailsDAO(context);
        stationDAO = new TrainStationDAO(context);
    }

    @Override
    protected Void doInBackground(Void... params) {
        try{
            Document document = Jsoup.connect(Constants.LANKA_GATEWAY_URL)
                .data(Constants.START_STATION_FORM_ID, fromStationCode)
                .data(Constants.END_STATION_FORM_ID, toStationCode)
                .data(Constants.START_TIME_FORM_ID, startTime)
                .data(Constants.END_TIME_FORM_ID, endTime)
                .data(Constants.DATE_FORM_ID, currentDate)
                .method(Connection.Method.GET).get();

            for (Element table : document.select("table")) {
                TrainSchedule schedule = new TrainSchedule();
                for (Element row : table.select("tr")) {
                    Elements tds = row.select("td");

                    if(tds.size()>7) {
                        schedule.setArrival(tds.get(1).text());

                        String endTime[] = tds.get(4).text().split(" ");
                        schedule.setEnd(endTime[(endTime.length)-1]);

                        String DesTime[] = tds.get(3).text().split(" ");
                        schedule.setDestination(DesTime[0] + " ["+DesTime[(DesTime.length)-1] + "]");

                        schedule.setType(tds.get(7).text());
                        schedule.setName(tds.get(6).text());
                        schedule.setDescription(tds.get(5).text());
                    }
                    if(tds.size()>0) {
                        String tmp[] = tds.get(0).text().split(":");
                        if (tmp.length > 0) {
                            if (tmp[0].equals("Available Classes")) {
                                String trainNo[] = tds.get(2).text().split(":");
                                schedule.setNumber(trainNo[1]);
                                if(schedule!=null){
                                    arrTrainSchedle.add(schedule);
                                }
                                schedule = new TrainSchedule();
                            }
                        }
                    }

                    if(tds.size()>4 && tds.size()<7) {
                        if(fromStationName.equals(tds.get(0).text())){
                            TrainSchedule conn_schedule = new TrainSchedule();
                            conn_schedule.setNumber("");
                            conn_schedule.setArrival(tds.get(1).text());
                            conn_schedule.setEnd(tds.get(4).text());
                            conn_schedule.setDestination("");
                            conn_schedule.setType("");
                            conn_schedule.setName("");
                            conn_schedule.setDescription("");
                            arrTrainSchedle.add(conn_schedule);
                        }
                    }

                }
            }
        }catch (Exception e){
            printLog("An error occurred while scrapping website");
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        pd.dismiss();
        printLog("Web Scrapping Finished");
        if(arrTrainSchedle.isEmpty()){
            printLog("Server results empty, Loading offline details..");
            String  fromStationName = stationDAO.getTrainStationName(fromStationCode);
            String toStationName = stationDAO.getTrainStationName(toStationCode);
            Long id = historyDAO.getID(fromStationName, toStationName);
            if(isRequiredFiltered){
                arrTrainSchedle = historyDetailsDAO.getFilteredTrainScheduleArray(id,startTime);
            }else {
                arrTrainSchedle = historyDetailsDAO.getTrainScheduleArray(id);
            }
            fragment.viewTrainScheduleFragment(arrTrainSchedle, false);
        }else{
            fragment.viewTrainScheduleFragment(arrTrainSchedle, true);
            SyncDatabaseTask syncDatabaseTask = new SyncDatabaseTask(
                    context,pd,arrTrainSchedle,toStationCode,fromStationCode
            );
            syncDatabaseTask.execute();
        }
        printLog("Web Scrapping Finished");
    }

    private void printLog(String message){
        Log.i(Constants.TAG,"[GetScheduleTask] " + message);
    }
}
