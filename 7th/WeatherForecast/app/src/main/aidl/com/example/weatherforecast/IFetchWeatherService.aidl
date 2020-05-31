// IFetchWeatherService.aidl
package com.example.weatherforecast;

import com.example.weatherforecast.IfetchDataListener;

interface IFetchWeatherService {
    void retrieveWeatherData();
    void registerFetchDataListener(IFetchDataListener listener);
    void unregisterFetchDataListener(IFetchDataListener listener);
}