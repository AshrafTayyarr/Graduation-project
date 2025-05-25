package com.example.ttuguide.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ttuguide.Adpater.MajorAdapter;
import com.example.ttuguide.Domain.MajorDomain;
import com.example.ttuguide.R;
import com.example.ttuguide.RecyclerViewInterface.Majors;

import java.util.ArrayList;
import java.util.List;


public class Science extends Fragment implements Majors {

    RecyclerView recyclerView;
    MajorAdapter myAdapter;
    List<MajorDomain> itemList;
    CardView cardback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_science, container, false);


        recyclerView=view.findViewById(R.id.view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        itemList=new ArrayList<>();
        itemList.add(new MajorDomain("Mathematics"," 134",R.drawable.bg_1,R.string.Mathematics));
        itemList.add(new MajorDomain("Applied Life Sciences"," 134",R.drawable.bg_3,R.string.AppliedBiologicalSciences));
        itemList.add(new MajorDomain("Applied Physics"," 134",R.drawable.bg_4,R.string.AppliedPhysics));
        itemList.add(new MajorDomain("Chemistry"," 134",R.drawable.bg_5,R.string.Chemistry));
        itemList.add(new MajorDomain("Chemistry Technology"," 134",R.drawable.bg_4,R.string.ChemicalTechnology));
        myAdapter=new MajorAdapter(itemList,this);
        recyclerView.setAdapter(myAdapter);

        cardback=view.findViewById(R.id.cardback);
        cardback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment Colleges = new Colleges();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.Science ,Colleges,null).commit();
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

            case 3:
                myAdapter.updateTextVisibility(3);

                break;

            case 4:
                myAdapter.updateTextVisibility(4);

                break;

            case 5:
                myAdapter.updateTextVisibility(5);

                break;


        }
    }
}