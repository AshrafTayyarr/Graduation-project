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

import com.example.ttuguide.Adpater.MyAdapter;
import com.example.ttuguide.Domain.MyItem;
import com.example.ttuguide.R;

import java.util.ArrayList;
import java.util.List;
public class Bus extends Fragment {

    RecyclerView recyclerView1,recyclerView2;
    MyAdapter myAdapter1,myAdapter2;
    List<MyItem> itemList1,itemList2;
    SearchView searchBus;
    TextView textGroups,textBus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_bus, container, false);

        recyclerView1 = view.findViewById(R.id.view1);
        recyclerView2 = view.findViewById(R.id.view2);
        textBus = view.findViewById(R.id.textBus);
        textGroups = view.findViewById(R.id.textGroups);

        searchBus=  view.findViewById(R.id.searchBus);
        searchBus.clearFocus();
        searchBus.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        itemList1.add(new MyItem("يزن المرافي (عمان)","0775221647", R.drawable.bus));
        itemList1.add(new MyItem(" جاسر البدور (اربد)","0772219225", R.drawable.bus));
        itemList1.add(new MyItem("ابو علاء (الزرقاء)","0777692018", R.drawable.bus));
        itemList1.add(new MyItem("ابو راشد (العقبة)","0772040295", R.drawable.bus));

        myAdapter1 = new MyAdapter(itemList1);
        recyclerView1.setAdapter(myAdapter1);


        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        itemList2 = new ArrayList<>();
        itemList2.add(new MyItem("سكن البركة", "0799723797", R.drawable.facebook));
        itemList2.add(new MyItem("سكن الاميرات", "0778701060", R.drawable.whatsapp));
        myAdapter2 = new MyAdapter(itemList2);
        recyclerView2.setAdapter(myAdapter2);

        return view;
    }

    private void filterList(String text) {

        List<MyItem> filterdLitsBus = new ArrayList<>();
        List<MyItem> filterdLitsGroup = new ArrayList<>();
        for (MyItem item:itemList1){



            if(item.getTitle().toLowerCase().contains(text.toLowerCase())){
                filterdLitsBus.add(item);
            }

        }

        for (MyItem item:itemList2){

            if(item.getTitle().toLowerCase().contains(text.toLowerCase())){
                filterdLitsGroup.add(item);
            }

        }


        if (!filterdLitsBus.isEmpty() && filterdLitsGroup.isEmpty()) {
            recyclerView1.setVisibility(View.VISIBLE);
            recyclerView2.setVisibility(View.GONE);
            textGroups.setVisibility(View.GONE);
        } else if (!filterdLitsGroup.isEmpty() && filterdLitsBus.isEmpty()) {
            recyclerView2.setVisibility(View.VISIBLE);
            recyclerView1.setVisibility(View.GONE);
            textBus.setVisibility(View.GONE);
        } else {
            recyclerView1.setVisibility(View.VISIBLE);
            recyclerView2.setVisibility(View.VISIBLE);
            textBus.setVisibility(View.VISIBLE);
            textGroups.setVisibility(View.VISIBLE);
        }

        // Set the filtered lists to adapters
        myAdapter1.setFilteredList(filterdLitsBus);
        myAdapter2.setFilteredList(filterdLitsGroup);



    }

}