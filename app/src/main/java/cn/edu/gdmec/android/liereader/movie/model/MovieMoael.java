package cn.edu.gdmec.android.liereader.movie.model;

import cn.edu.gdmec.android.liereader.bean.MovieBean;
import cn.edu.gdmec.android.liereader.http.Api;
import cn.edu.gdmec.android.liereader.http.RetrofitHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by apple on 18/5/22.
 */

public class MovieMoael implements IMovieModel{

    @Override
    public void loadMovie(String hostType, String id, final IMovieloadListener iMovieloadListener) {
        RetrofitHelper retrofitHelper = new RetrofitHelper(Api.MOVIE_HOST);
        retrofitHelper.getMovie().enqueue(new Callback<MovieBean>() {
            @Override
            public void onResponse(Call<MovieBean> call, Response<MovieBean> response) {
                if (response.isSuccessful()){
                    iMovieloadListener.success(response.body());
                }else{
                    iMovieloadListener.fail("");
                }

            }

            @Override
            public void onFailure(Call<MovieBean> call, Throwable t) {
                iMovieloadListener.fail(t.toString());
            }
        });
    }
}
