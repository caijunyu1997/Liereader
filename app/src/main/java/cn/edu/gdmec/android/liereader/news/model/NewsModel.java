package cn.edu.gdmec.android.liereader.news.model;

import cn.edu.gdmec.android.liereader.bean.NewsBean;
import cn.edu.gdmec.android.liereader.http.Api;
import cn.edu.gdmec.android.liereader.http.RetrofitHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by apple on 18/5/22.
 */

public class NewsModel implements INewsModel{


    @Override
    public void loadNews(final String hostType, final int startPage, final String id, final IOnloadListener iOnloadListener) {
        RetrofitHelper retrofitHelper = new RetrofitHelper(Api.NEWS_HOST);
        retrofitHelper.getNews(hostType,id,startPage)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<NewsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iOnloadListener.fail(e.getMessage());
                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        iOnloadListener.success(newsBean);
                    }
                });
    }
}
