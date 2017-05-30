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

        tvName.setText("Train Name :- " + schedule.getNumber());
        tvArrival.setText("Arrival :- " + schedule.getArrival());
        tvDepature.setText("Destination :- " + schedule.getEnd());
        tvType.setText("Type :- " + schedule.getType());
        if(schedule.getName().toString().replace(" ","").equals("")){
            tvDescription.setText("Description :- " + schedule.getDescription());
        }else {
            tvDescription.setText("Description :- " + schedule.getDescription() + " [" + schedule.getName() + "]");
        }
        tvDestination.setText("End :- " + schedule.getDestination());

        return v;
    }
}
