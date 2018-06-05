package cn.edu.gdmec.android.liereader.movie.model;

import cn.edu.gdmec.android.liereader.bean.MoviesBean;

/**
 * Created by apple on 18/5/22.
 */

public interface IOnLoadListener {
    void success(MoviesBean moviesBean);
    void fail(Throwable throwable);
}
