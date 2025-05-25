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
public class Restaurant extends Fragment {

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
        View view= inflater.inflate(R.layout.fragment_restaurant, container, false);

        recyclerView1 = view.findViewById(R.id.view1);
        recyclerView2 = view.findViewById(R.id.view2);
        textMale = view.findViewById(R.id.textMale);
        textFemale = view.findViewById(R.id.textFemale);

        searchDorm=  view.findViewById(R.id.searchDorm);
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
        itemList1.add(new MyItem("مطعم المهندس", "0775773932", R.drawable.engineering));
        itemList1.add(new MyItem("مطعم البيت مندي ", "0776262034", R.drawable.mnde));
        itemList1.add(new MyItem("مطعم مستر شاورما", "0790399163", R.drawable.mrshwram));
        itemList1.add(new MyItem("مطعم لجين", "0791084649", R.drawable.lujyn));
        itemList1.add(new MyItem("مطعم قاع الهامور", "0780040420", R.drawable.spongpop));
        itemList1.add(new MyItem("مطعم اورغا", "0797760364", R.drawable.orga));
        itemList1.add(new MyItem("مطعم تشكن شوارما", "0791919145", R.drawable.chicken));
        itemList1.add(new MyItem("مطعم فرندز", "0790663937", R.drawable.empty));
        itemList1.add(new MyItem("مطعم جواد", "0775919516", R.drawable.empty));
        myAdapter1 = new MyAdapter(itemList1);
        recyclerView1.setAdapter(myAdapter1);


        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        itemList2 = new ArrayList<>();
        itemList2.add(new MyItem("دونات تايم", "0796125959", R.drawable.dount));
        itemList2.add(new MyItem("فروتيلا", "0777530797", R.drawable.frut));
        itemList2.add(new MyItem("حلويات المهندس", "0797729713", R.drawable.sweet1));
        itemList2.add(new MyItem("حلويات الخزامى", "0770089560", R.drawable.khzam));

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