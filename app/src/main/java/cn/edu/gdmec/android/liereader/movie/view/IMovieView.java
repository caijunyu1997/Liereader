package cn.edu.gdmec.android.liereader.movie.view;

import cn.edu.gdmec.android.liereader.bean.MovieBean;

/**
 * Created by apple on 18/5/22.
 */

public interface IMovieView {
    void showMovie(MovieBean movieBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(String error);
}
