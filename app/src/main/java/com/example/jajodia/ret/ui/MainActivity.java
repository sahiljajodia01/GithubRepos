package com.example.jajodia.ret.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.example.jajodia.ret.R;
import com.example.jajodia.ret.api.model.GithubRepo;
import com.example.jajodia.ret.api.model.GithubRepoAdapter;
import com.example.jajodia.ret.api.service.Client;
import com.example.jajodia.ret.api.service.GithubClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        GithubClient githubClient = Client.getClient().create(GithubClient.class);
        Call<List<GithubRepo>> call = githubClient.reposForUser("sahiljajodia01");
        call.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                List<GithubRepo> githubRepoList = response.body();
                recyclerView.setAdapter(new GithubRepoAdapter(githubRepoList, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Log.e("Error: ", t.toString());
            }
        });

    }


}
