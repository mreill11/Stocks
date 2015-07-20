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
import android.view.MotionEvent;
import android.widget.EditText;

import com.example.matt.stocks.API.StockAPI;
import com.example.matt.stocks.Model.Company;
import com.example.matt.stocks.Model.Quote;
import com.github.brnunes.swipeablerecyclerview.SwipeableRecyclerViewTouchListener;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends ActionBarActivity {

    private List<Card> companies;
    private ArrayList<String> symbols;

    RecyclerView rv;
    RVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
        setContentView(R.layout.activity_main);
        //removeAllFromRealm();
        createViews();

        SwipeableRecyclerViewTouchListener swipeTouchListener =
                new SwipeableRecyclerViewTouchListener(rv,
                        new SwipeableRecyclerViewTouchListener.SwipeListener() {
                            @Override
                            public boolean canSwipe(int position) {
                                return true;
                            }

                            @Override
                            public void onDismissedBySwipeLeft(RecyclerView aRecyclerView, int[] reverseSortPostions) {
                                for (int position : reverseSortPostions) {
                                    removeStockFromRealm(companies.get(position));
                                    companies.remove(position);
                                    adapter.notifyItemRemoved(position);
                                }
                                adapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onDismissedBySwipeRight(RecyclerView aRecyclerView, int[] reverseSortPostions) {
                                for (int position : reverseSortPostions) {
                                    companies.remove(position);
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

        //rv.addItemDecoration(new SimpleDividerItemDecoration(getApplicationContext()));

        initializeData();

        adapter = new RVAdapter(companies);
        rv.setAdapter(adapter);
    }

    private void initializeData() {
        //TODO: will later pull from persistent stock list, example data below:
        companies = new ArrayList<>();
        symbols = new ArrayList<>();
        Realm realm = Realm.getInstance(this);
        RealmQuery<Card> query = realm.where(Card.class);
        RealmResults<Card> results = query.findAll();
        for (Card c : results) {
            retrieveQuote(c.getSymbol());
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
                retrieveQuote(input.getText().toString());
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
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://dev.markitondemand.com/Api/v2").build();
        StockAPI stockapi = restAdapter.create(StockAPI.class);

        stockapi.getQuote(aSymbol, new Callback<Quote>() {
            @Override
            public void success(Quote quote, Response response) {
                Log.i("TEST", quote.getName() + " " + quote.getLastPrice());
                addStockCard(quote);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("TEST", error.getMessage());
            }
        });
    }

    public void addStockCard(Quote aQuote) {
        //TODO: change realm to store only strings
        if (isNewQuote(aQuote)) {
            addStockToRealm(aQuote);
            boolean isPositiveChange = aQuote.getChangePercent() > 0.0;
            Card newCard = new Card(aQuote.getSymbol(), aQuote.getName(), aQuote.getLastPrice(), isPositiveChange, aQuote.getChangePercent());
            symbols.add(aQuote.getSymbol());
            companies.add(newCard);
            adapter.notifyDataSetChanged();
        }
    }

    public boolean isNewQuote(Quote aQuote) {
        boolean isNew = true;
        Realm realm = Realm.getInstance(this);
        RealmQuery<Card> query = realm.where(Card.class);
        RealmResults<Card> results = query.findAll();
        realm.beginTransaction();
        for (int i = 0; i < results.size(); i++) {
            if (aQuote.getSymbol().toUpperCase().equals(results.get(i).getSymbol().toUpperCase()))
                isNew = false;
        }
        realm.commitTransaction();
        return isNew;
    }

    public void addStockToRealm(Quote aQuote) {
        Realm realm = Realm.getInstance(this);
        realm.beginTransaction();
        Card card = realm.createObject(Card.class);
        card.setSymbol(aQuote.getSymbol());
        card.setCompanyName(aQuote.getName());
        card.setLastPrice(aQuote.getLastPrice());
        card.setPositiveChange(aQuote.getChangePercent() > 0.0);
        card.setChangePercent(aQuote.getChangePercent());
        realm.commitTransaction();

        RealmResults<Card> result = realm.where(Card.class).findAll();
        Log.i("TEST", result.toString());
    }

    public void removeStockFromRealm(Card card) {
        Realm realm = Realm.getInstance(this);
        RealmQuery<Card> query = realm.where(Card.class);
        RealmResults<Card> results = query.findAll();
        realm.beginTransaction();
        for (int i = 0; i < results.size(); i++) {
            if (card.getSymbol().toUpperCase().equals(results.get(i).getSymbol().toUpperCase()))
                results.remove(i);
        }
        realm.commitTransaction();

        RealmResults<Card> logging = realm.where(Card.class).findAll();
        Log.i("TEST", logging.toString());
    }

    public void removeAllFromRealm() {
         Realm realm = Realm.getInstance(this);
         RealmQuery<Card> query = realm.where(Card.class);
         RealmResults<Card> results = query.findAll();
         realm.beginTransaction();
         results.clear();
         realm.commitTransaction();
    }

    public void refreshQuotes() {

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

        if (id == R.id.action_add_stock) {
            //TODO: change this to the search dialog in the action bar
            displayAddStockDialog();
            return true;
        } else if (id == R.id.action_refresh_quotes) {
            refreshQuotes();
            return true;
        } else if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}