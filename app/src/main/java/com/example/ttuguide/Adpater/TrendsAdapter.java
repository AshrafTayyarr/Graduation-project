package com.example.ttuguide.Adpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ttuguide.Domain.TrendsDomain;
import com.example.ttuguide.R;

import java.util.List;

public class TrendsAdapter extends RecyclerView.Adapter<TrendsAdapter.MyViewHolder> {
    private final List<TrendsDomain> itemList;



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView pic;
        public TextView titleText;
        public TextView subTitle;



        public MyViewHolder(View view) {
            super(view);
            pic = view.findViewById(R.id.pic);
            titleText = view.findViewById(R.id.titleTxt);
            subTitle = view.findViewById(R.id.subTitle);
        }
    }

    public TrendsAdapter(List<TrendsDomain> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_trend_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TrendsDomain item = itemList.get(position);
        holder.titleText.setText(item.getTitle());
        holder.subTitle.setText(item.getSubTitle());
        holder.pic.setImageResource(item.getImageResource());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}

