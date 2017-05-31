package com.example.prasanna.trainscheduleapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.prasanna.trainscheduleapp.Utilities.Constants;

/**
 * Created by prasanna on 5/31/17.
 */

public class SearchHistoryDAO extends DAO {
    private Context context;
    private String tableName = "search_history";
    private String command;

    public SearchHistoryDAO(Context context) {
        super(context);
        this.context = context;
    }

    private void printLog(String message){
        Log.i(Constants.TAG,"[SearchHistoryDAO] " + message);
    }

    public long getID(String fromStation, String toStation){
        command = "SELECT id FROM " + tableName + " WHERE start_station=\"" + fromStation + "\" AND end_station=\"" + toStation + "\";";
        printLog("Query[getID] :- " + command);
        Cursor c = sqldb.rawQuery(command,null);
        printLog("Cursor count [getID] :- " + c.getCount());

        if(c.moveToFirst()) {
            do {
                return Long.parseLong(c.getString(c.getColumnIndex("id")));
            } while (c.moveToNext());
        }
        return 0;
    }

    public boolean isHistoryExist(String fromStation, String toStation){
        command = "SELECT * FROM " + tableName + " WHERE start_station=\"" + fromStation + "\" AND end_station=\"" + toStation + "\";";
        printLog("Check for train History availability :- " + command);
        Cursor c = sqldb.rawQuery(command,null);
        if(c.getCount()>0){
            c.close();
            return true;
        }else{
            c.close();
            return false;
        }
    }

    public Long addSearchHistory(String fromStation, String toStation){
        ContentValues contentValues = new ContentValues();
        contentValues.put("start_station",fromStation);
        contentValues.put("end_station",toStation);
        sqldb.insert(
                tableName, null, contentValues
        );
        return getID(fromStation,toStation);
    }
}
