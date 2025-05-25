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


public class Engineer extends Fragment implements Majors {
    RecyclerView recyclerView;
    MajorAdapter myAdapter;
    List<MajorDomain> itemList;
    CardView cardback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_engineer, container, false);



        recyclerView=view.findViewById(R.id.view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        itemList=new ArrayList<>();
        itemList.add(new MajorDomain("Computer Engineering"," 164",R.drawable.bg_4, R.string.ComputerEngineering));
        itemList.add(new MajorDomain("Geological Engineering"," 164",R.drawable.bg_1,R.string.GeologicalEngineering));
        itemList.add(new MajorDomain("Mining Engineering"," 164",R.drawable.bg_2,R.string.MiningEngineering));
        itemList.add(new MajorDomain("Electrical Power\nEngineering"," 164",R.drawable.bg_3,R.string.ElectricalPowerEngineering));
        itemList.add(new MajorDomain("Civil Engineering"," 164",R.drawable.bg_4,R.string.CivilEngineering));
        itemList.add(new MajorDomain("Intelligent Systems\nEngineering"," 164",R.drawable.bg_4,R.string.SmartSystemsEngineering));
        itemList.add(new MajorDomain("Chemical Industries\nEngineering"," 164",R.drawable.bg_4,R.string.ChemicalEngineering));
        itemList.add(new MajorDomain("Mechatronics Engineering"," 164",R.drawable.bg_4,R.string.MechatronicsEngineering));
        itemList.add(new MajorDomain("Integrated Renewable\nEnergy Engineering"," 164",R.drawable.bg_4,R.string.IntegratedRenewableEnergyEngineering));
        itemList.add(new MajorDomain("Mechanical Engineering\nHybrid Vehicle Technology"," 164",R.drawable.bg_4,R.string.Vehicles));
        itemList.add(new MajorDomain("Mechanical Engineering\nProduction and Machinery"," 164",R.drawable.bg_4,R.string.MechanicalEngineeringProductionandMachines));
        itemList.add(new MajorDomain("Mechanical EngineeringHeating\nVentilation and Air Conditioning"," 164",R.drawable.bg_4,R.string.AirConditioning));
        itemList.add(new MajorDomain("Telecommunications Electronics\nEngineering"," 164",R.drawable.bg_4,R.string.Communications));
        myAdapter=new MajorAdapter(itemList,this);
        recyclerView.setAdapter(myAdapter);

        cardback=view.findViewById(R.id.cardback);
        cardback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment Colleges = new Colleges();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.Engineer ,Colleges,null).commit();
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


            case 6:
                myAdapter.updateTextVisibility(6);

                break;

            case 7:
                myAdapter.updateTextVisibility(7);

                break;

            case 8:
                myAdapter.updateTextVisibility(8);

                break;

            case 9:
                myAdapter.updateTextVisibility(9);

                break;

            case 10:
                myAdapter.updateTextVisibility(10);

                break;

            case 11:
                myAdapter.updateTextVisibility(11);

                break;

            case 12:
                myAdapter.updateTextVisibility(12);

                break;

            case 13:
                myAdapter.updateTextVisibility(13);

                break;


        }
    }
}