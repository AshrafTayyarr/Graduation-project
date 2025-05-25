package com.example.ttuguide.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.ttuguide.R;


public class InFragment extends Fragment {

    CardView Majors,CourseStudy,cardStudentGate,cardMaterials,cardSchedule,cardOnline,cardMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.university_in, container, false);

        Majors= view.findViewById(R.id.cardMajors);
        Majors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment Majors = new Colleges();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.UniversityIn, Majors,null).addToBackStack(null).commit();
            }
        });
        CourseStudy=view.findViewById(R.id.cardCourseStudy);
        CourseStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment CourseStudy = new CourseStudy();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.UniversityIn, CourseStudy,null).addToBackStack(null).commit();
            }
        });


        cardStudentGate=view.findViewById(R.id.cardStudentGate);
        cardStudentGate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment Gate = new Gate();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.UniversityIn, Gate,null).addToBackStack(null).commit();
            }
        });

        cardMaterials=view.findViewById(R.id.cardMaterials);
        cardMaterials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment Materials = new Materials();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.UniversityIn, Materials,null).addToBackStack(null).commit();
            }
        });

        cardSchedule=view.findViewById(R.id.cardSchedule);
        cardSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment Schedule = new Schedule();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.UniversityIn, Schedule,null).addToBackStack(null).commit();
            }
        });

        cardOnline=view.findViewById(R.id.cardOnline);
        cardOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment Online = new Online();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.UniversityIn, Online,null).addToBackStack(null).commit();
            }
        });

        cardMap=view.findViewById(R.id.cardMap);
        cardMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment Map = new Map();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.UniversityIn, Map,null).addToBackStack(null).commit();
            }
        });

        return view;
    }
}