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

import com.example.ttuguide.Adpater.MaterialsAdapter;
import com.example.ttuguide.Domain.MaterialsDomain;
import com.example.ttuguide.R;
import com.example.ttuguide.RecyclerViewInterface.Majors;

import java.util.ArrayList;
import java.util.List;


public class Materials extends Fragment implements Majors {

    RecyclerView recyclerView;
    MaterialsAdapter myAdapter;
    List<MaterialsDomain> itemList;
    CardView cardback;
    SearchView searchMaterials;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_materials, container, false);

        recyclerView=view.findViewById(R.id.view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        itemList=new ArrayList<>();
        itemList.add(new MaterialsDomain("Operating Systems"," 3",R.drawable.bg_1,R.string.operating_systems));
        itemList.add(new MaterialsDomain("Human Computer Interaction"," 3",R.drawable.bg_2,R.string.human_computer_interaction));
        itemList.add(new MaterialsDomain("Software Engineering"," 3",R.drawable.bg_3,R.string.software_engineering));
        itemList.add(new MaterialsDomain("Cloud Computing"," 3",R.drawable.bg_4,R.string.cloud_computing));
        itemList.add(new MaterialsDomain("Cloud computer networks"," 3",R.drawable.bg_5,R.string.computer_networks));
        itemList.add(new MaterialsDomain("Web Application Development2"," 3",R.drawable.bg_1,R.string.web_application_development_2));
        itemList.add(new MaterialsDomain("Visual Programming"," 3",R.drawable.bg_2,R.string.visual_programming));
        itemList.add(new MaterialsDomain("Advanced_Programming in\nMobile Applications"," 3",R.drawable.bg_3,R.string.Advanced_Programming_in_Mobile_Applications));
        itemList.add(new MaterialsDomain("Data Mining"," 3",R.drawable.bg_4,R.string.Data_Mining));
        itemList.add(new MaterialsDomain("Databases"," 3",R.drawable.bg_5,R.string.Databases));
        itemList.add(new MaterialsDomain("Artificial Intelligence &\nData Science Programming"," 3",R.drawable.bg_1,R.string.Artificial_Intelligence_and_Data_Science_Programming));
        itemList.add(new MaterialsDomain("Internet Programming"," 3",R.drawable.bg_2,R.string.Internet_Programming));
        itemList.add(new MaterialsDomain("Artificial Intelligence"," 3",R.drawable.bg_3,R.string.artificial_intelligence));
        myAdapter=new MaterialsAdapter(itemList,this);
        recyclerView.setAdapter(myAdapter);

        cardback=view.findViewById(R.id.cardback);
        cardback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment UniversityIn = new InFragment() ;
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.Materials ,UniversityIn,null).commit();
            }
        });


        searchMaterials=  view.findViewById(R.id.searchMaterials);
        searchMaterials.clearFocus();
        searchMaterials.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
            case 14:
                myAdapter.updateTextVisibility(14);
                break;
            case 15:
                myAdapter.updateTextVisibility(15);
                break;
            case 16:
                myAdapter.updateTextVisibility(16);
                break;
            case 17:
                myAdapter.updateTextVisibility(17);
                break;
            case 18:
                myAdapter.updateTextVisibility(18);
                break;
            case 19:
                myAdapter.updateTextVisibility(19);
                break;
            case 20:
                myAdapter.updateTextVisibility(20);
                break;
            case 21:
                myAdapter.updateTextVisibility(21);
                break;
            case 22:
                myAdapter.updateTextVisibility(22);
                break;
            case 23:
                myAdapter.updateTextVisibility(23);
                break;
            case 24:
                myAdapter.updateTextVisibility(24);
                break;
            case 25:
                myAdapter.updateTextVisibility(25);
                break;
            case 26:
                myAdapter.updateTextVisibility(26);
                break;
            case 27:
                myAdapter.updateTextVisibility(27);
                break;
            case 28:
                myAdapter.updateTextVisibility(28);
                break;
            case 29:
                myAdapter.updateTextVisibility(29);
                break;
            case 30:
                myAdapter.updateTextVisibility(30);
                break;



        }
    }

    private void filterList(String text) {

        List<MaterialsDomain> filterdLits = new ArrayList<>();
        for (MaterialsDomain item:itemList){



            if(item.getTitle().toLowerCase().contains(text.toLowerCase())){
                filterdLits.add(item);
            }

        }


        myAdapter.setFilteredList(filterdLits);



    }
}