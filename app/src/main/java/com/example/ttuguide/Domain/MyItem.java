package com.example.ttuguide.Domain;

public class MyItem {
    private String title;
    private String phoneNumber;
    private int imageResource;

    public MyItem(String title, String phoneNumber, int imageResource) {
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getImageResource() {
        return imageResource;
    }
}

