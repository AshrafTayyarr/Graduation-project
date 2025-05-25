package com.example.ttuguide.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ttuguide.Adpater.MapAdapter;
import com.example.ttuguide.Domain.MapDomain;
import com.example.ttuguide.R;
import com.example.ttuguide.RecyclerViewInterface.Majors;

import java.util.ArrayList;
import java.util.List;


public class Map extends Fragment implements Majors {
    
    RecyclerView recyclerView;
    MapAdapter myAdapter;
    List<MapDomain> itemList;
    CardView cardback;
    SearchView searchMaterials;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);

            recyclerView=view.findViewById(R.id.view);

            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
            itemList=new ArrayList<>();
            itemList.add(new MapDomain("Floor 1","",R.drawable.bg_1,R.drawable.floor1));
            itemList.add(new MapDomain("Floor 2","",R.drawable.bg_2,R.drawable.floor1));
            itemList.add(new MapDomain("Floor 3","",R.drawable.bg_3,R.drawable.floor1));

            myAdapter=new MapAdapter(itemList,this);
            recyclerView.setAdapter(myAdapter);

            cardback=view.findViewById(R.id.cardback);
            cardback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment UniversityIn = new InFragment() ;
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.Map ,UniversityIn,null).commit();
                }
            });


            return view;
        }

        @Override
        public void onItemClick(int position) {
            switch (position){

                case 0:
                    myAdapter.updateTextVisibility(0);
                    break;
                case 1:
                    myAdapter.updateTextVisibility(1);
                    break;
                case 2:
                    myAdapter.updateTextVisibility(2);
                    break;

            }
        }
        

}