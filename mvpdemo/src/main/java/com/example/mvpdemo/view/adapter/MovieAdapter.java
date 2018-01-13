package com.example.mvpdemo.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mvcdemo.R;
import com.example.mvpdemo.model.pojo.DoubanMovie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lixiaoniu on 2018/1/3.
 *
 */

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<DoubanMovie.SubjectsBean> mData;
    private int mItemLayout;

    public MovieAdapter(Context context, List<DoubanMovie.SubjectsBean> data, int itemLayout){
        mContext = context;
        mData = data;
        mItemLayout = itemLayout;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(mItemLayout,parent,false);
        MovieViewHolder viewHolder = new MovieViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DoubanMovie.SubjectsBean movieBean = mData.get(position);
        MovieViewHolder movieViewHolder = (MovieViewHolder) holder;
        Uri uri = Uri.parse(movieBean.getImages().getSmall());
        Picasso.with(mContext).load(uri).into(movieViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    static class MovieViewHolder extends RecyclerView.ViewHolder {

        private  ImageView imageView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_movie_item);
        }
    }
}
