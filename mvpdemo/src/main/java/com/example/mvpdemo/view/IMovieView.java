package com.example.mvpdemo.view;

import com.example.mvpdemo.base.MvpView;
import com.example.mvpdemo.model.pojo.MovieInfo;

/**
 * Created by lixiaoniu on 2018/1/2.
 *
 */

public interface IMovieView extends MvpView {
    void showLoading();
    void hideLoading();
    void showError(Throwable e);
    void setMovieInfo(MovieInfo movieInfo);
}
