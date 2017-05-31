package com.example.prasanna.trainscheduleapp.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.prasanna.trainscheduleapp.Database.Database;
import com.example.prasanna.trainscheduleapp.Utilities.Constants;

/**
 * Created by prasanna on 5/30/17.
 */

public class DAO {
    public Database database;
    public SQLiteDatabase sqldb;

    public DAO(Context context){
        database = new Database(
                context,
                Constants.DATABASE_NAME,
                null,
                Constants.DATABASE_VERSION
        );
        sqldb = database.getDatabase();
    }
}
