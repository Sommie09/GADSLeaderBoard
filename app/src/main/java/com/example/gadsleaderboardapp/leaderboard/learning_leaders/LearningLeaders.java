package com.example.gadsleaderboardapp.leaderboard.learning_leaders;

import com.google.gson.annotations.SerializedName;

public class LearningLeaders {
    @SerializedName("name")
    private String name;

    @SerializedName("hours")
    private int hours;

    @SerializedName("country")
    private String country;

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public String getCountry() {
        return country;
    }
}
