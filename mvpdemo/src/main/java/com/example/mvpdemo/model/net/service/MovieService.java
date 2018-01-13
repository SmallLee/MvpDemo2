package com.example.mvpdemo.model.net.service;


import com.example.mvpdemo.model.pojo.DoubanMovie;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lixiaoniu on 2018/1/3.
 *
 */

public interface MovieService {
    //此处的完整路径为http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=643e503c35816202926457ad7d535052
    @GET("top250")//拼接在BASE_URL后面的路径
    Observable<DoubanMovie> getMovieInfo(@Query("start") int start,@Query("count") int count);
}
