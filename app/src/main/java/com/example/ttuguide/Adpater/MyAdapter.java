package com.example.ttuguide.Adpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ttuguide.Domain.MyItem;
import com.example.ttuguide.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<MyItem> itemList;

    public void setFilteredList(List<MyItem> filterdList){

        this.itemList=filterdList;

        notifyDataSetChanged();

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView pic;
        public TextView titleText;
        public TextView phoneNum;



        public MyViewHolder(View view) {
            super(view);
            pic = view.findViewById(R.id.pic);
            titleText = view.findViewById(R.id.titleText);
            phoneNum = view.findViewById(R.id.phoneNum);
        }
    }

    public MyAdapter(List<MyItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyItem item = itemList.get(position);
        holder.titleText.setText(item.getTitle());
        holder.phoneNum.setText(item.getPhoneNumber());
        holder.pic.setImageResource(item.getImageResource());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}

