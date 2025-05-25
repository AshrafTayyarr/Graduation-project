package com.example.ttuguide.Adpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ttuguide.Domain.CollegeDomain;
import com.example.ttuguide.R;
import com.example.ttuguide.RecyclerViewInterface.Majors;

import java.util.List;

public class CollegeAdapter extends RecyclerView.Adapter<CollegeAdapter.MyViewHolder> {
    private List<CollegeDomain> itemList;
    private  final Majors recyclerViewInterface1;



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView background;
        public ImageView pic;
        public TextView titleText;
        public TextView hour;


        public MyViewHolder(View view,Majors recyclerViewInterface1) {
            super(view);
            pic = view.findViewById(R.id.pic);
            background = view.findViewById(R.id.background);
            titleText = view.findViewById(R.id.titleText);
            hour = view.findViewById(R.id.hourText);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface1 != null){
                        int poss = getAdapterPosition();

                        if(poss != RecyclerView.NO_POSITION){
                            recyclerViewInterface1.onItemClick(poss);
                        }
                    }
                }
            });

        }
    }

    public CollegeAdapter(List<CollegeDomain> itemList,Majors recyclerViewInterface1) {
        this.itemList = itemList;
        this.recyclerViewInterface1 = recyclerViewInterface1;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhold_colleges, parent, false);
        return new MyViewHolder(itemView,recyclerViewInterface1);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CollegeDomain item = itemList.get(position);
        holder.titleText.setText(item.getTitle());
        holder.hour.setText(item.getHour());
        holder.pic.setImageResource(item.getPicPath());
        holder.background.setImageResource(item.getBackground());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}

