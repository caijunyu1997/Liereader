package cn.edu.gdmec.android.liereader.movie.view;

import cn.edu.gdmec.android.liereader.bean.MoviesBean;

/**
 * Created by apple on 18/5/22.
 */

public interface IMovieView {
    void showMovie(MoviesBean moviesBean);
    void showMoreMovie(MoviesBean moviesBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(Throwable throwable);
}
