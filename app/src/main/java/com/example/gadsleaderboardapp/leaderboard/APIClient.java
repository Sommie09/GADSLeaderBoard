package com.example.gadsleaderboardapp.leaderboard;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static final String BASE_URL = "https://gadsapi.herokuapp.com";
    public static Retrofit retrofitLeaderBoard;

    public static Retrofit getApiClient(){
        if(retrofitLeaderBoard == null){
            retrofitLeaderBoard = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofitLeaderBoard;
    }



}
