package com.example.workoutapp;




public class homedata {
    private String excerciseName;
    private Integer excerciseImage;


    public homedata(String excerciseName, Integer excerciseImage) {
        this.excerciseName = excerciseName;
        this.excerciseImage = excerciseImage;
    }

    public String getexcerciseName() {
        return excerciseName;
    }

    public void setexcerciseName(String excerciseName) {
        this.excerciseName = excerciseName;
    }

    public Integer getexcerciseImage() {
        return excerciseImage;
    }

    public void setExcerciseImage(Integer excerciseImage) {
        this.excerciseImage = excerciseImage;
    }
}


