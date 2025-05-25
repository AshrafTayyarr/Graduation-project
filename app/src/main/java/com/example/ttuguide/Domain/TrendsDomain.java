package com.example.ttuguide.Domain;

public class TrendsDomain {

    private String title;
    private String subTitle;
    private int imageResource;

    public TrendsDomain(String title, String subTitle, int imageResource) {
        this.title = title;
        this.subTitle = subTitle;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public int getImageResource() {
        return imageResource;
    }
}
