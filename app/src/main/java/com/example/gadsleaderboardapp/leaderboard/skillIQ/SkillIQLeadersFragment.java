package com.example.gadsleaderboardapp.leaderboard.skillIQ;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadsleaderboardapp.R;
import com.example.gadsleaderboardapp.leaderboard.APIClient;
import com.example.gadsleaderboardapp.leaderboard.APIInterface;
import com.example.gadsleaderboardapp.leaderboard.learning_leaders.LearningLeaders;
import com.example.gadsleaderboardapp.leaderboard.learning_leaders.LearningLeadersAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SkillIQLeadersFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<SkillIQ> skillIQ;
    private SkillIQAdapter adapter;
    private APIInterface mAPIInterface;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View  view =  inflater.inflate(R.layout.fragment_skill_i_q_leaders, container, false);

        recyclerView = view.findViewById(R.id.skill_iq_recycler_view);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        mAPIInterface = APIClient.getApiClient().create(APIInterface.class);

        Call<List<SkillIQ>> call = mAPIInterface.getSkillIQLeaders();
        call.enqueue(new Callback<List<SkillIQ>>() {
            @Override
            public void onResponse(Call<List<SkillIQ>> call, Response<List<SkillIQ>> response) {


                skillIQ = response.body();
                adapter = new SkillIQAdapter(getContext(), skillIQ);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<SkillIQ>> call, Throwable t) {

            }
        });

        return view;
    }
}