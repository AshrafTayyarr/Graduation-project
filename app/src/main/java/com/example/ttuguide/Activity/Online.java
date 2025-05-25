package com.example.ttuguide.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ttuguide.Adpater.OnlineAdapter;
import com.example.ttuguide.Domain.OnlineDomain;
import com.example.ttuguide.R;
import com.example.ttuguide.RecyclerViewInterface.Majors;

import java.util.ArrayList;
import java.util.List;


public class Online extends Fragment implements Majors {

    RecyclerView recyclerView;
    OnlineAdapter myAdapter;
    List<OnlineDomain> itemList;
    CardView cardback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_online, container, false);

        recyclerView=view.findViewById(R.id.view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        itemList=new ArrayList<>();
        itemList.add(new OnlineDomain("C++",R.drawable.bg_1,R.drawable.youtube));
        itemList.add(new OnlineDomain("Object-Oriented\nProgramming C++",R.drawable.bg_2,R.drawable.youtube));
        itemList.add(new OnlineDomain("Data Structures",R.drawable.bg_3,R.drawable.youtube));
        itemList.add(new OnlineDomain("Computer Networking",R.drawable.bg_4,R.drawable.youtube));
        itemList.add(new OnlineDomain("DataBase",R.drawable.bg_5,R.drawable.youtube));
        itemList.add(new OnlineDomain("Python",R.drawable.bg_1,R.drawable.youtube));
        itemList.add(new OnlineDomain("Algorithms",R.drawable.bg_2,R.drawable.youtube));
        itemList.add(new OnlineDomain("Java",R.drawable.bg_3,R.drawable.youtube));
        itemList.add(new OnlineDomain("Ai",R.drawable.bg_4,R.drawable.youtube));
        itemList.add(new OnlineDomain("Html&Css",R.drawable.bg_5,R.drawable.youtube));
        itemList.add(new OnlineDomain("JavaScript",R.drawable.bg_1,R.drawable.youtube));
        itemList.add(new OnlineDomain("Operating System",R.drawable.bg_1,R.drawable.youtube));
        itemList.add(new OnlineDomain("Software Engineering",R.drawable.bg_2,R.drawable.youtube));
        itemList.add(new OnlineDomain("Discrete Mathematics",R.drawable.bg_3,R.drawable.youtube));
        myAdapter=new OnlineAdapter(itemList,this);
        recyclerView.setAdapter(myAdapter);


        cardback=view.findViewById(R.id.cardback);
        cardback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment UniversityIn = new InFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.Online ,UniversityIn,null).commit();
            }
        });

        return view;
    }

    @Override
    public void onItemClick(int position) {
        switch (position){

            case 0:
                Youtube("https://www.youtube.com/playlist?list=PLCInYL3l2AajFAiw4s1U4QbGszcQ-rAb3");
                break;

            case 1:
                Youtube("https://www.youtube.com/playlist?list=PLCInYL3l2Aaiq1oLvi9TlWtArJyAuCVow");

                break;

            case 2:
                Youtube("https://www.youtube.com/playlist?list=PLCInYL3l2AajqOUW_2SwjWeMwf4vL4RSp");

                break;


            case 3:
                Youtube("https://www.youtube.com/playlist?list=PLHKTPL-jkzUqRPIzSeayjdxqXotMXK2T9");

                break;


            case 4:
                Youtube("https://www.youtube.com/playlist?list=PLdUHNiwJgn86K6sa3TniXWnWwUG0wf8_9");

                break;


            case 5:
                Youtube("https://www.youtube.com/playlist?list=PLpF8PQrD1grJbYkeQ_TsKJQV0UweH7kaW");

                break;

            case 6:
                Youtube("https://www.youtube.com/playlist?list=PLAwv14VhKVaa1A6nAaNb7i78t9cFOUwBB");

                break;

            case 7:
                Youtube("https://www.youtube.com/playlist?list=PLCInYL3l2AajYlZGzU_LVrHdoouf8W6ZN");

                break;

            case 8:
                Youtube("https://www.youtube.com/playlist?list=PL9fwy3NUQKwZSyBItVAznODDDreSIW46P");

                break;

            case 9:
                Youtube("https://www.youtube.com/playlist?list=PLknwEmKsW8OuN04Odt2sJqt4aAnkp-iYA");

                break;

            case 10:
                Youtube("https://www.youtube.com/playlist?list=PLknwEmKsW8OsnUAj3ThlerzPeMKk9GXXR");

                break;

            case 11:
                Youtube("https://www.youtube.com/playlist?list=PLKlTaCM87WvrO0RElCsK30uS-ylzRLgFM");

                break;

            case 12:
                Youtube("https://www.youtube.com/playlist?list=PLOEkz33t1rDnvnX0x57CjTN0VWWmqq3qu");

                break;

            case 13:
                Youtube("https://www.youtube.com/playlist?list=PLxIvc-MGOs6gZlMVYOOEtUHJmfUquCjwz");

                break;



        }
    }
    public void Youtube(String url){

        try {

            Uri uri= Uri.parse(url);
            startActivity(new Intent(Intent.ACTION_VIEW,uri));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}