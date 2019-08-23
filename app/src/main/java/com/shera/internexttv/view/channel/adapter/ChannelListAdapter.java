package com.shera.internexttv.view.channel.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shera.internexttv.R;
import com.shera.internexttv.model.CategoryDTO;
import com.shera.internexttv.model.LiveChannelDTO;
import com.shera.internexttv.view.live.LiveActivity;
import com.shera.internexttv.view.live.StreamActivity;

import java.util.ArrayList;

public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.ViewHolder> {

    private ArrayList<LiveChannelDTO> mValues;
    private Context mContext;

    public ChannelListAdapter(ArrayList<LiveChannelDTO> mValues, Context mContext) {
        this.mValues = mValues;
        this.mContext = mContext;
    }
    public void setNewList(ArrayList<LiveChannelDTO> mValues){
        this.mValues=mValues;
    }

    @NonNull
    @Override
    public ChannelListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.channel_list_cell_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.categoryNameTxt.setText(mValues.get(position).getName());
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(mContext, LiveActivity.class);
                Bundle b= new Bundle();
                b.putString("id",mValues.get(position).getStream_id()+"");
                i.putExtras(b);
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView categoryNameTxt;
        LinearLayout linearLayout;
        public ViewHolder(View v) {
            super(v);
            categoryNameTxt=(TextView) v.findViewById(R.id.category_name);
            linearLayout=(LinearLayout) v.findViewById(R.id.cell);
        }
    }

}
