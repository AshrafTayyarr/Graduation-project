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

import com.example.ttuguide.Adpater.CoueseStudyAdapter;
import com.example.ttuguide.Domain.CourseStudyDomain;
import com.example.ttuguide.R;
import com.example.ttuguide.RecyclerViewInterface.Majors;

import java.util.ArrayList;
import java.util.List;


public class CourseStudy extends Fragment implements Majors {

    RecyclerView recyclerView;
    CoueseStudyAdapter myAdapter;
    List<CourseStudyDomain> itemList;
    CardView cardback;
    SearchView searchCourse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_course_study, container, false);

        recyclerView=view.findViewById(R.id.view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        itemList=new ArrayList<>();
        itemList.add(new CourseStudyDomain("Cyber Security Basics","Dr.Shorouq Ahmed\nSuleiman Al-Aidi",R.drawable.ss_3_optimized,R.string.CyberSecurityBasics));
        itemList.add(new CourseStudyDomain("Basics in information\ncommunications technology","Dr. Ahmed Mohammed\nSuleiman Al-Freijat",R.drawable.top_tight,R.string.FundamentalsofInformationandCommunicationTechnology));
        itemList.add(new CourseStudyDomain("E-business And\nE-marketing","Dr.Munther Ali\nMuslim Al-Tarawneh",R.drawable.top_tight,R.string.EBusinessAndMarketing));
        itemList.add(new CourseStudyDomain("Object-oriented\nprogramming 1","Dr.Khaled Ali\nAzzam Al-Omariyin",R.drawable.top_tight,R.string.ObjectOrientedProgramming1));
        itemList.add(new CourseStudyDomain("Field Training","Abdullah Muzail\nMahmoud Al-Shabatat",R.drawable.top_tight,R.string.FieldTrainin2));
        itemList.add(new CourseStudyDomain("Field Training","Dr.Shorouq Ahmed\nSuleiman Al-Aidi",R.drawable.top_tight,R.string.FieldTraining1));
        itemList.add(new CourseStudyDomain("Digital Culture", "Dr.Muhammad Al-Farahid", R.drawable.top_tight, R.string.DigitalCulture));
        itemList.add(new CourseStudyDomain("Algorithms","Dr.Nancy Saleh\nAbdullah Al-Ajarma",R.drawable.top_tight,R.string.Algorithms));
        itemList.add(new CourseStudyDomain("Artificial Intelligence","Dr.Jamil Ahmed\nJamil Al-Sawa",R.drawable.top_tight,R.string.ArtificialIntelligence));
        itemList.add(new CourseStudyDomain("Malware Analysis","Dr.Iman Mohammed\nSuwailem Al-Qatimat",R.drawable.top_tight,R.string.MalwareAnalysis));
        itemList.add(new CourseStudyDomain("System Analysis\nAnd design","Dr.Farhan Mohammed\nAbdul Latif Al-Abisat",R.drawable.top_tight,R.string.InformationSystemsAnalysisAndDesign));
        itemList.add(new CourseStudyDomain("Data Structures","Mustafa Abdel Qader\nAtwi Al-Damour",R.drawable.top_tight,R.string.DataStructures));
        itemList.add(new CourseStudyDomain("Logic circuit design","Dr.Ibrahim Yassin\nSuleiman Al-Tarawneh",R.drawable.top_tight,R.string.LogicCircuitdDesign));
        itemList.add(new CourseStudyDomain("General mobile applications","Dr.Ayman Mamdouh\nAhmed Ayal Awad",R.drawable.top_tight,R.string.GeneralApplicationsForMobileDevices));
        itemList.add(new CourseStudyDomain("Mobile computing technology","Dr.Ayman Mamdouh\nAhmed Ayal Awad",R.drawable.top_tight,R.string.MobileDeviceComputingTechnology));
        itemList.add(new CourseStudyDomain("Computer Vision","Dr.Ibrahim Yassin\nSuleiman Al-Tarawneh",R.drawable.top_tight,R.string.ComputerVision));
        itemList.add(new CourseStudyDomain("Discrete mathematics","Dr.Mohammed Al-Farahid",R.drawable.top_tight,R.string.DiscreteMathematics));
        itemList.add(new CourseStudyDomain("Data warehouses","Dr.Munther Ali\nMuslim Al-Tarawneh",R.drawable.top_tight,R.string.DataWarehousing));
        itemList.add(new CourseStudyDomain("Introduction to Programming","Dr. Iman Mohammed\nSuwailem Al-Qatimat",R.drawable.top_tight,R.string.IntroductiontoProgramming));
        itemList.add(new CourseStudyDomain("Computer Skills 2\n(Humanitarian Colleges)","Laith Muhammad\nKhalaf Al-Jafut",R.drawable.top_tight,R.string.ComputerSkills2_));
        itemList.add(new CourseStudyDomain("Computer Skills 2\n(Scientific Colleges)","Abdullah Muzail\nMahmoud Al-Shabatat",R.drawable.top_tight,R.string.ComputerSkills2));
        itemList.add(new CourseStudyDomain("Remedial computer skills","Dr.Shorouq Ahmed\nSuleiman Al-Aidi", R.drawable.top_tight,R.string.RemedialComputerSkills));
        itemList.add(new CourseStudyDomain("Probability Theory And\nStatistics for Data Science","Dr.Muhammad Abdul\nMahdi Reda Al-Jarrah",R.drawable.top_tight,R.string.ProbabilityTheoryAndStatistics));
        itemList.add(new CourseStudyDomain("Operating Systems","Dr.Mohammed Abdullah\nSuleiman Al-Musaideen",R.drawable.top_tight,R.string.OperatingSystems1));
        itemList.add(new CourseStudyDomain("Operating Systems","Dr.Muhammad Al-Farahid",R.drawable.top_tight,R.string.OperatingSystems2));
        itemList.add(new CourseStudyDomain("Software Engineering","Dr.Farhan Mohammed\nAbdul Latif Al-Abisat",R.drawable.top_tight,R.string.SoftwareEngineering));


        myAdapter=new CoueseStudyAdapter(itemList,this);
        recyclerView.setAdapter(myAdapter);

        cardback=view.findViewById(R.id.cardback);
        cardback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment UniversityIn = new InFragment() ;
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.CourseStudy ,UniversityIn,null).commit();
            }
        });


        searchCourse=  view.findViewById(R.id.searchCourse);
        searchCourse.clearFocus();
        searchCourse.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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

        List<CourseStudyDomain> filterdLits = new ArrayList<>();
        for (CourseStudyDomain item:itemList){



            if(item.getTitle().toLowerCase().contains(text.toLowerCase())){
                filterdLits.add(item);
            }

        }


        myAdapter.setFilteredList(filterdLits);



    }
}