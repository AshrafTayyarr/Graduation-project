package com.example.ttuguide.Adpater;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ttuguide.Domain.CourseStudyDomain;
import com.example.ttuguide.R;
import com.example.ttuguide.RecyclerViewInterface.Majors;

import java.util.List;

public class CoueseStudyAdapter extends RecyclerView.Adapter<CoueseStudyAdapter.MyViewHolder> {
    private  List<CourseStudyDomain> itemList;
    private Majors recyclerViewInterface;

    public void setFilteredList(List<CourseStudyDomain> filterdList){

        this.itemList=filterdList;

        notifyDataSetChanged();

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView background;
        public TextView titleText;
        public TextView tvExplain;
        public int ddescription;
        public TextView TeacherText;


        public MyViewHolder(View view,Majors recyclerViewInterface) {
            super(view);
            background = view.findViewById(R.id.background);
            titleText = view.findViewById(R.id.titleText);
            tvExplain=view.findViewById(R.id.tvExplain);
            TeacherText=view.findViewById(R.id.TeacherText);

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


    public CoueseStudyAdapter(List<CourseStudyDomain> itemList, Majors recyclerViewInterface) {
        this.itemList = itemList;
        this.recyclerViewInterface = recyclerViewInterface;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhold_coursestudy, parent, false);
        return new MyViewHolder(itemView,recyclerViewInterface);
    }


    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CourseStudyDomain item = itemList.get(position);
        holder.titleText.setText(item.getTitle());
        holder.background.setImageResource(item.getBackground());
        holder.tvExplain.setVisibility(item.getTextVisibility());
        holder.tvExplain.setText(item.getDescription());
        holder.TeacherText.setText(item.getTeacherText());

    }
    public void updateTextVisibility(int position) {
        CourseStudyDomain item = itemList.get(position);
        int newVisibility = (item.getTextVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;
        item.setTextVisibility(newVisibility); // Assuming you have a method to set visibility in your CourseStudyDomain class
        notifyItemChanged(position);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}

