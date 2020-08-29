package com.example.gadsleaderboardapp.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;

import com.example.gadsleaderboardapp.R;
import com.google.android.material.tabs.TabLayout;

public class LeaderBoardActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);

        toolbar =  findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        button = findViewById(R.id.submit_button);

        LeaderBoardPagerAdapter householdPagerAdapter = new LeaderBoardPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager =  findViewById(R.id.pager);
        viewPager.setAdapter(householdPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }


}