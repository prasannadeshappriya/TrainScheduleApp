package com.example.prasanna.trainscheduleapp.ListAdapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.prasanna.trainscheduleapp.Models.TrainSchedule;
import com.example.prasanna.trainscheduleapp.R;

import java.util.ArrayList;

/**
 * Created by prasanna on 4/22/17.
 */

public class TrainScheduleAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<TrainSchedule> arrTrainSchedule;

    public TrainScheduleAdapter(Context context, ArrayList<TrainSchedule> arrTrainSchedule) {
        this.context = context;
        this.arrTrainSchedule = arrTrainSchedule;
    }

    @Override
    public int getCount() {
        return arrTrainSchedule.size();
    }

    @Override
    public Object getItem(int position) {
        return arrTrainSchedule.get(position);
    }

    @Override
    public long getItemId(int position) {
        return arrTrainSchedule.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.adapter_train_schedule,null);

        TextView tvName = (TextView) v.findViewById(R.id.adapterTrainName);
        TextView tvArrival = (TextView) v.findViewById(R.id.adapterTrainArrival);
        TextView tvDepature = (TextView) v.findViewById(R.id.adapterTrainDeparture);
        TextView tvType = (TextView) v.findViewById(R.id.adapterTrainType);
        TextView tvDescription = (TextView) v.findViewById(R.id.adapterTrainDescription);
        TextView tvDestination = (TextView) v.findViewById(R.id.adapterTrainDestination);

        TrainSchedule schedule = arrTrainSchedule.get(position);

        if(schedule.getNumber().equals("")){
            tvName.setText("Connecting Trains");
        }else {
            tvName.setText("Train Name :- " + schedule.getNumber());
        }
        tvArrival.setText(schedule.getArrival());
        tvDepature.setText(schedule.getEnd());
        if(schedule.getType().equals("")){
            tvType.setVisibility(View.GONE);
        }else {
            tvType.setText("Type :- " + schedule.getType());
        }
        if(schedule.getDescription().equals("")){
            tvDescription.setVisibility(View.GONE);
        }else {
            if (schedule.getName().toString().replace(" ", "").equals("")) {
                tvDescription.setText("Description :- " + schedule.getDescription());
            } else {
                tvDescription.setText("Description :- " + schedule.getDescription() + " [" + schedule.getName() + "]");
            }
        }
        if(schedule.getDestination().equals("")) {
            tvDestination.setVisibility(View.GONE);
        }else {
            tvDestination.setText("End :- " + schedule.getDestination());
        }
        return v;
    }
}
