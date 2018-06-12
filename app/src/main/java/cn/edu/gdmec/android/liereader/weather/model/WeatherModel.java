package cn.edu.gdmec.android.liereader.weather.model;

import cn.edu.gdmec.android.liereader.bean.WeatherBean;
import cn.edu.gdmec.android.liereader.http.Api;
import cn.edu.gdmec.android.liereader.http.RetrofitHelper;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by apple on 18/6/12.
 */

public class WeatherModel implements IWeatherModel{
    @Override
    public void loadWeather(Integer citykey, final IWeatherLoadListener iWeatherLoadListener) {
        final RetrofitHelper retrofitHelper = new RetrofitHelper(Api.WEATHER_HOST);

        retrofitHelper.getWeather(citykey)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<WeatherBean>() {

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        iWeatherLoadListener.fail(e);
                    }

                    @Override
                    public void onNext(WeatherBean weatherBean) {
                        iWeatherLoadListener.success(weatherBean);
                    }
                });
    }
}
