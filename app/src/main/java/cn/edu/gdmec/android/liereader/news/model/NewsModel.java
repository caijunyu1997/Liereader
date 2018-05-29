package cn.edu.gdmec.android.liereader.news.model;

import cn.edu.gdmec.android.liereader.bean.NewsBean;
import cn.edu.gdmec.android.liereader.http.Api;
import cn.edu.gdmec.android.liereader.http.RetrofitHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by apple on 18/5/22.
 */

public class NewsModel implements INewsModel{


    @Override
    public void loadNews(final String hostType, final int startPage, final String id, final IOnloadListener iOnloadListener) {
        RetrofitHelper retrofitHelper = new RetrofitHelper(Api.NEWS_HOST);
        retrofitHelper.getNews(hostType,id,startPage).enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                if (response.isSuccessful()){
                    iOnloadListener.success(response.body());
                }else{
                    iOnloadListener.fail("");
                }
            }

            @Override
            public void onFailure(Call<NewsBean> call, Throwable t) {
                iOnloadListener.fail(t.toString());
            }
        });
    }
}
