package com.example.ttuguide.Adpater;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ttuguide.Domain.OnlineDomain;
import com.example.ttuguide.R;
import com.example.ttuguide.RecyclerViewInterface.Majors;

import java.util.List;

public class OnlineAdapter extends RecyclerView.Adapter<OnlineAdapter.MyViewHolder> {
    private final List<OnlineDomain> itemList;
    private  final Majors recyclerViewInterface;



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView background;
        public TextView titleText;
        public ImageView pic;



        public MyViewHolder(View view,Majors recyclerViewInterface) {
            super(view);
            background = view.findViewById(R.id.background);
            titleText = view.findViewById(R.id.titleText);
            pic = view.findViewById(R.id.pic);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }


    public OnlineAdapter(List<OnlineDomain> itemList, Majors recyclerViewInterface) {
        this.itemList = itemList;
        this.recyclerViewInterface = recyclerViewInterface;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhold_online, parent, false);
        return new MyViewHolder(itemView,recyclerViewInterface);
    }


    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OnlineDomain item = itemList.get(position);
        holder.titleText.setText(item.getTitle());
        holder.background.setImageResource(item.getBackground());
        holder.pic.setImageResource(item.getPicPath());



    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }
}

