package com.example.ttuguide.Domain;

import android.view.View;

public class ScheduleDomain {

    private String title;
    private String hour;
    private int description;
    private int  background;
    private int textVisibility;
    private int alarmSelection;


    public ScheduleDomain(String title, String hour, int background, int description ) {
        this.title = title;
        this.hour = hour;
        this.background = background;
        this.textVisibility= View.GONE;
        this.description=description;
        this.alarmSelection = -1;
    }

    public int getTextVisibility() {
        return textVisibility;
    }

    public void setTextVisibility(int textVisibility) {
        this.textVisibility = textVisibility;
    }

    public int getDescription() {

        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getHour() {
        return hour;
    }

    public int getBackground() {
        return background;
    }

    public int getAlarmSelection() {
        return alarmSelection;
    }

    public void setAlarmSelection(int alarmSelection) {
        this.alarmSelection = alarmSelection;
    }
}
