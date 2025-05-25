package com.example.ttuguide.Domain;

public class OnlineDomain {

    private String title;
    private int  background;
    private int  picPath;


    public OnlineDomain(String title, int background,int picPath ) {
        this.title = title;
        this.picPath = picPath;
        this.background = background;

    }

    public String getTitle() {
        return title;
    }

    public int getBackground() {
        return background;
    }
    public int getPicPath() {
        return picPath;
    }
}
