package com.example.mvpdemo.presenter.impl;

import com.example.mvpdemo.base.BasePresenter;
import com.example.mvpdemo.model.net.ResponseObserver;
import com.example.mvpdemo.model.net.RetrofitWrapper;
import com.example.mvpdemo.model.net.service.MovieService;
import com.example.mvpdemo.model.pojo.DoubanMovie;
import com.example.mvpdemo.presenter.IMoviePresenter;
import com.example.mvpdemo.util.LogUtil;
import com.example.mvpdemo.view.IMovieView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by lixiaoniu on 2018/1/3.
 */

public class MoviePresentImpl extends BasePresenter<IMovieView> implements IMoviePresenter {
    private IMovieView mMovieView;

    public MoviePresentImpl(IMovieView movieView) {
        super.attachView(movieView);
        this.mMovieView = movieView;
    }

    @Override
    public void getMovieInfo(int start,int count) {
        MovieService movieService = RetrofitWrapper.getInstence().create(MovieService.class);
        mCompositeSubscription.add(movieService.getMovieInfo(start,count)
                .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        getMvpView().showLoading();
                    }
                }).doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        getMvpView().hideLoading();
                    }
                })
        .subscribe(new ResponseObserver<DoubanMovie>(){
            @Override
            public void onError(Throwable e) {
                getMvpView().showError(e);
                LogUtil.e("===="+e.getMessage());
            }

            @Override
            public void onSuccess(DoubanMovie movieInfo) {
                getMvpView().setMovieInfo(movieInfo);
            }
        }));
    }

}
