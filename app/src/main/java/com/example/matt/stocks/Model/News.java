package com.example.matt.stocks.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class News {

    private Integer count;
    private Value value;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * @return The value
     */
    public Value getValue() {
        return value;
    }

    /**
     * @param value The value
     */
    public void setValue(Value value) {
        this.value = value;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    public class Guid {

        private String isPermaLink;
        private String content;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The isPermaLink
         */
        public String getIsPermaLink() {
            return isPermaLink;
        }

        /**
         * @param isPermaLink The isPermaLink
         */
        public void setIsPermaLink(String isPermaLink) {
            this.isPermaLink = isPermaLink;
        }

        /**
         * @return The content
         */
        public String getContent() {
            return content;
        }

        /**
         * @param content The content
         */
        public void setContent(String content) {
            this.content = content;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Item {

        private String title;
        private String link;
        private Object description;
        private Guid guid;
        private String pubDate;
        private YPublished yPublished;
        private YId yId;
        private String yTitle;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The title
         */
        public String getTitle() {
            return title;
        }

        /**
         * @param title The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * @return The link
         */
        public String getLink() {
            return link;
        }

        /**
         * @param link The link
         */
        public void setLink(String link) {
            this.link = link;
        }

        /**
         * @return The description
         */
        public Object getDescription() {
            return description;
        }

        /**
         * @param description The description
         */
        public void setDescription(Object description) {
            this.description = description;
        }

        /**
         * @return The guid
         */
        public Guid getGuid() {
            return guid;
        }

        /**
         * @param guid The guid
         */
        public void setGuid(Guid guid) {
            this.guid = guid;
        }

        /**
         * @return The pubDate
         */
        public String getPubDate() {
            return pubDate;
        }

        /**
         * @param pubDate The pubDate
         */
        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        /**
         * @return The yPublished
         */
        public YPublished getYPublished() {
            return yPublished;
        }

        /**
         * @param yPublished The y:published
         */
        public void setYPublished(YPublished yPublished) {
            this.yPublished = yPublished;
        }

        /**
         * @return The yId
         */
        public YId getYId() {
            return yId;
        }

        /**
         * @param yId The y:id
         */
        public void setYId(YId yId) {
            this.yId = yId;
        }

        /**
         * @return The yTitle
         */
        public String getYTitle() {
            return yTitle;
        }

        /**
         * @param yTitle The y:title
         */
        public void setYTitle(String yTitle) {
            this.yTitle = yTitle;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }


    public class Value {

        private String title;
        private String description;
        private String link;
        private String pubDate;
        private String generator;
        private String callback;
        private List<Item> items = new ArrayList<Item>();
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The title
         */
        public String getTitle() {
            return title;
        }

        /**
         * @param title The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * @return The description
         */
        public String getDescription() {
            return description;
        }

        /**
         * @param description The description
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * @return The link
         */
        public String getLink() {
            return link;
        }

        /**
         * @param link The link
         */
        public void setLink(String link) {
            this.link = link;
        }

        /**
         * @return The pubDate
         */
        public String getPubDate() {
            return pubDate;
        }

        /**
         * @param pubDate The pubDate
         */
        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        /**
         * @return The generator
         */
        public String getGenerator() {
            return generator;
        }

        /**
         * @param generator The generator
         */
        public void setGenerator(String generator) {
            this.generator = generator;
        }

        /**
         * @return The callback
         */
        public String getCallback() {
            return callback;
        }

        /**
         * @param callback The callback
         */
        public void setCallback(String callback) {
            this.callback = callback;
        }

        /**
         * @return The items
         */
        public List<Item> getItems() {
            return items;
        }

        /**
         * @param items The items
         */
        public void setItems(List<Item> items) {
            this.items = items;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class YId {

        private String permalink;
        private String value;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The permalink
         */
        public String getPermalink() {
            return permalink;
        }

        /**
         * @param permalink The permalink
         */
        public void setPermalink(String permalink) {
            this.permalink = permalink;
        }

        /**
         * @return The value
         */
        public String getValue() {
            return value;
        }

        /**
         * @param value The value
         */
        public void setValue(String value) {
            this.value = value;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class YPublished {

        private String hour;
        private String timezone;
        private String second;
        private String month;
        private String monthName;
        private String minute;
        private String utime;
        private String day;
        private String dayOrdinalSuffix;
        private String dayOfWeek;
        private String dayName;
        private String year;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The hour
         */
        public String getHour() {
            return hour;
        }

        /**
         * @param hour The hour
         */
        public void setHour(String hour) {
            this.hour = hour;
        }

        /**
         * @return The timezone
         */
        public String getTimezone() {
            return timezone;
        }

        /**
         * @param timezone The timezone
         */
        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        /**
         * @return The second
         */
        public String getSecond() {
            return second;
        }

        /**
         * @param second The second
         */
        public void setSecond(String second) {
            this.second = second;
        }

        /**
         * @return The month
         */
        public String getMonth() {
            return month;
        }

        /**
         * @param month The month
         */
        public void setMonth(String month) {
            this.month = month;
        }

        /**
         * @return The monthName
         */
        public String getMonthName() {
            return monthName;
        }

        /**
         * @param monthName The month_name
         */
        public void setMonthName(String monthName) {
            this.monthName = monthName;
        }

        /**
         * @return The minute
         */
        public String getMinute() {
            return minute;
        }

        /**
         * @param minute The minute
         */
        public void setMinute(String minute) {
            this.minute = minute;
        }

        /**
         * @return The utime
         */
        public String getUtime() {
            return utime;
        }

        /**
         * @param utime The utime
         */
        public void setUtime(String utime) {
            this.utime = utime;
        }

        /**
         * @return The day
         */
        public String getDay() {
            return day;
        }

        /**
         * @param day The day
         */
        public void setDay(String day) {
            this.day = day;
        }

        /**
         * @return The dayOrdinalSuffix
         */
        public String getDayOrdinalSuffix() {
            return dayOrdinalSuffix;
        }

        /**
         * @param dayOrdinalSuffix The day_ordinal_suffix
         */
        public void setDayOrdinalSuffix(String dayOrdinalSuffix) {
            this.dayOrdinalSuffix = dayOrdinalSuffix;
        }

        /**
         * @return The dayOfWeek
         */
        public String getDayOfWeek() {
            return dayOfWeek;
        }

        /**
         * @param dayOfWeek The day_of_week
         */
        public void setDayOfWeek(String dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
        }

        /**
         * @return The dayName
         */
        public String getDayName() {
            return dayName;
        }

        /**
         * @param dayName The day_name
         */
        public void setDayName(String dayName) {
            this.dayName = dayName;
        }

        /**
         * @return The year
         */
        public String getYear() {
            return year;
        }

        /**
         * @param year The year
         */
        public void setYear(String year) {
            this.year = year;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
}