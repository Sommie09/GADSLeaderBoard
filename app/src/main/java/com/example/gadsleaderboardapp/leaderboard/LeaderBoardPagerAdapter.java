package com.example.gadsleaderboardapp.leaderboard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gadsleaderboardapp.leaderboard.learning_leaders.LearningLeadersFragment;
import com.example.gadsleaderboardapp.leaderboard.skillIQ.SkillIQLeadersFragment;

public class LeaderBoardPagerAdapter extends FragmentPagerAdapter {

    public LeaderBoardPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @Override
    public int getCount() {
        return 2;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LearningLeadersFragment();
            case 1:
                return new SkillIQLeadersFragment();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title;
        if (position == 0) {
            title = "Learning Leaders";
        }else{
            title = "SkillIQ Leaders";
        }
        return title;
    }
}
