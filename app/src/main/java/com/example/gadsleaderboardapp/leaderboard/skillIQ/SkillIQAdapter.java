package com.example.gadsleaderboardapp.leaderboard.skillIQ;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboardapp.R;
import com.example.gadsleaderboardapp.leaderboard.learning_leaders.LearningLeaders;
import com.example.gadsleaderboardapp.leaderboard.learning_leaders.LearningLeadersAdapter;

import java.util.List;

public class SkillIQAdapter extends RecyclerView.Adapter<SkillIQAdapter.ViewHolder>{

    private final Context context;
    private final List<SkillIQ> skillIQ;

    public SkillIQAdapter(Context context, List<SkillIQ> skillIQ) {
        this.context = context;
        this.skillIQ = skillIQ;
    }


    @NonNull
    @Override
    public SkillIQAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.skilliq_leaders_itemview, parent, false);
        return new SkillIQAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull SkillIQAdapter.ViewHolder holder, int position) {
        holder.learner_name_skillIQ.setText(skillIQ.get(position).getName());
        holder.learner_score_skillIQ.setText(String.valueOf(skillIQ.get(position).getScore()));
        holder.learner_country_skillIQ.setText(skillIQ.get(position).getCountry());

    }

    @Override
    public int getItemCount() {
        return skillIQ.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView learner_name_skillIQ, learner_score_skillIQ, learner_country_skillIQ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            learner_name_skillIQ = itemView.findViewById(R.id.learner_name_skillIQ);
            learner_score_skillIQ = itemView.findViewById(R.id.learner_score_skillIQ);
            learner_country_skillIQ = itemView.findViewById(R.id.learner_country_skillIQ);
        }
    }

}
