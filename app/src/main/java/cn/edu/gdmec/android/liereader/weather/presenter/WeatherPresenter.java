package cn.edu.gdmec.android.liereader.weather.presenter;

import cn.edu.gdmec.android.liereader.bean.WeatherBean;
import cn.edu.gdmec.android.liereader.weather.model.IWeatherLoadListener;
import cn.edu.gdmec.android.liereader.weather.model.IWeatherModel;
import cn.edu.gdmec.android.liereader.weather.model.WeatherModel;
import cn.edu.gdmec.android.liereader.weather.view.IWeatherView;

/**
 * Created by apple on 18/6/12.
 */

public class WeatherPresenter implements IWeatherPresenter,IWeatherLoadListener{
    private IWeatherModel iWeatherModel;
    private IWeatherView iWeatherView;

    public WeatherPresenter(IWeatherView iWeatherView){
        this.iWeatherView = iWeatherView;
        this.iWeatherModel = new WeatherModel();
    }

    @Override
    public void loadWeather(Integer citykey) {
        iWeatherView.showDialog();
        iWeatherModel.loadWeather(citykey,this);
    }

    @Override
    public void success(WeatherBean weatherBean) {
        iWeatherView.hideDialog();
        if (weatherBean != null){
            iWeatherView.showWeather(weatherBean);
        }
    }

    @Override
    public void fail(Throwable throwable) {
        iWeatherView.hideDialog();
        iWeatherView.showErrorMsg(throwable);

    }
}