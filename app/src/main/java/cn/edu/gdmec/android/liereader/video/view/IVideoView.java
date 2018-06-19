package cn.edu.gdmec.android.liereader.video.view;

import java.util.List;

import cn.edu.gdmec.android.liereader.bean.TodayContentBean;

/**
 * Created by apple on 18/6/12.
 */

public interface IVideoView {
    void showVideo(List<TodayContentBean> todayContentBeans, List<String> videoList);
    void showMoreVideo(List<TodayContentBean> todayContentBeans, List<String> videoList);
    void hideDialog();
    void showDialog();
    void showErrorMsg(Throwable throwable);
}
