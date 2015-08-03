package com.example.matt.stocks.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSeries {

    private Open open;
    private High high;
    private Low low;
    private Close close;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The open
     */
    public Open getOpen() {
        return open;
    }

    /**
     * @param open The open
     */
    public void setOpen(Open open) {
        this.open = open;
    }

    /**
     * @return The high
     */
    public High getHigh() {
        return high;
    }

    /**
     * @param high The high
     */
    public void setHigh(High high) {
        this.high = high;
    }

    /**
     * @return The low
     */
    public Low getLow() {
        return low;
    }

    /**
     * @param low The low
     */
    public void setLow(Low low) {
        this.low = low;
    }

    /**
     * @return The close
     */
    public Close getClose() {
        return close;
    }

    /**
     * @param close The close
     */
    public void setClose(Close close) {
        this.close = close;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    public class Close {

        private Double min;
        private Integer max;
        private String maxDate;
        private String minDate;
        private List<Double> values = new ArrayList<Double>();
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The min
         */
        public Double getMin() {
            return min;
        }

        /**
         * @param min The min
         */
        public void setMin(Double min) {
            this.min = min;
        }

        /**
         * @return The max
         */
        public Integer getMax() {
            return max;
        }

        /**
         * @param max The max
         */
        public void setMax(Integer max) {
            this.max = max;
        }

        /**
         * @return The maxDate
         */
        public String getMaxDate() {
            return maxDate;
        }

        /**
         * @param maxDate The maxDate
         */
        public void setMaxDate(String maxDate) {
            this.maxDate = maxDate;
        }

        /**
         * @return The minDate
         */
        public String getMinDate() {
            return minDate;
        }

        /**
         * @param minDate The minDate
         */
        public void setMinDate(String minDate) {
            this.minDate = minDate;
        }

        /**
         * @return The values
         */
        public List<Double> getValues() {
            return values;
        }

        /**
         * @param values The values
         */
        public void setValues(List<Double> values) {
            this.values = values;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Element {

        private String Currency;
        private Object TimeStamp;
        private String Symbol;
        private String Type;
        private DataSeries DataSeries;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The Currency
         */
        public String getCurrency() {
            return Currency;
        }

        /**
         * @param Currency The Currency
         */
        public void setCurrency(String Currency) {
            this.Currency = Currency;
        }

        /**
         * @return The TimeStamp
         */
        public Object getTimeStamp() {
            return TimeStamp;
        }

        /**
         * @param TimeStamp The TimeStamp
         */
        public void setTimeStamp(Object TimeStamp) {
            this.TimeStamp = TimeStamp;
        }

        /**
         * @return The Symbol
         */
        public String getSymbol() {
            return Symbol;
        }

        /**
         * @param Symbol The Symbol
         */
        public void setSymbol(String Symbol) {
            this.Symbol = Symbol;
        }

        /**
         * @return The Type
         */
        public String getType() {
            return Type;
        }

        /**
         * @param Type The Type
         */
        public void setType(String Type) {
            this.Type = Type;
        }

        /**
         * @return The DataSeries
         */
        public DataSeries getDataSeries() {
            return DataSeries;
        }

        /**
         * @param DataSeries The DataSeries
         */
        public void setDataSeries(DataSeries DataSeries) {
            this.DataSeries = DataSeries;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Example {

        private Labels Labels;
        private List<Integer> Positions = new ArrayList<Integer>();
        private List<String> Dates = new ArrayList<String>();
        private List<Element> Elements = new ArrayList<Element>();
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The Labels
         */
        public Labels getLabels() {
            return Labels;
        }

        /**
         * @param Labels The Labels
         */
        public void setLabels(Labels Labels) {
            this.Labels = Labels;
        }

        /**
         * @return The Positions
         */
        public List<Integer> getPositions() {
            return Positions;
        }

        /**
         * @param Positions The Positions
         */
        public void setPositions(List<Integer> Positions) {
            this.Positions = Positions;
        }

        /**
         * @return The Dates
         */
        public List<String> getDates() {
            return Dates;
        }

        /**
         * @param Dates The Dates
         */
        public void setDates(List<String> Dates) {
            this.Dates = Dates;
        }

        /**
         * @return The Elements
         */
        public List<Element> getElements() {
            return Elements;
        }

        /**
         * @param Elements The Elements
         */
        public void setElements(List<Element> Elements) {
            this.Elements = Elements;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class High {

        private Double min;
        private Double max;
        private String maxDate;
        private String minDate;
        private List<Double> values = new ArrayList<Double>();
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The min
         */
        public Double getMin() {
            return min;
        }

        /**
         * @param min The min
         */
        public void setMin(Double min) {
            this.min = min;
        }

        /**
         * @return The max
         */
        public Double getMax() {
            return max;
        }

        /**
         * @param max The max
         */
        public void setMax(Double max) {
            this.max = max;
        }

        /**
         * @return The maxDate
         */
        public String getMaxDate() {
            return maxDate;
        }

        /**
         * @param maxDate The maxDate
         */
        public void setMaxDate(String maxDate) {
            this.maxDate = maxDate;
        }

        /**
         * @return The minDate
         */
        public String getMinDate() {
            return minDate;
        }

        /**
         * @param minDate The minDate
         */
        public void setMinDate(String minDate) {
            this.minDate = minDate;
        }

        /**
         * @return The values
         */
        public List<Double> getValues() {
            return values;
        }

        /**
         * @param values The values
         */
        public void setValues(List<Double> values) {
            this.values = values;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Labels {

        private X x;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The x
         */
        public X getX() {
            return x;
        }

        /**
         * @param x The x
         */
        public void setX(X x) {
            this.x = x;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Low {

        private Double min;
        private Double max;
        private String maxDate;
        private String minDate;
        private List<Double> values = new ArrayList<Double>();
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The min
         */
        public Double getMin() {
            return min;
        }

        /**
         * @param min The min
         */
        public void setMin(Double min) {
            this.min = min;
        }

        /**
         * @return The max
         */
        public Double getMax() {
            return max;
        }

        /**
         * @param max The max
         */
        public void setMax(Double max) {
            this.max = max;
        }

        /**
         * @return The maxDate
         */
        public String getMaxDate() {
            return maxDate;
        }

        /**
         * @param maxDate The maxDate
         */
        public void setMaxDate(String maxDate) {
            this.maxDate = maxDate;
        }

        /**
         * @return The minDate
         */
        public String getMinDate() {
            return minDate;
        }

        /**
         * @param minDate The minDate
         */
        public void setMinDate(String minDate) {
            this.minDate = minDate;
        }

        /**
         * @return The values
         */
        public List<Double> getValues() {
            return values;
        }

        /**
         * @param values The values
         */
        public void setValues(List<Double> values) {
            this.values = values;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Open {

        private Double min;
        private Double max;
        private String maxDate;
        private String minDate;
        private List<Integer> values = new ArrayList<Integer>();
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The min
         */
        public Double getMin() {
            return min;
        }

        /**
         * @param min The min
         */
        public void setMin(Double min) {
            this.min = min;
        }

        /**
         * @return The max
         */
        public Double getMax() {
            return max;
        }

        /**
         * @param max The max
         */
        public void setMax(Double max) {
            this.max = max;
        }

        /**
         * @return The maxDate
         */
        public String getMaxDate() {
            return maxDate;
        }

        /**
         * @param maxDate The maxDate
         */
        public void setMaxDate(String maxDate) {
            this.maxDate = maxDate;
        }

        /**
         * @return The minDate
         */
        public String getMinDate() {
            return minDate;
        }

        /**
         * @param minDate The minDate
         */
        public void setMinDate(String minDate) {
            this.minDate = minDate;
        }

        /**
         * @return The values
         */
        public List<Integer> getValues() {
            return values;
        }

        /**
         * @param values The values
         */
        public void setValues(List<Integer> values) {
            this.values = values;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class X {

        private List<String> text = new ArrayList<String>();
        private List<String> dates = new ArrayList<String>();
        private List<String> utcDates = new ArrayList<String>();
        private List<Integer> pos = new ArrayList<Integer>();
        private List<Double> priorities = new ArrayList<Double>();
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The text
         */
        public List<String> getText() {
            return text;
        }

        /**
         * @param text The text
         */
        public void setText(List<String> text) {
            this.text = text;
        }

        /**
         * @return The dates
         */
        public List<String> getDates() {
            return dates;
        }

        /**
         * @param dates The dates
         */
        public void setDates(List<String> dates) {
            this.dates = dates;
        }

        /**
         * @return The utcDates
         */
        public List<String> getUtcDates() {
            return utcDates;
        }

        /**
         * @param utcDates The utcDates
         */
        public void setUtcDates(List<String> utcDates) {
            this.utcDates = utcDates;
        }

        /**
         * @return The pos
         */
        public List<Integer> getPos() {
            return pos;
        }

        /**
         * @param pos The pos
         */
        public void setPos(List<Integer> pos) {
            this.pos = pos;
        }

        /**
         * @return The priorities
         */
        public List<Double> getPriorities() {
            return priorities;
        }

        /**
         * @param priorities The priorities
         */
        public void setPriorities(List<Double> priorities) {
            this.priorities = priorities;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
}