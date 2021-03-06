package cn.edu.gdmec.android.liereader.movie;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TimerTask;

import cn.edu.gdmec.android.liereader.R;
import cn.edu.gdmec.android.liereader.bean.MoviesBean;
import cn.edu.gdmec.android.liereader.movie.presenter.MoviePresenter;
import cn.edu.gdmec.android.liereader.movie.view.IMovieView;


public class FgMovieFragment extends Fragment implements IMovieView {

    private MoviePresenter moviesPresenter;
    private RecyclerView rv_movie_on;
    private SwipeRefreshLayout srl_movie;
    private ItemMovieOnAdapter movieOnAdapter;
    private ItemMovieTopAdapter movieTop250Adapter;
    private RecyclerView rv_movie_top250;
    private LinearLayoutManager layoutManager;
    private int start = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_movie, null);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moviesPresenter = new MoviePresenter(this);
        srl_movie = view.findViewById(R.id.srl_movie);
        rv_movie_on = view.findViewById(R.id.rv_movie_on);
        rv_movie_top250=view.findViewById(R.id.rv_movie_top);
        movieOnAdapter = new ItemMovieOnAdapter(getActivity());
        movieTop250Adapter = new ItemMovieTopAdapter(getActivity());
        srl_movie.setColorSchemeColors(Color.parseColor("#ffce3d3a"));
        moviesPresenter.loadMovie("in_theaters",0);
        moviesPresenter.loadMovie("top250",0);
        srl_movie.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                moviesPresenter.loadMovie("in_theaters",0);
                moviesPresenter.loadMovie("top250",0);
            }
        });

        rv_movie_on.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState==RecyclerView.SCROLL_STATE_IDLE && (layoutManager.findLastVisibleItemPosition()+1)==layoutManager.getItemCount()){
                    loadMore();
                }
            }
        });
    }

    private void loadMore(){
        start+=20;
        moviesPresenter.loadMovie("in_theaters",start);
    }

    @Override
    public void showMovie(MoviesBean moviesBean) {
        if (moviesBean.getTotal()==250){
            movieTop250Adapter.setData(moviesBean.getSubjects());
            rv_movie_top250.setLayoutManager(new LinearLayoutManager(getActivity(),
                    LinearLayoutManager.HORIZONTAL,false));
            rv_movie_top250.setHorizontalScrollBarEnabled(true);
            rv_movie_top250.setAdapter(movieTop250Adapter);
        }else {
            movieOnAdapter.setData(moviesBean.getSubjects());
            layoutManager=new LinearLayoutManager(getActivity());
            rv_movie_on.setLayoutManager(layoutManager);
            rv_movie_on.setAdapter(movieOnAdapter);
        }
    }

    @Override
    public void showMoreMovie(MoviesBean moviesBean) {
        if (moviesBean.getStart()>=40){
            movieOnAdapter.notifyItemRemoved(movieOnAdapter.getItemCount());
            Toast.makeText(getContext(), "没有更多了......", Toast.LENGTH_SHORT).show();
        }else {
            movieOnAdapter.addData(moviesBean.getSubjects());
            movieOnAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void hideDialog() {
        srl_movie.setRefreshing(false);
    }

    @Override
    public void showDialog() {
        srl_movie.setRefreshing(true);
    }

    @Override
    public void showErrorMsg(Throwable throwable) {
        movieOnAdapter.notifyItemRemoved(movieOnAdapter.getItemCount());
        Toast.makeText(getContext(), "加载出错:"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
}