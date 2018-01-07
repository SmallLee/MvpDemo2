package com.example.mvpdemo.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.example.mvcdemo.R;
import com.example.mvpdemo.base.BaseActivity;
import com.example.mvpdemo.model.pojo.MovieBean;
import com.example.mvpdemo.model.pojo.MovieInfo;
import com.example.mvpdemo.presenter.impl.MoviePresentImpl;
import com.example.mvpdemo.view.adapter.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements IMovieView{
    private static final String TAG = "MainActivity";
    private MoviePresentImpl mMoviePresenter;
    private List<MovieBean> mMovieInfoList  = new ArrayList<>();
    private MovieAdapter mMovieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = (GridView) findViewById(R.id.grid_view);
        mMovieAdapter = new MovieAdapter(this,mMovieInfoList, R.layout.movie_item_layout);
        gridView.setAdapter(mMovieAdapter);
    }

    @Override
    public void initPresenter() {
        mMoviePresenter = new MoviePresentImpl(this);
    }

    @Override
    public void detachView() {
        mMoviePresenter.detachView();
    }

    public void request(View view) {
        mMoviePresenter.getMovieInfo();
    }

    @Override
    public void showLoading() {
        Log.d(TAG, "showLoading: ");
    }

    @Override
    public void hideLoading() {
        Log.d(TAG, "hideLoading: ");
    }

    @Override
    public void showError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void setMovieInfo(MovieInfo movieInfo) {
        mMovieInfoList.addAll(movieInfo.results);
        mMovieAdapter.notifyDataSetChanged();
    }
}
