package com.example.gadsleaderboardapp.leaderboard.learning_leaders;

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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LearningLeadersFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<LearningLeaders> learningLeaders;
    private LearningLeadersAdapter adapter;
    private APIInterface mAPIInterface;



    public LearningLeadersFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        recyclerView = view.findViewById(R.id.learning_leaders_recycler_view);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        mAPIInterface = APIClient.getApiClient().create(APIInterface.class);

        Call<List<LearningLeaders>> call = mAPIInterface.getLearningLeaders();
        call.enqueue(new Callback<List<LearningLeaders>>() {
            @Override
            public void onResponse(Call<List<LearningLeaders>> call, Response<List<LearningLeaders>> response) {


                learningLeaders = response.body();
                adapter = new LearningLeadersAdapter(getContext(), learningLeaders);
                recyclerView.setAdapter(adapter );
            }

            @Override
            public void onFailure(Call<List<LearningLeaders>> call, Throwable t) {

            }
        });




        return view;
    }
}