package com.feicuiedu.butterknife_20170502;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gqq on 2017/5/2.
 */

public class CustomAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent);
//            viewHolder = new ViewHolder(convertView);
        }

        return null;
    }

    static class ViewHolder {
        @BindView(R.id.tvShow)
        TextView mTvShow;
        @BindView(R.id.btnShow)
        Button mBtnShow;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

//    class ViewHolder{
//
//        @BindView(R.id.tvShow)
//        TextView mTextView;
//        @BindView(R.id.btnShow)
//        Button mButton;
//
//        public ViewHolder(View view) {
//            ButterKnife.bind(this,view);
//        }
//    }
}
