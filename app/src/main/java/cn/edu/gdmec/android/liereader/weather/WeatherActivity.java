package cn.edu.gdmec.android.liereader.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import cn.edu.gdmec.android.liereader.R;
import cn.edu.gdmec.android.liereader.bean.WeatherBean;
import cn.edu.gdmec.android.liereader.weather.presenter.WeatherPresenter;
import cn.edu.gdmec.android.liereader.weather.view.IWeatherView;

public class WeatherActivity extends AppCompatActivity implements IWeatherView {

    private WeatherPresenter presenter;

    Integer[] city={101280101,101280102,101280103,101280104,101280105, 101280201,101280202,101280203,101280204,101280205,101280206, 101280207,101280208,101280501};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        presenter = new WeatherPresenter(this);
        for (Integer i : city){
            presenter.loadWeather(i);
        }
    }

    @Override
    public void showWeather(WeatherBean weatherBean) {
        Log.i(weatherBean.getData().getCity(),weatherBean.getData().getGanmao());

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void showErrorMsg(Throwable throwable) {

    }
}
