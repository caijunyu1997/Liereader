package cn.edu.gdmec.android.liereader.video.model;

/**
 * Created by apple on 18/6/12.
 */

public interface IVideoModel {
    void loadVideo(String category,int start, IVideoLoadListener iVideoLoadListener);
}
