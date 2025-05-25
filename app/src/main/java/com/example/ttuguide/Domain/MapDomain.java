package com.example.ttuguide.Domain;

import android.view.View;

public class MapDomain {

    private String title;
    private String hour;
    private int descriptionPic;
    private int  background;
    private int PicVisibility;


    public MapDomain(String title, String hour, int background, int descriptionPic ) {
        this.title = title;
        this.hour = hour;
        this.background = background;
        this.PicVisibility= View.GONE;
        this.descriptionPic=descriptionPic;
    }

    public int getPicVisibility() {
        return PicVisibility;
    }

    public void setPicVisibility(int picVisibility) {
        PicVisibility = picVisibility;
    }

    public int getDescriptionPic() {
        return descriptionPic;
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
}
