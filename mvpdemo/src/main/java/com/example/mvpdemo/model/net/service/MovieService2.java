package com.example.mvpdemo.model.net.service;


import com.example.mvpdemo.model.pojo.MovieInfo;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by lixiaoniu on 2018/1/3.
 *  演示POST请求
 */

public interface MovieService2 {
    @FormUrlEncoded
    @POST
    Observable<MovieInfo> getMovieInfo(@Url String methodName,@Field("name") String name, @Field("age") int age);
}
