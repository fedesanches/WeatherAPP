package com.isep.android.weatherapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBAdapter {
    private DBHelper dbHelper;

    private static final String TABLE = "WEATHERINFO";
    private static final String ID = "ID";
    private static final String COORDINATES = "COORDINATES";
    private static final String TEMPERATURE = "TEMPERATURE";
    private static final String WIND = "WIND";
    private static final String HUMIDITY = "HUMIDITY";

    private String query =
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COORDINATES + " TEXT,"
            + TEMPERATURE + " TEXT,"
            + WIND + " TEXT,"
            + HUMIDITY + " TEXT";

    public DBAdapter(Context context) {
        dbHelper = new DBHelper(context, TABLE, query);
    }

    //Make all CRUD operations (Create, Read, Update and Delete)
    public boolean insertWeatherCondition (String coordinate, String temperature, String wind, String hummidity) {
        try {
            //Call data base
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            //Create ContentValues too put the values before insert
            ContentValues values = new ContentValues();
            values.put(COORDINATES, coordinate);
            values.put(TEMPERATURE, temperature);
            values.put(WIND, wind);
            values.put(HUMIDITY, hummidity);

            //Insert values in table
            db.insert(TABLE, null, values);
            db.close();
        } catch (SQLException e) {
            Log.e("Insert into table error", e.getMessage());
            return false;
        }
        return true;
    }
}
