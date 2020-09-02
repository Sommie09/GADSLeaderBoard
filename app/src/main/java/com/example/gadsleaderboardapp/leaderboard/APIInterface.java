package com.example.gadsleaderboardapp.leaderboard;

import com.example.gadsleaderboardapp.leaderboard.learning_leaders.LearningLeaders;
import com.example.gadsleaderboardapp.leaderboard.skillIQ.SkillIQ;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {

    @GET("/api/hours")
    Call<List<LearningLeaders>> getLearningLeaders();

    @GET("/api/skilliq")
    Call<List<SkillIQ>> getSkillIQLeaders();




}
