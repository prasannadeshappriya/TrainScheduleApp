package com.example.prasanna.trainscheduleapp.Utilities;

import com.example.prasanna.trainscheduleapp.Models.TrainSchedule;

import java.util.ArrayList;

/**
 * Created by prasanna on 5/31/17.
 */

public abstract class SortTrainSchedule {
    public static ArrayList<TrainSchedule> sortTrainTimesAsc (ArrayList<TrainSchedule> arrTrainSchedule){
        boolean con = true;
        if(arrTrainSchedule.size()<2){
            return arrTrainSchedule;
        }
        while(con){
            con = false;
            for(int i=1; i<arrTrainSchedule.size(); i++){
                String time1 = arrTrainSchedule.get(i-1).getArrival();
                String time2 = arrTrainSchedule.get(i).getArrival();
                if(!time1.equals(time2)) {
                    if (CompareTime.compareTime(time1, time2)) {
                        con = true;
                        TrainSchedule tmp = arrTrainSchedule.get(i);
                        arrTrainSchedule.set(i, arrTrainSchedule.get(i - 1));
                        arrTrainSchedule.set(i - 1, tmp);
                    }
                }
            }
        }
        return arrTrainSchedule;
    }
}
