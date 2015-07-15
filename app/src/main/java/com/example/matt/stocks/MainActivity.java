package com.example.matt.stocks;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.matt.stocks.API.StockAPI;
import com.example.matt.stocks.Model.Company;
import com.example.matt.stocks.Model.Quote;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends ActionBarActivity {

    private List<Company> companies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
        setContentView(R.layout.activity_main);
        createViews();
        testGetSymbol();
        testGetQuote();
    }

    public void testGetSymbol() {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://dev.markitondemand.com/Api/v2").build();
        StockAPI stockapi = restAdapter.create(StockAPI.class);

        stockapi.getStockSymbol("google", new Callback<Company[]>() {
            @Override
            public void success(Company[] company, Response response) {
                Log.i("TEST", company[0].getName() + " " + company[0].getSymbol());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("TEST", error.getMessage());
            }
        });
    }

    public void testGetQuote() {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://dev.markitondemand.com/Api/v2").build();
        StockAPI stockapi = restAdapter.create(StockAPI.class);

        stockapi.getQuote("goog", new Callback<Quote>() {
            @Override
            public void success(Quote quote, Response response) {
                Log.i("TEST", quote.getName() + " " + quote.getLastPrice());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("TEST", error.getMessage());
            }
        });
    }

    public void createViews() {
        RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        //rv.addItemDecoration(new SimpleDividerItemDecoration(getApplicationContext()));

        initializeData();

        RVAdapter adapter = new RVAdapter(companies);
        rv.setAdapter(adapter);
    }

    private void initializeData() {
        //TODO: will later pull from persistent stock list, example data below:
        companies = new ArrayList<>();
        //companies.add(new Company("GOOG", "Google", "513.89"));
        //companies.add(new Company("AAPL", "Apple", "212.55"));
        //companies.add(new Company("NFLX", "Netflix", "89.43"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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