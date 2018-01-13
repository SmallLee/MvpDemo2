package com.example.mvpdemo.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;

import java.util.List;

/**
 * Created by Administrator on 2018/1/13.
 */
public class BaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<T> mData;
    private int itemLayout;
    public BaseAdapter(Context context, List<T> data,int itemLayoutId) {
        RecyclerAdapterWithHF recyclerAdapterWithHF = new RecyclerAdapterWithHF(this);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
