package com.example.jajodia.ret.api.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.jajodia.ret.R;

import java.util.List;

/**
 * Created by ruturaj on 1/12/17.
 */

public class GithubRepoAdapter extends RecyclerView.Adapter<GithubRepoAdapter.MyViewHolder>{
    private static List<GithubRepo> githubRepos;
    private Context context;

    public GithubRepoAdapter(List<GithubRepo> githubRepos, Context context){
        this.githubRepos = githubRepos;
        this.context = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView repoName;
        TextView description;

        public MyViewHolder(View view){
            super(view);
            repoName = (TextView) view.findViewById(R.id.repos_tv);
            description = (TextView) view.findViewById(R.id.description);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.repoName.setText(githubRepos.get(position).getName());
        Log.i("Repo:", holder.repoName.toString());
        holder.description.setText(githubRepos.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return githubRepos.size();
    }

}
