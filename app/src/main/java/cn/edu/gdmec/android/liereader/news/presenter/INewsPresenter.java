package cn.edu.gdmec.android.liereader.news.presenter;

import cn.edu.gdmec.android.liereader.bean.NewsBean;

/**
 * Created by apple on 18/5/22.
 */

public interface INewsPresenter {
    void loadNews(int type, int startPage);
}
