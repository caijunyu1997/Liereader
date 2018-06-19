package cn.edu.gdmec.android.liereader.news.presenter;

import cn.edu.gdmec.android.liereader.bean.NewsBean;
import cn.edu.gdmec.android.liereader.http.Api;
import cn.edu.gdmec.android.liereader.news.FgNewsFragment;
import cn.edu.gdmec.android.liereader.news.model.INewsModel;
import cn.edu.gdmec.android.liereader.news.model.IOnloadListener;
import cn.edu.gdmec.android.liereader.news.model.NewsModel;
import cn.edu.gdmec.android.liereader.news.view.INewsView;

/**
 * Created by apple on 18/5/22.
 */

public class NewsPresenter implements INewsPresenter,IOnloadListener{

    private INewsModel iNewsModel;
    private INewsView iNewsView;

    public NewsPresenter(INewsView iNewsView) {
        this.iNewsView = iNewsView;
        this.iNewsModel = new NewsModel();
    }

    @Override
    public void success(NewsBean newsBean) {
        iNewsView.hideDialog();
        if (newsBean!=null){
            iNewsView.showNews(newsBean);
        }
    }

    @Override
    public void fail(String error) {
        iNewsView.hideDialog();
        iNewsView.showErrorMsg(error);
    }

    @Override
    public void loadMoreSuccess(NewsBean newsBean) {
        iNewsView.hideDialog();
        iNewsView.showMoreNews(newsBean);
    }

    @Override
    public void loadNews(int type, int startPage) {
        if (startPage==0) {
            iNewsView.showDialog();
        }
        switch (type){
            case FgNewsFragment.NEWS_TYPE_TOP:
                iNewsModel.loadNews("headline",startPage, Api.HEADLINE_ID,
                        this);
                break;
            case FgNewsFragment.NEWS_TYPE_NBA:
                iNewsModel.loadNews("list",startPage, Api.NBA_ID,
                        this);
                break;
            case FgNewsFragment.NEWS_TYPE_JOKES:
                iNewsModel.loadNews("list",startPage, Api.JOKE_ID,
                        this);
                break;
        }
    }
}
