package com.example.matt.stocks.API;

import com.example.matt.stocks.Model.News;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface NewsAPI {

    @GET("/headline")
    void getNews(@Query("s") String symbol, Callback<News> callback);

}
