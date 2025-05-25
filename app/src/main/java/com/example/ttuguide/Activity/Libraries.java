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


public class Libraries extends Fragment {

    RecyclerView recyclerView1;
    MyAdapter myAdapter1;
    List<MyItem> itemList1;
    SearchView searchLibraries;
    TextView textLibraries;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_libraries, container, false);

        recyclerView1 = view.findViewById(R.id.view1);

        searchLibraries=  view.findViewById(R.id.searchLibraries);
        searchLibraries.clearFocus();
        searchLibraries.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        itemList1.add(new MyItem("مكتبة الطالب","0777925583", R.drawable.stationery));
        itemList1.add(new MyItem("مكتبة عكاظ","0777275791", R.drawable.stationery));
        itemList1.add(new MyItem("مكتبة عوره","0776614558", R.drawable.stationery));
        itemList1.add(new MyItem(" مكتبة القدس","0771082556", R.drawable.stationery));
        itemList1.add(new MyItem("مكتبة حسام","0772107071", R.drawable.stationery));
        itemList1.add(new MyItem("مكتبة العراب","0772218274", R.drawable.stationery));
        itemList1.add(new MyItem("مكتبة ال البيت","0778379091", R.drawable.stationery));
        itemList1.add(new MyItem("مكتبة صهيب","0776103203", R.drawable.stationery));
        myAdapter1 = new MyAdapter(itemList1);
        recyclerView1.setAdapter(myAdapter1);


        return view;
    }

    private void filterList(String text) {

        List<MyItem> filterdLitsLibraries = new ArrayList<>();
        for (MyItem item:itemList1){



            if(item.getTitle().toLowerCase().contains(text.toLowerCase())){
                filterdLitsLibraries.add(item);
            }

        }

        // Set the filtered lists to adapters
        myAdapter1.setFilteredList(filterdLitsLibraries);



    }
}