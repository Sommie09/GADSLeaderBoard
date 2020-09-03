package com.example.gadsleaderboardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.gadsleaderboardapp.leaderboard.LeaderBoardActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        int SPLASH_SCREEN = 3000;
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreenActivity.this, LeaderBoardActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_SCREEN);


    }
}