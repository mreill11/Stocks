package com.example.matt.stocks.API;

import com.example.matt.stocks.Model.Company;
import com.example.matt.stocks.Model.Quote;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface StockAPI {

    @GET("/Lookup/json")
    void getStockSymbol(@Query("input") String input, Callback<Company[]> callback);

    @GET("/Quote/json")
    void getQuote(@Query("symbol") String symbol, Callback<Quote> callback);
}
