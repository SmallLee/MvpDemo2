package com.example.mvpdemo.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mvcdemo.R;
import com.example.mvpdemo.util.LogUtil;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2018/1/15.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context mContext;
    private List<String> mBitmaps;
    private OnImageClickListener mListenr;
    public interface OnImageClickListener{
        void onImageClick(int position);
    }
    public void setOnImageClickListener(OnImageClickListener listener){
        mListenr = listener;
    }
    public ImageAdapter(Context context,List<String> data){
        mContext = context;
        mBitmaps = data;
    }
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.image_item_layout, null, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(itemView);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(final ImageViewHolder holder, int position) {
        if (getItemCount() == 1 || position == getItemCount() - 1) {
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
        } else {
            LogUtil.e("1111111 :" + mBitmaps.get(position));
//            Picasso.with(mContext).load("file://"+mBitmaps.get(position)).into(holder.imageView);
            holder.imageView.setImageURI(Uri.fromFile(new File(mBitmaps.get(position))));
        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListenr.onImageClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        LogUtil.e("size : " + mBitmaps.size());
        return mBitmaps == null? 0 :  mBitmaps.size() + 1;
    }
    static class ImageViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_item);
        }
    }
}
