package com.example.prasanna.trainscheduleapp.Fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prasanna.trainscheduleapp.DAO.TrainStationDAO;
import com.example.prasanna.trainscheduleapp.R;
import com.example.prasanna.trainscheduleapp.Task.GetRatesTask;

import java.util.ArrayList;

/**
 * Created by prasanna on 5/31/17.
 */

public class TrainRateFragment extends Fragment{
    private Button btnSearch;
    private ProgressDialog pd;
    private TrainStationDAO trainStationDAO;
    private AutoCompleteTextView tvFromStation;
    private AutoCompleteTextView tvToStation;
    private TextView tvtext1, tvtext2, tvtext3;
    private LinearLayout lyLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rates,container,false);

        //Initialize
        pd = new ProgressDialog(getContext(),R.style.AppTheme_Dark_Dialog);
        btnSearch = (Button) view.findViewById(R.id.btnTest);
        tvFromStation = (AutoCompleteTextView) view.findViewById(R.id.tvFromStation);
        tvToStation = (AutoCompleteTextView) view.findViewById(R.id.tvTOStation);
        trainStationDAO = new TrainStationDAO(getContext());
        tvtext1 = (TextView) view.findViewById(R.id.tvtext1);
        tvtext2 = (TextView) view.findViewById(R.id.tvtext2);
        tvtext3 = (TextView) view.findViewById(R.id.tvtext3);
        lyLayout = (LinearLayout) view.findViewById(R.id.lyLayout);

        btnSearch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startProcess();
                    }
                }
        );

        initializeArrays();
        lyLayout.setVisibility(View.GONE);

        tvToStation.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        closeKeyboard();
                    }
                }
        );

        tvFromStation.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        closeKeyboard();
                    }
                }
        );

        return view;
    }

    private void closeKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = getActivity().getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(getActivity());
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void startProcess() {
        tvToStation.setText(tvToStation.getText().toString().toUpperCase());
        tvFromStation.setText(tvFromStation.getText().toString().toUpperCase());
        boolean con = true;
        if(tvToStation.getText().toString().replace(" ","").equals("")){
            Toast.makeText(getContext(), "Select a valid station name!", Toast.LENGTH_LONG).show();
            con = false;
        }
        if(tvFromStation.getText().toString().replace(" ","").equals("")){
            Toast.makeText(getContext(), "Select a valid station name!", Toast.LENGTH_LONG).show();
            con = false;
        }
        String fromCode = trainStationDAO.getTrainStationKey(tvFromStation.getText().toString());
        String toCode = trainStationDAO.getTrainStationKey(tvToStation.getText().toString());
        if(fromCode.equals("null")){
            Toast.makeText(getContext(), tvFromStation.getText().toString() + " is an invalid station name!", Toast.LENGTH_LONG).show();
            con = false;
        }
        if(toCode.equals("null")){
            Toast.makeText(getContext(), tvToStation.getText().toString() + " is an invalid station name!", Toast.LENGTH_LONG).show();
            con = false;
        }
        if(con) {
            GetRatesTask getRatesTask = new GetRatesTask(getContext(), pd,
                    tvFromStation.getText().toString(),
                    tvToStation.getText().toString(), this);
            getRatesTask.execute();
        }
    }

    public void setParameters(ArrayList<String> arrPrice){
        if(arrPrice.size()>2) {
            lyLayout.setVisibility(View.VISIBLE);
            tvtext1.setText("Price :- Rs." + arrPrice.get(0) + "/=");
            tvtext2.setText("Price :- Rs." + arrPrice.get(1) + "/=");
            tvtext3.setText("Price :- Rs." + arrPrice.get(2) + "/=");
        }else{
            Toast.makeText(getContext(),"No internet access!",Toast.LENGTH_LONG).show();
        }
    }

    private void initializeArrays() {
        tvFromStation.setAdapter(null);
        tvToStation.setAdapter(null);
        ArrayList<String> arrTrainStations = trainStationDAO.getTrainStationNameArray();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,arrTrainStations);
        tvFromStation.setAdapter(adapter);
        tvToStation.setAdapter(adapter);
    }
}
