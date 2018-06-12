package cn.edu.gdmec.android.liereader.weather.model;

/**
 * Created by apple on 18/6/12.
 */

public interface IWeatherModel {
    void loadWeather(Integer citykey, IWeatherLoadListener iWeatherLoadListener);
}
