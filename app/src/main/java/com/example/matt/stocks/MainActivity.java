package com.example.matt.stocks;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.matt.stocks.API.StockAPI;
import com.example.matt.stocks.Model.Quote;
import com.github.brnunes.swipeablerecyclerview.SwipeableRecyclerViewTouchListener;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends ActionBarActivity {

    private List<Card> companies;
    final String API = "http://dev.markitondemand.com/Api/v2";

    RecyclerView rv;
    RVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Thread.setDefaultExceptionHandler(new ExceptionHandler());
        setContentView(R.layout.activity_main);
        //removeAllFromRealm();
        companies = new ArrayList<>();
        createViews();

        initializePersistentData();

        SwipeableRecyclerViewTouchListener swipeTouchListener =
                new SwipeableRecyclerViewTouchListener(rv,
                        new SwipeableRecyclerViewTouchListener.SwipeListener() {
                            @Override
                            public boolean canSwipe(int position) {
                                return true;
                            }

                            @Override
                            public void onDismissedBySwipeLeft(RecyclerView aRecyclerView,
                                                               int[] reverseSortPositions) {
                                for (int position : reverseSortPositions) {
                                    removeStockFromRealm(companies.get(position));
                                }
                                adapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onDismissedBySwipeRight(RecyclerView aRecyclerView,
                                                                int[] reverseSortPositions) {
                                for (int position : reverseSortPositions) {
                                    removeStockFromRealm(companies.get(position));
                                    companies.remove(position);
                                    Log.i("TEST", companies.toString());
                                    adapter.notifyItemRemoved(position);
                                }
                                adapter.notifyDataSetChanged();
                            }
                        });
        rv.addOnItemTouchListener(swipeTouchListener);
    }

    public void createViews() {
        rv = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        adapter = new RVAdapter(companies);
        rv.setAdapter(adapter);
    }

    private void initializePersistentData() {
        Realm realm = Realm.getInstance(this);
        RealmQuery<Card> query = realm.where(Card.class);
        RealmResults<Card> results = query.findAll();
        if (results.size() != 0) {
            for (Card c : results) {
                companies.add(c);
                retrieveQuote(c.getSymbol());
            }
            adapter.notifyDataSetChanged();
            //updateQuotes();
        }
    }

    public void displayAddStockDialog() {
        AlertDialog.Builder newStock = new AlertDialog.Builder(MainActivity.this);
        newStock.setTitle("Add a stock:");

        final EditText input = new EditText(MainActivity.this);

        newStock.setView(input);
        newStock.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String symbol = input.getText().toString();
                retrieveQuote(symbol);
            }
        });
        newStock.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        newStock.show();
    }

    public void retrieveQuote(String aSymbol) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API).build();
        StockAPI stockapi = restAdapter.create(StockAPI.class);

        stockapi.getQuote(aSymbol, new Callback<Quote>() {
            @Override
            public void success(Quote quote, Response response) {
                Log.i("TEST", quote.getName() + ".");
                if (isNewStock(quote.getSymbol())) {
                    initializeNewCard(quote);
                } else {
                    updateQuote(quote);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("TEST", error.getMessage());
            }
        });
    }

    public void updateQuote(Quote aQuote) {
        for (Card c : companies) {
            if (c.getSymbol().equals(aQuote.getSymbol())) {
                Realm realm = Realm.getInstance(this);
                realm.beginTransaction();
                c.setLastPrice(aQuote.getLastPrice());
                c.setPositiveChange(aQuote.getChangePercent() > 0.0);
                c.setChangePercent(aQuote.getChangePercent());
                realm.commitTransaction();
            }
        }
        adapter.notifyDataSetChanged();
    }
/**
    public void retrieveCompanyInfo(String aSymbol) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API).build();
        StockAPI stockapi = restAdapter.create(StockAPI.class);

        stockapi.getStockSymbol(aSymbol, new Callback<Company[]>() {
            @Override
            public void success(Company[] company, Response response) {
                theCard.setSymbol(company[0].getSymbol());
                theCard.setCompanyName(company[0].getName());

                Log.i("TEST", theCard.getSymbol() + " .");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("TEST", error.getMessage());
            }
        });
    }
**/
    public void initializeNewCard(Quote aQuote) {
        Log.i("TEST", aQuote.getSymbol() + " .");
        Card newCard = new Card(aQuote.getSymbol(), aQuote.getName(), aQuote.getLastPrice(),
                aQuote.getChangePercent() > 0.0, aQuote.getChangePercent());
        companies.add(newCard);
        adapter.notifyDataSetChanged();
        addStockToRealm(newCard);
        //updateQuotes();
    }
/**
    public void updateQuotes() {
        for (Card c : companies) {
            Log.i("TEST", c.getSymbol() + " .");
            retrieveQuote(c.getSymbol());
            c.setLastPrice(theQuote.getLastPrice());
            c.setPositiveChange(theQuote.getChangePercent() > 0.0);
            c.setChangePercent(theQuote.getChangePercent());
        }
        adapter.notifyDataSetChanged();
    }
**/
    public boolean isNewStock(String aSymbol) {
        boolean isNew = true;
        Realm realm = Realm.getInstance(this);
        RealmQuery<Card> query = realm.where(Card.class);
        RealmResults<Card> results = query.findAll();
        realm.beginTransaction();
        for (int i = 0; i < results.size(); i++) {
            if (aSymbol.equals(results.get(i).getSymbol().toUpperCase()))
                isNew = false;
        }
        realm.commitTransaction();
        return isNew;
    }

    public void addStockToRealm(Card aCard) {
        Realm realm = Realm.getInstance(this);
        realm.beginTransaction();
        Card card = realm.createObject(Card.class);
        card.setSymbol(aCard.getSymbol());
        card.setCompanyName(aCard.getCompanyName());
        card.setLastPrice(aCard.getLastPrice());
        card.setPositiveChange(aCard.getChangePercent() > 0.0);
        card.setChangePercent(aCard.getChangePercent());
        realm.commitTransaction();

        logRealm();
    }

    public void removeStockFromRealm(Card aCard) {
        Realm realm = Realm.getInstance(this);
        RealmQuery<Card> query = realm.where(Card.class);
        RealmResults<Card> results = query.findAll();
        realm.beginTransaction();
        for (int i = 0; i < results.size(); i++) {
            if (aCard.getSymbol().toUpperCase().equals(
                    results.get(i).getSymbol().toUpperCase())) {
                results.remove(i);
                companies.remove(i);
                //Log.i("TEST", companies.toString());
                adapter.notifyItemRemoved(i);
            }
        }
        realm.commitTransaction();

        logRealm();
    }

    public void removeAllFromRealm() {
        Realm realm = Realm.getInstance(this);
        RealmQuery<Card> query = realm.where(Card.class);
        RealmResults<Card> results = query.findAll();
        realm.beginTransaction();
        results.clear();
        realm.commitTransaction();
    }

    public void logRealm() {
        Realm realm = Realm.getInstance(this);
        RealmQuery<Card> query = realm.where(Card.class);
        RealmResults<Card> results = query.findAll();
        Log.i("TEST", results.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_add_stock) {
            displayAddStockDialog();
            return true;
        } else if (id == R.id.action_refresh_quotes) {
            companies.clear();
            initializePersistentData();
            return true;
        } else if (id == R.id.action_settings) {
            removeAllFromRealm();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}