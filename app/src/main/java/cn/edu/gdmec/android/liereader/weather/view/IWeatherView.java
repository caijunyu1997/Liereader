package cn.edu.gdmec.android.liereader.weather.view;


import cn.edu.gdmec.android.liereader.bean.WeatherBean;

/**
 * Created by apple on 18/6/12.
 */

public interface IWeatherView {
    void showWeather(WeatherBean weatherBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(Throwable throwable);
}
