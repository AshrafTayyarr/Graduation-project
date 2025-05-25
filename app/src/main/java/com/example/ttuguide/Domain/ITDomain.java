package com.example.ttuguide.Domain;

import android.view.View;

public class ITDomain {

    private String title;
    private String hour;
    private int description;
    private int  picPath;
    private int  background;
    private int textVisibility;


    public ITDomain(String title, String hour, int picPath, int background, int description ) {
        this.title = title;
        this.hour = hour;
        this.picPath = picPath;
        this.background = background;
        this.textVisibility= View.GONE;
        this.description=description;
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

    public int getPicPath() {
        return picPath;
    }

    public int getBackground() {
        return background;
    }
}
