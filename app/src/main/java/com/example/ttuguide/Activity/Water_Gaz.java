package com.example.ttuguide.Activity;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ttuguide.R;
import com.example.ttuguide.Adpater.MyAdapter;
import com.example.ttuguide.Domain.MyItem;

import java.util.ArrayList;
import java.util.List;
public class Water_Gaz extends Fragment {

    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    MyAdapter myAdapter1;
    MyAdapter myAdapter2;
    List<MyItem> itemList1;
    List<MyItem> itemList2;
    SearchView searchWater_Gaz;
    TextView textWater,textGaz;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_water__gaz, container, false);

        recyclerView1 = view.findViewById(R.id.view1);
        recyclerView2 = view.findViewById(R.id.view2);
        textWater = view.findViewById(R.id.textWater);
        textGaz = view.findViewById(R.id.textGaz);

        searchWater_Gaz=  view.findViewById(R.id.searchWater_Gaz);
        searchWater_Gaz.clearFocus();
        searchWater_Gaz.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        itemList1.add(new MyItem("مياه جبل الطفيلة","0776719124", R.drawable.water));
        itemList1.add(new MyItem("مياه جبل الطفيلة","0795485870", R.drawable.water));
        itemList1.add(new MyItem("مياه العيص","0790892751", R.drawable.water));
        itemList1.add(new MyItem(" مياه العيص","0787807950", R.drawable.water));

        myAdapter1 = new MyAdapter(itemList1);
        recyclerView1.setAdapter(myAdapter1);


        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        itemList2 = new ArrayList<>();
        itemList2.add(new MyItem("غاز حموده الزريقي", "0779335628", R.drawable.gaz));
        itemList2.add(new MyItem("غاز قيس البدور", "0776474723", R.drawable.gaz));
        itemList2.add(new MyItem("غاز الفيصلي", "0775273087", R.drawable.gaz));
        itemList2.add(new MyItem("غاز ايمن الشبيلات", "0776804258", R.drawable.gaz));
        itemList2.add(new MyItem("غاز سلمان السبول", "0775733169", R.drawable.gaz));
        myAdapter2 = new MyAdapter(itemList2);
        recyclerView2.setAdapter(myAdapter2);
        return view;
    }

    private void filterList(String text) {

        List<MyItem> filterdLitsWater = new ArrayList<>();
        List<MyItem> filterdLitsGaz = new ArrayList<>();
        for (MyItem item:itemList1){



            if(item.getTitle().toLowerCase().contains(text.toLowerCase())){
                filterdLitsWater.add(item);
            }

        }

        for (MyItem item:itemList2){

            if(item.getTitle().toLowerCase().contains(text.toLowerCase())){
                filterdLitsGaz.add(item);
            }

        }
        if (!filterdLitsWater.isEmpty() && filterdLitsGaz.isEmpty()) {
            recyclerView1.setVisibility(View.VISIBLE);
            recyclerView2.setVisibility(View.GONE);
            textGaz.setVisibility(View.GONE);
        } else if (!filterdLitsGaz.isEmpty() && filterdLitsWater.isEmpty()) {
            recyclerView2.setVisibility(View.VISIBLE);
            recyclerView1.setVisibility(View.GONE);
            textWater.setVisibility(View.GONE);
        } else {
            recyclerView1.setVisibility(View.VISIBLE);
            recyclerView2.setVisibility(View.VISIBLE);
            textWater.setVisibility(View.VISIBLE);
            textGaz.setVisibility(View.VISIBLE);
        }

        // Set the filtered lists to adapters
        myAdapter1.setFilteredList(filterdLitsWater);
        myAdapter2.setFilteredList(filterdLitsGaz);



    }

}