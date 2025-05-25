package com.example.ttuguide.Activity;

import static android.content.Context.ALARM_SERVICE;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ttuguide.Adpater.AddCoursesAdapter;
import com.example.ttuguide.Adpater.ScheduleAdapter;
import com.example.ttuguide.Domain.AddCoursesDomain;
import com.example.ttuguide.Domain.ScheduleDomain;
import com.example.ttuguide.R;
import com.example.ttuguide.RecyclerViewInterface.AddCourses;
import com.example.ttuguide.RecyclerViewInterface.DeleteCourse;
import com.example.ttuguide.RecyclerViewInterface.Majors;
import com.example.ttuguide.RecyclerViewInterface.OnSpinner;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Schedule extends Fragment implements Majors, AddCourses, DeleteCourse, OnSpinner {

    RecyclerView recyclerView,AddrecyclerView;
    ScheduleAdapter myAdapter;
    AddCoursesAdapter AddAdapter;
    List<ScheduleDomain> itemList;
    List<AddCoursesDomain> AdditemList;
    CardView cardback;
    FloatingActionButton btnAdd;
    TextView textTitle;
    Dialog dialog;
    Spinner spnAlarm;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    public static final String CHANNEL_ID = "ALARM_CHANNEL";


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_schedule, container, false);
        recyclerView=view.findViewById(R.id.view);
        AddrecyclerView=view.findViewById(R.id.AddView);
        textTitle=view.findViewById(R.id.textTitle);
        spnAlarm=view.findViewById(R.id.spnAlarm);
        alarmManager = (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        itemList=new ArrayList<>();
        itemList = SharedPreferencesHelper.loadScheduleList(getContext());
        myAdapter=new ScheduleAdapter(itemList,this,this,this);
        recyclerView.setAdapter(myAdapter);

        cardback=view.findViewById(R.id.cardback);
        cardback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment UniversityIn = new InFragment() ;
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.Schedule ,UniversityIn,null).commit();
            }
        });
        btnAdd=view.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomDialogCor();
            }
        });
        createNotificationChannel();

        return view;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "AlarmChannel";
            String description = "Channel for alarm notifications";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getActivity().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void showBottomDialogCor() {
         dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_cousre);

        ImageView cancelButton = dialog.findViewById(R.id.cancelButton);
       // LinearLayout coursesLayout = dialog.findViewById(R.id.coursesLayout);
        TextView titleTextView = dialog.findViewById(R.id.titleTextView);
        RecyclerView AddrecyclerView = dialog.findViewById(R.id.AddView); //

        cancelButton.setOnClickListener(view -> dialog.dismiss());

        // Example list of courses (replace with your actual list)
        String[] courses = getResources().getStringArray(R.array.courses_array);

        // Set the title of the dialog if needed
        titleTextView.setText("Courses");

        AddrecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        AdditemList = new ArrayList<>();
        for (String course : courses) {
            AdditemList.add(new AddCoursesDomain(course));
        }
        AddAdapter = new AddCoursesAdapter(AdditemList,this);
        AddrecyclerView.setAdapter(AddAdapter);


        dialog.show();
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, (int) (getResources().getDisplayMetrics().heightPixels * 0.75));
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            // window.setWindowAnimations(R.style.DialogAnimation);
            window.setGravity(Gravity.BOTTOM);
        }

    }


    @Override
    public void onItemClick(int pos) {
        switch (pos){

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

        }
    }

    @Override
    public void onAddItemClick(int pos) {

        if (itemList.size() >= 7) {
            // Notify the user that the limit has been reached
            Toast.makeText(getContext(), "You can't add more courses.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validate position
        if (pos < 0 || pos >= AdditemList.size()) {
            Toast.makeText(getContext(), "Invalid position.", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (pos){


            case 0:
                itemList.add(new ScheduleDomain("Cyber Security Basics", " 08:30 AM - 09:40 AM", R.drawable.ss_3_optimized, R.string.CyberSecurityBasics));
                break;
            case 1:
                itemList.add(new ScheduleDomain("Basics in information\ncommunications technology", " 08:30 AM - 09:40 AM", R.drawable.top_tight, R.string.FundamentalsofInformationandCommunicationTechnology));
                break;
            case 2:
                itemList.add(new ScheduleDomain("E-business And\nE-marketing", " 11:30 PM - 12:40 PM", R.drawable.top_tight, R.string.EBusinessAndMarketing));
                break;
            case 3:
                itemList.add(new ScheduleDomain("Object-oriented\nprogramming 1", " 10:00 AM - 11:30 AM\n 01:00 PM - 02:30 PM", R.drawable.top_tight, R.string.ObjectOrientedProgramming1));
                break;
            case 4:
                itemList.add(new ScheduleDomain("Field Training", " 08:00 AM - 12:00 PM", R.drawable.top_tight, R.string.FieldTrainin2));
                break;
            case 5:
                itemList.add(new ScheduleDomain("Field Training", " 08:00 AM - 12:00 PM", R.drawable.top_tight, R.string.FieldTraining1));
                break;
            case 6:
                itemList.add(new ScheduleDomain("Digital Culture", " 06:00 PM - 07:10 PM", R.drawable.top_tight, R.string.DigitalCulture));
                break;
            case 7:
                itemList.add(new ScheduleDomain("Algorithms", " 01:00 PM - 02:10 PM", R.drawable.top_tight, R.string.Algorithms));
                break;
            case 8:
                itemList.add(new ScheduleDomain("Artificial Intelligence", " 10:00 AM - 11:10 AM\n 01:00 PM - 02:10 PM", R.drawable.top_tight, R.string.ArtificialIntelligence));
                break;
            case 9:
                itemList.add(new ScheduleDomain("Malware Analysis", " 11:30 AM - 01:00 PM", R.drawable.top_tight, R.string.MalwareAnalysis));
                break;
            case 10:
                itemList.add(new ScheduleDomain("System Analysis\nAnd design", " 01:00 PM - 02:10 PM", R.drawable.top_tight, R.string.InformationSystemsAnalysisAndDesign));
                break;
            case 11:
                itemList.add(new ScheduleDomain("Data Structures", " 11:30 AM - 12:40 PM\n 02:30 PM - 04:30 PM", R.drawable.top_tight, R.string.DataStructures));
                break;
            case 12:
                itemList.add(new ScheduleDomain("Logic circuit design", " 08:30 AM - 10:00 AM", R.drawable.top_tight, R.string.LogicCircuitdDesign));
                break;
            case 13:
                itemList.add(new ScheduleDomain("General mobile applications", " 01:00 PM - 02:10 PM\n 02:30 PM - 04:30 PM", R.drawable.top_tight, R.string.GeneralApplicationsForMobileDevices));
                break;
            case 14:
                itemList.add(new ScheduleDomain("Mobile computing technology", " 11:30 AM - 12:40 PM", R.drawable.top_tight, R.string.MobileDeviceComputingTechnology));
                break;
            case 15:
                itemList.add(new ScheduleDomain("Computer Vision", " 11:30 AM - 01:00 PM", R.drawable.top_tight, R.string.ComputerVision));
                break;
            case 16:
                itemList.add(new ScheduleDomain("Discrete mathematics", " 02:30 PM - 03:40 PM", R.drawable.top_tight, R.string.DiscreteMathematics));
                break;
            case 17:
                itemList.add(new ScheduleDomain("Data warehouses", " 08:30 AM - 09:40 AM", R.drawable.top_tight, R.string.DataWarehousing));
                break;
            case 18:
                itemList.add(new ScheduleDomain("Introduction to Programming", " 08:30 AM - 10:00 AM", R.drawable.top_tight, R.string.IntroductiontoProgramming));
                break;
            case 19:
                itemList.add(new ScheduleDomain("Computer Skills 2\n(Humanitarian Colleges)", " 08:30 AM - 09:30 AM (DS-ICT 4)", R.drawable.top_tight, R.string.ComputerSkills2_));
                break;
            case 20:
                itemList.add(new ScheduleDomain("Computer Skills 2\n(Scientific Colleges)", " 11:30 AM - 12:40 PM (DS-ICT 1)", R.drawable.top_tight, R.string.ComputerSkills2));
                break;
            case 21:
                itemList.add(new ScheduleDomain("Remedial computer skills", " 06:00 PM - 07:10 PM", R.drawable.top_tight, R.string.RemedialComputerSkills));
                break;
            case 22:
                itemList.add(new ScheduleDomain("Probability Theory And\nStatistics for Data Science", " 08:30 AM - 10:00 AM", R.drawable.top_tight, R.string.ProbabilityTheoryAndStatistics));
                break;
            case 23:
                itemList.add(new ScheduleDomain("Operating Systems", " 10:00 AM - 11:30 AM\n 01:00 PM - 02:30 PM", R.drawable.top_tight, R.string.OperatingSystems1));
                break;
            case 24:
                itemList.add(new ScheduleDomain("Operating Systems", " 01:00 PM - 02:30 PM", R.drawable.top_tight, R.string.OperatingSystems2));
                break;
            case 25:
                itemList.add(new ScheduleDomain("Software Engineering", " 10:00 AM - 11:10 AM", R.drawable.top_tight, R.string.SoftwareEngineering));
                break;
        }

        myAdapter.notifyItemInserted(itemList.size() - 1);
        SharedPreferencesHelper.saveScheduleList(getContext(), itemList);
        dialog.dismiss();
    }

    @Override
    public void onItemLongClick(int position) {
        if (position >= 0 && position < itemList.size()) {
            DeleteDialog(position);
        }
    }

    private void DeleteDialog(int pos){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Confirm");
        builder.setMessage("Are you sure you want to delete this course?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                itemList.remove(pos);
                myAdapter.notifyItemRemoved(pos);

                // Update SharedPreferences
                SharedPreferencesHelper.saveScheduleList(getContext(), itemList);

                dialog.dismiss();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Do nothing
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void SpinnerClick(int position, int selectedItemPosition) {
        String time= itemList.get(position).getHour();
        String hour =time.substring(1,3);
        String minute =time.substring(4,6);
        String ampm =time.substring(7,9);
        int hour_int = Integer.parseInt(hour);
        int minute_int = Integer.parseInt(minute);
        switch (selectedItemPosition){

            case 0:

                break;

            case 1:

                if(minute_int==0){
                    hour_int -=1;
                    minute_int=45;
                }
                else
                    minute_int-=15;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    OnToggleClicked(hour_int,minute_int,ampm,position);
                }
                break;

            case 2:


                  if(minute_int==0){
                      hour_int -=1;
                      minute_int=30;
                  }
                  else
                      minute_int-=30;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    OnToggleClicked(hour_int,minute_int,ampm,position);
                }
                break;


            case 3:

                hour_int = hour_int - 1;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    OnToggleClicked(hour_int,minute_int,ampm,position);
                }
                break;

            case 4:
                cancelAlarm(position);

                break;

            case 5:
                break;


        }
    }


    @SuppressLint("ScheduleExactAlarm")
    public void OnToggleClicked(int hours, int minutes, String am_pm,int position) {
        Intent intent = new Intent(getActivity(), AlarmReceiver.class);
        String courseName = itemList.get(position).getTitle().toString();
        intent.putExtra("course_name", courseName);
        int requestCode = position; // Use position as the unique request code
        pendingIntent = PendingIntent.getBroadcast(getActivity(), requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);


            Toast.makeText(getActivity(), "ALARM ON", Toast.LENGTH_SHORT).show();
            Calendar calendar = Calendar.getInstance();

            int hour = hours;
            int minute = Math.abs(minutes);
            String ampm = am_pm;

            if ("AM".equals(ampm)) {
                calendar.set(Calendar.AM_PM, Calendar.AM);
            } else if ("PM".equals(ampm)) {
                calendar.set(Calendar.AM_PM, Calendar.PM);
            }

            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, minute);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            if (calendar.getTimeInMillis() < System.currentTimeMillis()) {
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }

            long triggerTime = calendar.getTimeInMillis();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
        } else {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
        }
            // Show a notification when the alarm is set
            String min= String.valueOf(minute);
            if(min.equals("0"))
                min="00";
            showNotification("Alarm Set", "Alarm is set for "+itemList.get(position).getTitle().toString() + " " + hour + ":" + min + " " + ampm);

    }

    private void showNotification(String title, String text) {
        NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(), CHANNEL_ID)
                .setSmallIcon(R.drawable.baseline_alarm_24) // Replace with your icon
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);

        if (notificationManager != null) {
            notificationManager.notify(AlarmReceiver.NOTIFICATION_ID, builder.build());
        }
    }

    private void cancelAlarm(int position) {
        Intent intent = new Intent(getActivity(), AlarmReceiver.class);
        String courseTitle = itemList.get(position).getTitle().toString();
        intent.putExtra("courseTitle", courseTitle);
// The string you want to pass
        int requestCode = position; // Use position as the unique request code
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
            Toast.makeText(getActivity(), "ALARM OFF", Toast.LENGTH_SHORT).show();
            showNotification("Alarm Cancelled", "The alarm for " + itemList.get(position).getTitle().toString() + " has been cancelled.");
        }
       // getActivity().sendBroadcast(intent);
    }

}
