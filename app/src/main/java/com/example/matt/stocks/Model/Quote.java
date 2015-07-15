package com.example.matt.stocks.Model;

import com.google.gson.annotations.Expose;

public class Quote {

    @Expose
    private String Name;
    @Expose
    private String Symbol;
    @Expose
    private Double LastPrice;
    @Expose
    private Double Change;
    @Expose
    private Double ChangePercent;
    @Expose
    private String Timestamp;
    @Expose
    private Double MSDate;
    @Expose
    private long MarketCap;
    @Expose
    private Double Volume;
    @Expose
    private Double ChangeYTD;
    @Expose
    private Double ChangePercentYTD;
    @Expose
    private Double High;
    @Expose
    private Double Low;
    @Expose
    private Double Open;

    /**
     *
     * @return
     * The Name
     */
    public String getName() {
        return Name;
    }

    /**
     *
     * @param Name
     * The Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     *
     * @return
     * The Symbol
     */
    public String getSymbol() {
        return Symbol;
    }

    /**
     *
     * @param Symbol
     * The Symbol
     */
    public void setSymbol(String Symbol) {
        this.Symbol = Symbol;
    }

    /**
     *
     * @return
     * The LastPrice
     */
    public Double getLastPrice() {
        return LastPrice;
    }

    /**
     *
     * @param LastPrice
     * The LastPrice
     */
    public void setLastPrice(Double LastPrice) {
        this.LastPrice = LastPrice;
    }

    /**
     *
     * @return
     * The Change
     */
    public Double getChange() {
        return Change;
    }

    /**
     *
     * @param Change
     * The Change
     */
    public void setChange(Double Change) {
        this.Change = Change;
    }

    /**
     *
     * @return
     * The ChangePercent
     */
    public Double getChangePercent() {
        return ChangePercent;
    }

    /**
     *
     * @param ChangePercent
     * The ChangePercent
     */
    public void setChangePercent(Double ChangePercent) {
        this.ChangePercent = ChangePercent;
    }

    /**
     *
     * @return
     * The Timestamp
     */
    public String getTimestamp() {
        return Timestamp;
    }

    /**
     *
     * @param Timestamp
     * The Timestamp
     */
    public void setTimestamp(String Timestamp) {
        this.Timestamp = Timestamp;
    }

    /**
     *
     * @return
     * The MSDate
     */
    public Double getMSDate() {
        return MSDate;
    }

    /**
     *
     * @param MSDate
     * The MSDate
     */
    public void setMSDate(Double MSDate) {
        this.MSDate = MSDate;
    }

    /**
     *
     * @return
     * The MarketCap
     */
    public long getMarketCap() {
        return MarketCap;
    }

    /**
     *
     * @param MarketCap
     * The MarketCap
     */
    public void setMarketCap(Integer MarketCap) {
        this.MarketCap = MarketCap;
    }

    /**
     *
     * @return
     * The Volume
     */
    public Double getVolume() {
        return Volume;
    }

    /**
     *
     * @param Volume
     * The Volume
     */
    public void setVolume(Double Volume) {
        this.Volume = Volume;
    }

    /**
     *
     * @return
     * The ChangeYTD
     */
    public Double getChangeYTD() {
        return ChangeYTD;
    }

    /**
     *
     * @param ChangeYTD
     * The ChangeYTD
     */
    public void setChangeYTD(Double ChangeYTD) {
        this.ChangeYTD = ChangeYTD;
    }

    /**
     *
     * @return
     * The ChangePercentYTD
     */
    public Double getChangePercentYTD() {
        return ChangePercentYTD;
    }

    /**
     *
     * @param ChangePercentYTD
     * The ChangePercentYTD
     */
    public void setChangePercentYTD(Double ChangePercentYTD) {
        this.ChangePercentYTD = ChangePercentYTD;
    }

    /**
     *
     * @return
     * The High
     */
    public Double getHigh() {
        return High;
    }

    /**
     *
     * @param High
     * The High
     */
    public void setHigh(Double High) {
        this.High = High;
    }

    /**
     *
     * @return
     * The Low
     */
    public Double getLow() {
        return Low;
    }

    /**
     *
     * @param Low
     * The Low
     */
    public void setLow(Double Low) {
        this.Low = Low;
    }

    /**
     *
     * @return
     * The Open
     */
    public Double getOpen() {
        return Open;
    }

    /**
     *
     * @param Open
     * The Open
     */
    public void setOpen(Double Open) {
        this.Open = Open;
    }

}