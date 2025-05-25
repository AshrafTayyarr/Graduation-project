package com.example.ttuguide.Adpater;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ttuguide.Domain.ScheduleDomain;
import com.example.ttuguide.R;
import com.example.ttuguide.RecyclerViewInterface.DeleteCourse;
import com.example.ttuguide.RecyclerViewInterface.Majors;
import com.example.ttuguide.RecyclerViewInterface.OnSpinner;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.MyViewHolder> {
    private  List<ScheduleDomain> itemList;
    private Majors recyclerViewInterface;
    private DeleteCourse recyclerViewInterfaceDelete;
    private OnSpinner recyclerViewInterfaceSpinner;

    public void setFilteredList(List<ScheduleDomain> filterdList){

        this.itemList=filterdList;

        notifyDataSetChanged();

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView background;
        public TextView titleText;
        public TextView hour;
        public TextView tvExplain;
        public int ddescription;
        public Spinner spnAlarm;


        public MyViewHolder(View view, Majors recyclerViewInterface, DeleteCourse recyclerViewInterfaceDelete, OnSpinner recyclerViewInterfaceSpinner) {
            super(view);
            background = view.findViewById(R.id.background);
            titleText = view.findViewById(R.id.titleText);
            hour = view.findViewById(R.id.hourText);
            tvExplain=view.findViewById(R.id.tvExplain);
            spnAlarm = view.findViewById(R.id.spnAlarm); // new spinner


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

            view.setOnLongClickListener(v -> {
                if (recyclerViewInterface != null) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        recyclerViewInterfaceDelete.onItemLongClick(pos);
                        return true;
                    }
                }
                return false;
            });

            spnAlarm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (recyclerViewInterfaceSpinner != null) {
                        int adapterPosition = getAdapterPosition();
                        if (adapterPosition != RecyclerView.NO_POSITION) {
                            recyclerViewInterfaceSpinner.SpinnerClick(adapterPosition, position);
                        }
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }
    }


    public ScheduleAdapter(List<ScheduleDomain> itemList, Majors recyclerViewInterface, DeleteCourse recyclerViewInterfaceDelete, OnSpinner recyclerViewInterfaceSpinner) {
        this.itemList = itemList;
        this.recyclerViewInterface = recyclerViewInterface;
        this.recyclerViewInterfaceDelete = recyclerViewInterfaceDelete;
        this.recyclerViewInterfaceSpinner=recyclerViewInterfaceSpinner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhold_schedule, parent, false);
        return new MyViewHolder(itemView,recyclerViewInterface,recyclerViewInterfaceDelete,recyclerViewInterfaceSpinner);
    }


    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ScheduleDomain item = itemList.get(position);
        holder.titleText.setText(item.getTitle());
        holder.hour.setText(item.getHour());
        holder.background.setImageResource(item.getBackground());
        holder.tvExplain.setVisibility(item.getTextVisibility());
        holder.tvExplain.setText(item.getDescription());

        holder.spnAlarm.setSelection(item.getAlarmSelection());

    }
    public void updateTextVisibility(int position) {
        ScheduleDomain item = itemList.get(position);
        int newVisibility = (item.getTextVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;
        item.setTextVisibility(newVisibility); // Assuming you have a method to set visibility in your MajorDomain class
        notifyItemChanged(position);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}

