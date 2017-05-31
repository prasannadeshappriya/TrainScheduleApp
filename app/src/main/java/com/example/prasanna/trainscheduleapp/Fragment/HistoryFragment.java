package com.example.prasanna.trainscheduleapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.prasanna.trainscheduleapp.DAO.SearchHistoryDAO;
import com.example.prasanna.trainscheduleapp.DAO.SearchHistoryDetailsDAO;
import com.example.prasanna.trainscheduleapp.ListAdapters.HistoryViewAdapter;
import com.example.prasanna.trainscheduleapp.Models.TrainHistory;
import com.example.prasanna.trainscheduleapp.Models.TrainSchedule;
import com.example.prasanna.trainscheduleapp.R;
import com.example.prasanna.trainscheduleapp.Utilities.Constants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

/**
 * Created by prasanna on 5/31/17.
 */

public class HistoryFragment extends Fragment{
    private ListView lstHistory;
    private SearchHistoryDAO searchHistoryDAO;
    private SearchHistoryDetailsDAO searchHistoryDetailsDAO;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history,container,false);

        //Initialize
        lstHistory = (ListView)view.findViewById(R.id.lstTrainScheduleHistory);
        searchHistoryDAO = new SearchHistoryDAO(getContext());
        searchHistoryDetailsDAO = new SearchHistoryDetailsDAO(getContext());

        final ArrayList<TrainHistory> trainHistoryArr = searchHistoryDAO.getTrainHistoryArray();
        HistoryViewAdapter adapter = new HistoryViewAdapter(getContext(),trainHistoryArr);
        lstHistory.setAdapter(adapter);

        lstHistory.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        TrainHistory history = (TrainHistory) parent.getItemAtPosition(position);
                        if(searchHistoryDAO.isHistoryExist(history.getStartStation(),
                                history.getEndStation())){
                            Long index = searchHistoryDAO.getID(history.getStartStation(),history.getEndStation());
                            if(searchHistoryDetailsDAO.isHistoryDetailsExist(index)){
                                //Create array list to hold the data coming from the database
                                ArrayList<TrainSchedule> arrTrainScheduleResult = searchHistoryDetailsDAO.getTrainScheduleArray(index);
                                TrainScheduleViewFragment trainScheduleViewFragment = new TrainScheduleViewFragment();

                                //Create calendar instance
                                Calendar now = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
                                String todayDate = String.format("%1$tY-%1$tm-%1$td", now);

                                //Set the array for initialize list adapter
                                trainScheduleViewFragment.setTrainScheduleArray(arrTrainScheduleResult);

                                //Put all variables to send train schedule view fragment
                                HashMap<String,String> map = new HashMap<>();
                                map.put("from_station", history.getStartStation());
                                map.put("to_station", history.getEndStation());
                                map.put("date",todayDate);
                                trainScheduleViewFragment.setTrainScheduleDesc(map);
                                trainScheduleViewFragment.setOnlineOfflineState(true);
                                trainScheduleViewFragment.setFragmentTag(Constants.FRAGMENT_TRAIN_HISTORY);

                                //Start the fragment
                                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                transaction.replace(R.id.frmMain, trainScheduleViewFragment, Constants.FRAGMENT_TRAIN_SCHEDULE_VIEW);
                                transaction.commit();
                            }
                        }
                        return true;
                    }
                }
        );

        return view;
    }
}
