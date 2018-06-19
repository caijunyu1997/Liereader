package cn.edu.gdmec.android.liereader.http;

import cn.edu.gdmec.android.liereader.bean.MoviesBean;
import cn.edu.gdmec.android.liereader.bean.NewsBean;
import cn.edu.gdmec.android.liereader.bean.TodayBean;
import cn.edu.gdmec.android.liereader.bean.VideoUrlBean;
import cn.edu.gdmec.android.liereader.bean.WeatherBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by apple on 18/5/22.
 */

public interface RetrofitService {
    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<NewsBean> getNews(@Path("type") String type,
                           @Path("id") String id,
                           @Path("startPage") int startPage);

    @GET("/v2/movie/{total}")
    Observable<MoviesBean> getMovie(@Path("total") String total,
                                    @Query("start") int start);

    @GET("news/feed/v51")
    Observable<TodayBean> getToday(@Query("category") String category);

    @GET
    Observable<VideoUrlBean> getVideoUrl(@Url String url);

    @GET("weather_mini")
    Observable<WeatherBean> getWeather(@Query("citykey") Integer citykey);

}
