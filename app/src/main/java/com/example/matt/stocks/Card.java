package com.example.matt.stocks;

import io.realm.RealmObject;

public class Card extends RealmObject {

    private String symbol;
    private String companyName;
    private double lastPrice;
    private boolean positiveChange;
    private double changePercent;

    public Card() {}

    public Card (String aSymbol, String aCompanyName) {
        this.symbol = aSymbol;
        this.companyName = aCompanyName;
        this.lastPrice = 0.0;
        this.positiveChange = true;
        this.changePercent = 0.0;
    }
    
    public Card(String aSymbol, String aCompanyName, double aLastPrice, boolean aPositiveChange, double aChangePercent) {
        this.symbol = aSymbol;
        this.companyName = aCompanyName;
        this.lastPrice = aLastPrice;
        this.positiveChange = aPositiveChange;
        this.changePercent = aChangePercent;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getLastPrice() {
        return this.lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public boolean isPositiveChange() {
        return this.positiveChange;
    }

    public void setPositiveChange(boolean positiveChange) {
        this.positiveChange = positiveChange;
    }

    public double getChangePercent() {
        return this.changePercent;
    }

    public void setChangePercent(double changePercent) {
        this.changePercent = changePercent;
    }
}
