package com.example.ttuguide.Domain;

import android.view.View;

public class CourseStudyDomain {

    private String title;
    private int description;
    private int  background;
    private int textVisibility;
    private String TeacherText;




    public CourseStudyDomain(String title, String TeacherText, int background,int description ) {
        this.title = title;
        this.background = background;
        this.textVisibility= View.GONE;
        this.description=description;
        this.TeacherText=TeacherText;
    }

    public String getTeacherText() {
        return TeacherText;
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


    public int getBackground() {
        return background;
    }
}
