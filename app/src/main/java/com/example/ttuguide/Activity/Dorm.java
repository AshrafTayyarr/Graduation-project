package com.example.ttuguide.Activity;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ttuguide.Adpater.MyAdapter;
import com.example.ttuguide.Domain.MyItem;
import com.example.ttuguide.R;

import java.util.ArrayList;
import java.util.List;
public class Dorm extends Fragment {

     RecyclerView recyclerView1;
     RecyclerView recyclerView2;
     MyAdapter myAdapter1;
     MyAdapter myAdapter2;
     List<MyItem> itemList1;
     List<MyItem> itemList2;
     SearchView searchDorm;
     TextView textFemale,textMale;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dorm, container, false);

        recyclerView1 = view.findViewById(R.id.view1);
        recyclerView2 = view.findViewById(R.id.view2);
        textMale = view.findViewById(R.id.textMale);
        textFemale = view.findViewById(R.id.textFemale);

        searchDorm=  view.findViewById(R.id.searchDorm);
        ImageView icon = searchDorm.findViewById(androidx.appcompat.R.id.search_button);
        icon.setColorFilter(Color.WHITE);
        searchDorm.clearFocus();
        searchDorm.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        itemList1 = new ArrayList<>();
        itemList1.add(new MyItem("سكن الهدى","0798864019", R.drawable.dorm_pic));
        itemList1.add(new MyItem("سكن الراشد","0772219165", R.drawable.dorm_pic));
        itemList1.add(new MyItem("سكن العامر","0789999899", R.drawable.dorm_pic));
        itemList1.add(new MyItem(" سكن المحيسن","0779166433", R.drawable.dorm_pic));
        itemList1.add(new MyItem("سكن الحجاج","0772107071", R.drawable.dorm_pic));
        itemList1.add(new MyItem("سكن الشبيلات","0772218274", R.drawable.dorm_pic));
        itemList1.add(new MyItem("سكن القريش","0778379091", R.drawable.dorm_pic));
        itemList1.add(new MyItem("سكن الريان","0776103203", R.drawable.dorm_pic));
        itemList1.add(new MyItem("سكن السهارين","0785607979", R.drawable.dorm_pic));
        itemList1.add(new MyItem("سكن قصر الطفيلة","0772502313", R.drawable.dorm_pic));
        itemList1.add(new MyItem("سكن المصري","077620456", R.drawable.dorm_pic));
        itemList1.add(new MyItem("سكن الفريجات","0777759626", R.drawable.dorm_pic));
        itemList1.add(new MyItem("سكن الراوشدة","0795771065", R.drawable.dorm_pic));
        itemList1.add(new MyItem("سكن المعتز","0776764426", R.drawable.dorm_pic));
        myAdapter1 = new MyAdapter(itemList1);
        recyclerView1.setAdapter(myAdapter1);


        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        itemList2 = new ArrayList<>();
        itemList2.add(new MyItem("سكن البركة", "0799723797", R.drawable.dorm_pic));
        itemList2.add(new MyItem("سكن الاميرات", "0778701060", R.drawable.dorm_pic));
        itemList2.add(new MyItem("سكن الزهراء", "0775540126", R.drawable.dorm_pic));
        itemList2.add(new MyItem("سكن نسبية", "0770340018", R.drawable.dorm_pic));
        itemList2.add(new MyItem("سكن ابو وسيم", "0772060582", R.drawable.dorm_pic));
        itemList2.add(new MyItem("سكن الفاروق", "0775577970", R.drawable.dorm_pic));
        itemList2.add(new MyItem("سكن السبايلة", "0776688420", R.drawable.dorm_pic));
        myAdapter2 = new MyAdapter(itemList2);
        recyclerView2.setAdapter(myAdapter2);
        return view;
    }

    private void filterList(String text) {

        List<MyItem> filterdLitsMale = new ArrayList<>();
        List<MyItem> filterdLitsFemale = new ArrayList<>();
        for (MyItem item:itemList1){



            if(item.getTitle().toLowerCase().contains(text.toLowerCase())){
                filterdLitsMale.add(item);
            }

        }

        for (MyItem item:itemList2){

            if(item.getTitle().toLowerCase().contains(text.toLowerCase())){
                filterdLitsFemale.add(item);
            }

        }
        if (!filterdLitsMale.isEmpty() && filterdLitsFemale.isEmpty()) {
            recyclerView1.setVisibility(View.VISIBLE);
            recyclerView2.setVisibility(View.GONE);
            textFemale.setVisibility(View.GONE);
        } else if (!filterdLitsFemale.isEmpty() && filterdLitsMale.isEmpty()) {
            recyclerView2.setVisibility(View.VISIBLE);
            recyclerView1.setVisibility(View.GONE);
            textMale.setVisibility(View.GONE);
        } else {
            recyclerView1.setVisibility(View.VISIBLE);
            recyclerView2.setVisibility(View.VISIBLE);
            textMale.setVisibility(View.VISIBLE);
            textFemale.setVisibility(View.VISIBLE);
        }

        // Set the filtered lists to adapters
        myAdapter1.setFilteredList(filterdLitsMale);
        myAdapter2.setFilteredList(filterdLitsFemale);



    }

}