package com.example.matt.stocks;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.matt.stocks.API.NewsAPI;
import com.example.matt.stocks.Model.News;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.SimpleXMLConverter;

public class DetailedQuoteActivity extends ActionBarActivity {

    String symbol;
    String API = "http://feeds.finance.yahoo.com/rss/2.0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_quote);

        Intent intent = getIntent();
        symbol = intent.getStringExtra("symbol");

        retrieveNews();
    }

    public void retrieveNews() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API).setConverter(new SimpleXMLConverter()).build();
        NewsAPI newsapi = restAdapter.create(NewsAPI.class);

        newsapi.getNews(symbol, new Callback<News>() {
            @Override
            public void success(News news, Response response) {
                Log.i("TEST", news.getCount().toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("TEST", error.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detailed_quote, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
