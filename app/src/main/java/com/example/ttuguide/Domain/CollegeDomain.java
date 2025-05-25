package com.example.ttuguide.Domain;

public class CollegeDomain {

    private String title;
    private String hour;
    private int  picPath;
    private int  background;

    public CollegeDomain(String title, String hour, int picPath, int background) {
        this.title = title;
        this.hour = hour;
        this.picPath = picPath;
        this.background = background;
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
