package com.example.mvpdemo.view.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;

/**
 * Created by Administrator on 2018/1/14.
 */
public class RefreshLayout extends PtrClassicFrameLayout {
    public RefreshLayout(Context context) {
       this(context,null);
    }

    public RefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initHeaderAndFooterView();
    }
    public void initHeaderAndFooterView(){
        RefreshHeaderView headerView = new RefreshHeaderView(getContext());
        addPtrUIHandler(headerView);
        setFooterView(new LoadMoreFooterView());
    }

    public RecyclerAdapterWithHF getHFAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        return new RecyclerAdapterWithHF(adapter);
    }
}
