package com.example.jajodia.ret.api.model;


import com.google.gson.annotations.SerializedName;

/**
 * Created by jajodia on 11/29/17.
 */

public class GithubRepo {
    private String name;
    private String description;

    public GithubRepo(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription(){
        return description;
    }
}
