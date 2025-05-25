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

import com.example.ttuguide.Adpater.CollegeAdapter;
import com.example.ttuguide.Domain.CollegeDomain;
import com.example.ttuguide.R;
import com.example.ttuguide.RecyclerViewInterface.Majors;

import java.util.ArrayList;
import java.util.List;


public class Colleges extends Fragment implements Majors {

    RecyclerView recyclerView;
    CollegeAdapter myAdapter;
    List<CollegeDomain> itemList;
    CardView cardback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_colleges, container, false);

        recyclerView=view.findViewById(R.id.view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        itemList=new ArrayList<>();
        itemList.add(new CollegeDomain("IT","134",R.drawable.it,R.drawable.bg_1));
        itemList.add(new CollegeDomain("Engineering","164",R.drawable.engineer,R.drawable.bg_2));
        itemList.add(new CollegeDomain("Science","134",R.drawable.science,R.drawable.bg_3));
        itemList.add(new CollegeDomain("Business","134",R.drawable.business,R.drawable.bg_4));
        myAdapter=new CollegeAdapter(itemList,this);
        recyclerView.setAdapter(myAdapter);


        cardback=view.findViewById(R.id.cardback);
        cardback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment UinversityOut = new InFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.UniversityIn ,UinversityOut,null).commit();
            }
        });

        return view;
    }

    @Override
    public void onItemClick(int position) {
        switch (position){

            case 0:
                Fragment IT = new IT();
                FragmentTransaction transactionIT = getActivity().getSupportFragmentManager().beginTransaction();
                transactionIT.replace(R.id.Colleges, IT,null).addToBackStack(null).commit();
                break;

            case 1:
                Fragment Engineer = new Engineer();
                FragmentTransaction transactionEngineer = getActivity().getSupportFragmentManager().beginTransaction();
                transactionEngineer.replace(R.id.Colleges, Engineer,null).addToBackStack(null).commit();
                break;

            case 2:
                Fragment Science = new Science();
                FragmentTransaction transactionScience = getActivity().getSupportFragmentManager().beginTransaction();
                transactionScience.replace(R.id.Colleges, Science,null).addToBackStack(null).commit();
                break;

            case 3:
                Fragment Business = new Business();
                FragmentTransaction transactionBusiness = getActivity().getSupportFragmentManager().beginTransaction();
                transactionBusiness.replace(R.id.Colleges, Business,null).addToBackStack(null).commit();
                break;


        }
    }
}