package com.example.prasanna.trainscheduleapp.ListAdapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.prasanna.trainscheduleapp.Models.TrainHistory;
import com.example.prasanna.trainscheduleapp.R;

import java.util.ArrayList;

/**
 * Created by prasanna on 5/31/17.
 */

public class HistoryViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<TrainHistory> arrTrainHistory;
    public HistoryViewAdapter(Context context, ArrayList<TrainHistory> arrTrainHistory) {
        this.context = context;
        this.arrTrainHistory = arrTrainHistory;
    }

    @Override
    public int getCount() {
        return arrTrainHistory.size();
    }

    @Override
    public Object getItem(int position) {
        return arrTrainHistory.get(position);
    }

    @Override
    public long getItemId(int position) {
        return arrTrainHistory.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.adapter_history_view, null );
        TextView adapterStation = (TextView)v.findViewById(R.id.adapterStation);
        TrainHistory history = arrTrainHistory.get(position);
        String labelText = history.getStartStation() + " - " + history.getEndStation();
        adapterStation.setText(labelText);
        return v;
    }
}
