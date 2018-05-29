package cn.edu.gdmec.android.liereader.news.model;

/**
 * Created by apple on 18/5/22.
 */

public interface INewsModel {
    void loadNews(String hostType,
                  int startPage,
                  String id,
                  IOnloadListener iOnloadListener);
}
