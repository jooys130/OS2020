package com.example.weatherforecast.provider;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WeatherDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "weather_forecast.db";

    public WeatherDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_WEATHER_TABLE = "CREATE TABLE " + WeatherContract.WeatherColumns.TABLE_NAME + " (" +

                WeatherContract.WeatherColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +


                WeatherContract.WeatherColumns.COLUMN_DATE + " INTEGER NOT NULL, " +
                WeatherContract.WeatherColumns.COLUMN_SHORT_DESC + " TEXT NOT NULL, " +

                WeatherContract.WeatherColumns.COLUMN_MIN_TEMP + " REAL NOT NULL, " +
                WeatherContract.WeatherColumns.COLUMN_MAX_TEMP + " REAL NOT NULL, " +

                " UNIQUE (" + WeatherContract.WeatherColumns.COLUMN_DATE + ") ON CONFLICT REPLACE);";

        db.execSQL(SQL_CREATE_WEATHER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + WeatherContract.WeatherColumns.TABLE_NAME);
        onCreate(db);
    }
}