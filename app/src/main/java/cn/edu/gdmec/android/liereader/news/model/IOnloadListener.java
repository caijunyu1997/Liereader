package cn.edu.gdmec.android.liereader.news.model;

import cn.edu.gdmec.android.liereader.bean.NewsBean;

/**
 * Created by apple on 18/5/22.
 */

public interface IOnloadListener {
    void success(NewsBean newsBean);
    void fail(String error);
}
