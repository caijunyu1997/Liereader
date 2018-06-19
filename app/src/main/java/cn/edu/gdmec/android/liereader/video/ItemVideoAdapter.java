package cn.edu.gdmec.android.liereader.video;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cn.edu.gdmec.android.liereader.R;
import cn.edu.gdmec.android.liereader.bean.TodayContentBean;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by apple on 18/6/12.
 */

public class ItemVideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<TodayContentBean> objects = new ArrayList<TodayContentBean>();
    private List<String> videoList = new ArrayList<>();

    private Context context;

    public ItemVideoAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<TodayContentBean> objects,List<String> videoList) {
        this.objects = objects;
        this.videoList = videoList;
    }

    public void addData(List<TodayContentBean> objects,List<String> videoList) {
        this.objects.addAll(objects);
        this.videoList.addAll(videoList);
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==0){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_video, parent, false);
            return new ItemVideoAdapter.ViewHolder(view);
        }else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.footer, parent, false);
            return new ItemVideoAdapter.FooterHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            TodayContentBean bean = objects.get(position);
            ((ViewHolder) holder).videoPlayer.setUp(videoList.get(position),
                    JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,
                    bean.getAbstractX());
            Glide.with(context)
                    .load(bean.getLarge_image_list().get(0).getUrl())
                    .into(((ViewHolder) holder).videoPlayer.thumbImageView);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }


    protected class ViewHolder extends RecyclerView.ViewHolder{
        private JZVideoPlayerStandard videoPlayer;

        public ViewHolder(View view) {
            super(view);
            videoPlayer = (JZVideoPlayerStandard) view.findViewById(R.id.video_player);
        }
    }

    protected class FooterHolder extends RecyclerView.ViewHolder{
        public FooterHolder(View itemView){
            super(itemView);
        }
    }
}
