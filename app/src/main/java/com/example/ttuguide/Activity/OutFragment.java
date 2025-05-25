package com.example.ttuguide.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.ttuguide.R;


public class OutFragment extends Fragment {

    CardView Dorm,Restaurant,Libraries,WaterGaz,Bus,cardLocation;

    TextView tvTitle_in;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.university_out, container, false);
        Dorm= view.findViewById(R.id.cardDorm);
        Restaurant= view.findViewById(R.id.cardRestaurant);
        Libraries= view.findViewById(R.id.cardLibraries);
        WaterGaz= view.findViewById(R.id.cardWatergaz);
        cardLocation= view.findViewById(R.id.cardLocation);
        Bus= view.findViewById(R.id.cardBus);



        Dorm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment Dorm = new Dorm();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.UniversityOut, Dorm,null).addToBackStack(null).commit();

            }
        });

        Restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment Restaurant = new Restaurant();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.UniversityOut, Restaurant,null).addToBackStack(null).commit();
            }
        });

        Libraries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment Libraries = new Libraries();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.UniversityOut, Libraries,null).addToBackStack(null).commit();

            }
        });

        WaterGaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment Water_Gaz = new Water_Gaz();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.UniversityOut, Water_Gaz,null).addToBackStack(null).commit();
            }
        });

        Bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment Bus = new Bus();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.UniversityOut, Bus,null).addToBackStack(null).commit();
            }
        });

        cardLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment Location = new Location();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.UniversityOut, Location,null).addToBackStack(null).commit();
            }
        });


        return view;
    }


}