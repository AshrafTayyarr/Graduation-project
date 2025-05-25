package com.example.ttuguide.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ttuguide.Adpater.TrendsAdapter;
import com.example.ttuguide.Domain.TrendsDomain;
import com.example.ttuguide.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    TrendsAdapter myAdapter;
    List<TrendsDomain> itemList;
    LinearLayout cardNote,cardWeb,cardSchedule;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView=view.findViewById(R.id.view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        itemList = new ArrayList<>();
        itemList.add(new TrendsDomain("Tafila Technical University congratulates you on\nthe arrival of the new Hijri year 1446 AH","", R.drawable.news1));
        itemList.add(new TrendsDomain("The trustees of Tafila Technical University congratulate the new Hijri year 1446 AH","", R.drawable.news2));
        itemList.add(new TrendsDomain("The Board of Trustees of “Tafila Technical School” holds a meeting at the university headquarters","", R.drawable.news3));
        itemList.add(new TrendsDomain("Tafila Tech and American Bridgewater hold a scientific conference in Boston","", R.drawable.news4));

        myAdapter = new TrendsAdapter(itemList);
        recyclerView.setAdapter(myAdapter);

        cardNote=view.findViewById(R.id.cardNote);
        cardNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment Note_ = new Note_();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.Home, Note_,null).addToBackStack(null).commit();

            }
        });


        cardWeb=view.findViewById(R.id.cardWeb);
        cardWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ttu.edu.jo/"));
                startActivity(browserIntent);

            }
        });

        cardSchedule=view.findViewById(R.id.cardSchedule);
        cardSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment schedule = new Schedule();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.Home, schedule,null).addToBackStack(null).commit();

            }
        });

        return view;
    }
}