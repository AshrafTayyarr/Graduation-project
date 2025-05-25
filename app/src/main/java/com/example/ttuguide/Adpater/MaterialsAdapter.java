package com.example.ttuguide.Adpater;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ttuguide.Domain.MaterialsDomain;
import com.example.ttuguide.R;
import com.example.ttuguide.RecyclerViewInterface.Majors;

import java.util.List;

public class MaterialsAdapter extends RecyclerView.Adapter<MaterialsAdapter.MyViewHolder> {
    private  List<MaterialsDomain> itemList;
    private Majors recyclerViewInterface;

    public void setFilteredList(List<MaterialsDomain> filterdList){

        this.itemList=filterdList;

        notifyDataSetChanged();

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView background;
        public TextView titleText;
        public TextView hour;
        public TextView tvExplain;
        public int ddescription;

        public MyViewHolder(View view,Majors recyclerViewInterface) {
            super(view);
            background = view.findViewById(R.id.background);
            titleText = view.findViewById(R.id.titleText);
            hour = view.findViewById(R.id.hourText);
            tvExplain=view.findViewById(R.id.tvExplain);

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


    public MaterialsAdapter(List<MaterialsDomain> itemList, Majors recyclerViewInterface) {
        this.itemList = itemList;
        this.recyclerViewInterface = recyclerViewInterface;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhold_materials, parent, false);
        return new MyViewHolder(itemView,recyclerViewInterface);
    }


    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MaterialsDomain item = itemList.get(position);
        holder.titleText.setText(item.getTitle());
        holder.hour.setText(item.getHour());
        holder.background.setImageResource(item.getBackground());
        holder.tvExplain.setVisibility(item.getTextVisibility());
        holder.tvExplain.setText(item.getDescription());

    }
    public void updateTextVisibility(int position) {
        MaterialsDomain item = itemList.get(position);
        int newVisibility = (item.getTextVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;
        item.setTextVisibility(newVisibility); // Assuming you have a method to set visibility in your MajorDomain class
        notifyItemChanged(position);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}

