package cn.edu.gdmec.android.liereader.movie.model;

import cn.edu.gdmec.android.liereader.bean.MoviesBean;
import cn.edu.gdmec.android.liereader.http.Api;
import cn.edu.gdmec.android.liereader.http.RetrofitHelper;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by apple on 18/5/22.
 */

public class MovieMoael implements IMovieModel{

    @Override
    public void loadMovie(String total,final IOnLoadListener iOnLoadListener) {
        RetrofitHelper retrofitHelper = new RetrofitHelper(Api.MOVIE_HOST);
        retrofitHelper.getMovies(total)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<MoviesBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iOnLoadListener.fail(e);
                    }

                    @Override
                    public void onNext(MoviesBean moviesBean) {
                        iOnLoadListener.success(moviesBean);
                    }
                });
    }
}
