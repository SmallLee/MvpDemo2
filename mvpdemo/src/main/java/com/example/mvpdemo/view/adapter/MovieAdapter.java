package com.example.mvpdemo.view.adapter;

import android.content.Context;

import com.example.mvcdemo.R;
import com.example.mvpdemo.base.BasicAdapter;
import com.example.mvpdemo.base.BasicViewHolder;
import com.example.mvpdemo.common.Constant;
import com.example.mvpdemo.model.pojo.MovieBean;
import com.example.mvpdemo.util.LogUtil;

import java.util.List;

/**
 * Created by lixiaoniu on 2018/1/3.
 *
 */

public class MovieAdapter extends BasicAdapter<MovieBean> {
    public MovieAdapter(Context context, List<MovieBean> movieBeanList, int itemLayoutId) {
        super(context, movieBeanList, itemLayoutId);
    }

    @Override
    protected void convert(BasicViewHolder viewHolder, MovieBean item) {
        viewHolder.setImageUri(R.id.iv_movie_item, Constant.IMAGE_URL+item.poster_path);
    }
}
