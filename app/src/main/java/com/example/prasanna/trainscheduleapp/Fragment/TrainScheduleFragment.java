package com.example.prasanna.trainscheduleapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prasanna.trainscheduleapp.R;

/**
 * Created by prasanna on 5/30/17.
 */

public class TrainScheduleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_train_schedule,container,false);


        return view;
    }
}
