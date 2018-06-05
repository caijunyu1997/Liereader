package cn.edu.gdmec.android.liereader.movie.presenter;

import cn.edu.gdmec.android.liereader.bean.MoviesBean;
import cn.edu.gdmec.android.liereader.http.Api;
import cn.edu.gdmec.android.liereader.movie.model.IMovieModel;
import cn.edu.gdmec.android.liereader.movie.model.IOnLoadListener;
import cn.edu.gdmec.android.liereader.movie.model.MovieMoael;
import cn.edu.gdmec.android.liereader.movie.view.IMovieView;

/**
 * Created by apple on 18/5/22.
 */

public class MoviePresenter implements IMoviePresenter,IOnLoadListener {
    private IMovieModel iMovieModel;
    private IMovieView iMovieView;

    public MoviePresenter(IMovieView iMovieView) {
        this.iMovieView = iMovieView;
        this.iMovieModel = new MovieMoael();
    }

    @Override
    public void success(MoviesBean moviesBean) {
        iMovieView.hideDialog();
        if (moviesBean !=null){
            iMovieView.showMovie(moviesBean);
        }
    }

    @Override
    public void fail(Throwable throwable) {
        iMovieView.hideDialog();
        iMovieView.showErrorMsg(throwable);
    }

    @Override
    public void loadMovie(String total) {
        iMovieView.showDialog();
        iMovieModel.loadMovie(total,this);
    }
}
