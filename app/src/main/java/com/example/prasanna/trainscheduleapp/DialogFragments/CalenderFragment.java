package com.example.prasanna.trainscheduleapp.DialogFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.prasanna.trainscheduleapp.R;

/**
 * Created by prasanna on 5/14/17.
 */

public class CalenderFragment extends DialogFragment implements TextView.OnEditorActionListener {
    private DatePicker datePicker;
    private TextView btnSelect;
    private int year,month,date;
    public CalenderFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.TimePickerTheme);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_calender,container,false);
        //init
        btnSelect = (TextView) view.findViewById(R.id.btnSelect);
        datePicker = (DatePicker) view.findViewById(R.id.datePicker);

        datePicker.updateDate(year,month,date);
        getDialog().setTitle("Calender");

        btnSelect.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sendBackResult();
                    }
                }
        );
        return view;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }

    public void sendBackResult() {
        // Notice the use of `getTargetFragment` which will be set when the dialog is displayed
        EditNameDialogListener listener = (EditNameDialogListener) getTargetFragment();
        String ret = datePicker.getYear() + "-" + String.format("%02d", (datePicker.getMonth() + 1)) + "-" + String.format("%02d", datePicker.getDayOfMonth());
        listener.onFinishEditDialog(ret);
        dismiss();
    }

    public void setDate(int year, int month, int date){
        this.year = year;
        this.month = month;
        this.date = date;
    }
    public interface EditNameDialogListener {
        void onFinishEditDialog(String inputText);
    }

}
