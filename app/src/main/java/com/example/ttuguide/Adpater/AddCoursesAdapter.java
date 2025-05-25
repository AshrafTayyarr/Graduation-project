package com.example.ttuguide.Adpater;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ttuguide.Domain.AddCoursesDomain;
import com.example.ttuguide.R;
import com.example.ttuguide.RecyclerViewInterface.AddCourses;

import java.util.List;

public class AddCoursesAdapter extends RecyclerView.Adapter<AddCoursesAdapter.MyViewHolder> {
    private List<AddCoursesDomain> itemList;
    private AddCourses recyclerViewInterface;

    public AddCoursesAdapter(List<AddCoursesDomain> itemList, AddCourses recyclerViewInterface) {
        this.itemList = itemList;
        this.recyclerViewInterface = recyclerViewInterface;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titleText;

        public MyViewHolder(View view, AddCourses recyclerViewInterface) {
            super(view);
            titleText = view.findViewById(R.id.titleText);

            view.setOnClickListener(v -> {
                if (recyclerViewInterface != null) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onAddItemClick(pos);

                    }
                }
            });

        }
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhold_addcourse, parent, false);
        return new MyViewHolder(itemView, recyclerViewInterface);
    }


    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AddCoursesDomain item = itemList.get(position);
        holder.titleText.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }




}

