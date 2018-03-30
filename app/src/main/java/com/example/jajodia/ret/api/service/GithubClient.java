package com.example.jajodia.ret.api.service;

import com.example.jajodia.ret.api.model.GithubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jajodia on 11/29/17.
 */

public interface GithubClient {

    @GET("/users/{user}/repos")
    Call<List<GithubRepo>> reposForUser(@Path("user") String user);
}
