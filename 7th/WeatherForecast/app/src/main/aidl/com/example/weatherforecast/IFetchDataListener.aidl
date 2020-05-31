// IFetchDataListener.aidl
package com.example.weatherforecast;

interface IFetchDataListener {
    void onWeatherDataRetrieved(out String[] data);
}