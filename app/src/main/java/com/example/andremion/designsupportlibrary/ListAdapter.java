package com.example.andremion.designsupportlibrary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> implements View.OnClickListener {

    private final List<String> mItems;
    private OnItemClickListener mItemClickListener;

    public ListAdapter(List<String> items) {
        mItems = items;
    }

    public void setOnItemClickListener(OnItemClickListener l) {
        mItemClickListener = l;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mItemView.setTag(position);
        holder.mTextView.setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onClick(View v) {
        if (mItemClickListener != null) {
            mItemClickListener.onItemClick(v, (Integer) v.getTag());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final View mItemView;
        private final TextView mTextView;

        private ViewHolder(View v) {
            super(v);
            mItemView = v;
            mTextView = (TextView) v.findViewById(android.R.id.text1);
        }
    }
}