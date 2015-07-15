package com.example.matt.stocks.Model;

import java.util.HashMap;
import java.util.Map;

public class Company {

    private String Symbol;
    private String Name;
    private String Exchange;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     * The Exchange
     */
    public String getExchange() {
        return Exchange;
    }

    /**
     *
     * @param Exchange
     * The Exchange
     */
    public void setExchange(String Exchange) {
        this.Exchange = Exchange;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}