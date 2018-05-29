package cn.edu.gdmec.android.liereader.movie.model;

import cn.edu.gdmec.android.liereader.bean.MovieBean;

/**
 * Created by apple on 18/5/22.
 */

public interface IMovieloadListener {
    void success(MovieBean movieBean);
    void fail(String error);
}
