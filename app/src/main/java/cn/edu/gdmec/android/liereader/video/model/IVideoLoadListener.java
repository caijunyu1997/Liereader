package cn.edu.gdmec.android.liereader.video.model;

import java.util.List;

import cn.edu.gdmec.android.liereader.bean.TodayContentBean;
import cn.edu.gdmec.android.liereader.bean.VideoUrlBean;

/**
 * Created by apple on 18/6/12.
 */

public interface IVideoLoadListener {
    void videoUrlSuccess(List<VideoUrlBean> videoUrlBeans, List<TodayContentBean> contentBeans);
    void fail(Throwable throwable);

    void loadMoreSuccess(List<VideoUrlBean> videoUrlBeans, List<TodayContentBean> contentBeans);
}
