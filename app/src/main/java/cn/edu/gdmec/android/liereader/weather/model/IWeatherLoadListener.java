package cn.edu.gdmec.android.liereader.weather.model;

import cn.edu.gdmec.android.liereader.bean.WeatherBean;

/**
 * Created by apple on 18/6/12.
 */

public interface IWeatherLoadListener {
    void success(WeatherBean weatherBean);
    void fail(Throwable throwable);
}
