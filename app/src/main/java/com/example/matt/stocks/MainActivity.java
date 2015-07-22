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
import com.example.matt.stocks.Model.Company;
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
    Quote theQuote;
    Card theCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Thread.setDefaultExceptionHandler(new ExceptionHandler());
        setContentView(R.layout.activity_main);
        removeAllFromRealm();
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
                                    companies.remove(position);
                                    Log.i("TEST", companies.toString());
                                    adapter.notifyItemRemoved(position);
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
        if (results.size() > 0) {
            for (Card c : results) {
                addCard(c);
            }
        }
        updateQuotes();
    }

    public void addCard(Card c) {
        companies.add(c);
        adapter.notifyDataSetChanged();
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
                initializeNewCard(symbol);
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

    public Quote retrieveQuote(String aSymbol) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API).build();
        StockAPI stockapi = restAdapter.create(StockAPI.class);
        theQuote = new Quote();

        stockapi.getQuote(aSymbol, new Callback<Quote>() {
            @Override
            public void success(Quote quote, Response response) {
                Log.i("TEST", quote.getName() + ".");
                theQuote = quote;
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("TEST", error.getMessage());
            }
        });
        return theQuote;
    }

    public Card retrieveCompanyInfo(String aSymbol) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API).build();
        StockAPI stockapi = restAdapter.create(StockAPI.class);
        theCard = new Card();

        stockapi.getStockSymbol(aSymbol, new Callback<Company[]>() {
            @Override
            public void success(Company[] company, Response response) {
                theCard.setSymbol(company[0].getSymbol());
                theCard.setCompanyName(company[0].getName());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("TEST", error.getMessage());
            }
        });
        return theCard;
    }

    public void initializeNewCard(String aSymbol) {
        Card newCard = retrieveCompanyInfo(aSymbol);

        Log.i("TEST", newCard.getSymbol() + " .");
        if (isNewStock(newCard)) {
            addStockToRealm(newCard);
            addCard(newCard);
            updateQuotes();
        }
    }

    public void updateQuotes() {
        for (Card c : companies) {
            Quote quote = retrieveQuote(c.getSymbol());
            c.setLastPrice(quote.getLastPrice());
            c.setPositiveChange(quote.getChangePercent() > 0.0);
            c.setChangePercent(quote.getChangePercent());
        }
        adapter.notifyDataSetChanged();
    }

    public boolean isNewStock(Card aCard) {
        boolean isNew = true;
        Realm realm = Realm.getInstance(this);
        RealmQuery<Card> query = realm.where(Card.class);
        RealmResults<Card> results = query.findAll();
        realm.beginTransaction();
        for (int i = 0; i < results.size(); i++) {
            if (aCard.getSymbol().toUpperCase().equals(
                    results.get(i).getSymbol().toUpperCase()))
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
                    results.get(i).getSymbol().toUpperCase()))
                results.remove(i);
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
        Log.i("Test", results.toString());
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
            updateQuotes();
            return true;
        } else if (id == R.id.action_settings) {
            removeAllFromRealm();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}