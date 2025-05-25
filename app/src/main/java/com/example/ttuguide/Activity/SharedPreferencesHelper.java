package com.example.ttuguide.Activity;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ttuguide.Domain.ScheduleDomain;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPreferencesHelper {
    private static final String PREF_NAME = "schedule_prefs";
    private static final String SCHEDULE_KEY = "schedule_list";

    public static void saveScheduleList(Context context, List<ScheduleDomain> scheduleList) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(scheduleList);
        editor.putString(SCHEDULE_KEY, json);
        editor.apply();
    }

    public static List<ScheduleDomain> loadScheduleList(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(SCHEDULE_KEY, null);
        Type type = new TypeToken<ArrayList<ScheduleDomain>>() {}.getType();
        return json == null ? new ArrayList<>() : gson.fromJson(json, type);
    }

    public static void deleteScheduleList(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(SCHEDULE_KEY);
        editor.apply();
    }
}
