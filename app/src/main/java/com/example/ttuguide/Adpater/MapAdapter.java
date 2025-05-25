package com.example.ttuguide.Adpater;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ttuguide.Domain.MapDomain;
import com.example.ttuguide.R;
import com.example.ttuguide.RecyclerViewInterface.Majors;
import com.ortiz.touchview.TouchImageView;

import java.util.List;

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.MyViewHolder> {
    private  List<MapDomain> itemList;
    private Majors recyclerViewInterface;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView background;
        public TextView titleText;
        public TextView hour;
        public TouchImageView descriptionPic;

        public MyViewHolder(View view,Majors recyclerViewInterface) {
            super(view);
            background = view.findViewById(R.id.background);
            titleText = view.findViewById(R.id.titleText);
            hour = view.findViewById(R.id.hourText);
            descriptionPic= view.findViewById(R.id.descriptionPic);

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


    public MapAdapter(List<MapDomain> itemList, Majors recyclerViewInterface) {
        this.itemList = itemList;
        this.recyclerViewInterface = recyclerViewInterface;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhold_map, parent, false);
        return new MyViewHolder(itemView,recyclerViewInterface);
    }


    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MapDomain item = itemList.get(position);
        holder.titleText.setText(item.getTitle());
        holder.hour.setText(item.getHour());
        holder.background.setImageResource(item.getBackground());
        holder.descriptionPic.setVisibility(item.getPicVisibility());
        holder.descriptionPic.setImageResource(item.getDescriptionPic());

    }
    public void updateTextVisibility(int position) {
        MapDomain item = itemList.get(position);
        int newVisibility = (item.getPicVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;
        item.setPicVisibility(newVisibility); // Assuming you have a method to set visibility in your MajorDomain class
        notifyItemChanged(position);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}

