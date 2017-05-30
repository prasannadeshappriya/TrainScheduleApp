package com.example.prasanna.trainscheduleapp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.prasanna.trainscheduleapp.Utilities.Constants;

/**
 * Created by prasanna on 5/30/17.
 */

public class Database extends SQLiteOpenHelper {
    private String databaseName;
    private String sqlCommand;

    private final String CREATE = "create";
    private final String DROP = "drop";

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.databaseName = name;
    }

    private void printLog(String action, String table_name, String sql_command){
        String TAG = Constants.TAG;
        if(action.equals(CREATE)) {
            Log.i(TAG, "[Database] Create " + table_name + " table [Sql_Command :- '" + sql_command + "']");
        }else if(action.equals(DROP)){
            Log.i(TAG, "[Database] Drop " + table_name + " table [Sql_Command :- '" + sql_command + "']");
        }
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create Table
        sqlCommand = "CREATE TABLE IF NOT EXISTS train_stations (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "station_code VARCHAR(10), " +
                "station_name VARCHAR(255));";
        printLog(CREATE, "train_stations", sqlCommand);
        db.execSQL(sqlCommand);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        sqlCommand = "DROP TABLE IF EXISTS train_stations;";
        printLog(DROP,"train_lines",sqlCommand);
        db.execSQL(sqlCommand);
        onCreate(db);
    }

    public SQLiteDatabase getDatabase(){
        return getWritableDatabase();
    }
}
