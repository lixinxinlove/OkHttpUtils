package com.lee.glidedemo.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lee.glidedemo.R;

import java.util.List;

/**
 * Created by android on 2017/4/1.
 */
public class RVAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public RVAdapter( List<String> data) {
        super(R.layout.item_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_text, item);
    }
}
