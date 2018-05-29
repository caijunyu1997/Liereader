package cn.edu.gdmec.android.liereader.movie.presenter;

import cn.edu.gdmec.android.liereader.bean.MovieBean;
import cn.edu.gdmec.android.liereader.http.Api;
import cn.edu.gdmec.android.liereader.movie.model.IMovieModel;
import cn.edu.gdmec.android.liereader.movie.model.IMovieloadListener;
import cn.edu.gdmec.android.liereader.movie.model.MovieMoael;
import cn.edu.gdmec.android.liereader.movie.view.IMovieView;

/**
 * Created by apple on 18/5/22.
 */

public class MoviePresenter implements IMoviePresenter,IMovieloadListener {
    private IMovieModel iMovieModel;
    private IMovieView iMovieView;

    public MoviePresenter(IMovieView iMovieView) {
        this.iMovieView = iMovieView;
        this.iMovieModel = new MovieMoael();
    }

    @Override
    public void success(MovieBean movieBean) {
        iMovieView.hideDialog();
        if (movieBean!=null){
            iMovieView.showMovie(movieBean);
        }
    }

    @Override
    public void fail(String error) {
        iMovieView.hideDialog();
        iMovieView.showErrorMsg(error);
    }

    @Override
    public void loadMovie() {
        iMovieView.showDialog();
        iMovieModel.loadMovie(Api.MOVIE_HOST,Api.MOVIE_ID,this);
    }
}
