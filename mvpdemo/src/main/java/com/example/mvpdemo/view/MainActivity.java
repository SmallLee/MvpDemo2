package com.example.mvpdemo.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.example.mvcdemo.R;
import com.example.mvpdemo.base.BaseActivity;
import com.example.mvpdemo.model.pojo.DoubanMovie;
import com.example.mvpdemo.presenter.impl.MoviePresentImpl;
import com.example.mvpdemo.util.NetWorkUtil;
import com.example.mvpdemo.util.StatusBarUtil;
import com.example.mvpdemo.view.adapter.MovieAdapter;
import com.example.mvpdemo.view.ui.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements IMovieView {
    private static final String TAG = "MainActivity";
    private MoviePresentImpl mMoviePresenter;
    private List<DoubanMovie.SubjectsBean> mMovieInfoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RefreshLayout refreshLayout;
    private int start;
    private int count = 4;
    private boolean isLoadMore;
    private RecyclerAdapterWithHF mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setColor(this, getResources().getColor(R.color.white));
        recyclerView = (RecyclerView) findViewById(R.id.rv_content);
        refreshLayout = (RefreshLayout) findViewById(R.id.ptr_container);
        mAdapter = refreshLayout.getHFAdapter(new MovieAdapter(this, mMovieInfoList, R.layout.movie_item_layout));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.autoRefresh(true);
            }
        }, 150);
        refreshLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                isLoadMore = false;
                start = 0;
                mMovieInfoList.clear();
                mMoviePresenter.getMovieInfo(start,count);
                Toast.makeText(MainActivity.this, "下拉刷新", Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                if (!NetWorkUtil.IsNetWorkEnable(MainActivity.this)) {
                    return false;
                }
                return super.checkCanDoRefresh(frame, content, header);
            }
        });

        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                isLoadMore = true;
                start += 4;
                mMoviePresenter.getMovieInfo(start,count);
                Toast.makeText(MainActivity.this, "加在更多", Toast.LENGTH_SHORT).show();
            }
        });
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
//        mMoviePresenter.getMovieInfo();
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
    public void setMovieInfo(DoubanMovie movieInfo) {
        mMovieInfoList.addAll(movieInfo.getSubjects());
        mAdapter.notifyDataSetChanged();
        if (isLoadMore) {
            refreshLayout.loadMoreComplete(true);
        } else {
            refreshLayout.refreshComplete();
            refreshLayout.setLoadMoreEnable(true);
        }
    }
}
