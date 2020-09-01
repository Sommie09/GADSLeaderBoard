package com.example.gadsleaderboardapp.leaderboard.learning_leaders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboardapp.R;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder> {
    private final Context context;
    private final List<LearningLeaders> learningLeaders;

    public LearningLeadersAdapter(Context context, List<LearningLeaders> learningLeaders) {
        this.context = context;
        this.learningLeaders = learningLeaders;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.learning_leaders_itemview, parent, false);
        return new LearningLeadersAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.learning_name.setText(learningLeaders.get(position).getName());
        holder.learning_hours.setText(String.valueOf(learningLeaders.get(position).getHours()));
        holder.learning_country.setText(learningLeaders.get(position).getCountry());

    }

    @Override
    public int getItemCount() {
        return learningLeaders.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView learning_name, learning_hours, learning_country;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            learning_name = itemView.findViewById(R.id.learner_name);
            learning_hours = itemView.findViewById(R.id.learner_score);
            learning_country = itemView.findViewById(R.id.learner_country);
        }
    }
}
