package cn.edu.gdmec.android.liereader.movie.model;

/**
 * Created by apple on 18/5/22.
 */

public interface IMovieModel {
    void loadMovie(String total, int start, IOnLoadListener iOnLoadListener);
}
