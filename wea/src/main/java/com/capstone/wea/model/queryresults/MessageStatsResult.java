package com.capstone.wea.model.queryresults;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageStatsResult {
    @JsonProperty("averageTime")
    private int avgTime;

    @JsonProperty("shortestTime")
    private int shortTime;

    @JsonProperty("longestTIme")
    private int longTime;

    @JsonProperty("averageDelay")
    private int avgDelay;

    @JsonProperty("deviceCount")
    private int deviceCount;

    @JsonProperty("outsideDeviceCount")
    private int outsideDeviceCount;

    public void setAvgTime(int avgTime) {
        this.avgTime = avgTime;
    }

    public void setShortTime(int shortTime) {
        this.shortTime = shortTime;
    }

    public void setLongTime(int longTime) {
        this.longTime = longTime;
    }

    public void setAvgDelay(int avgDelay) {
        this.avgDelay = avgDelay;
    }

    public void setDeviceCount(int deviceCount) {
        this.deviceCount = deviceCount;
    }

    public void setOutsideDeviceCount(int outsideDeviceCount) {
        this.outsideDeviceCount = outsideDeviceCount;
    }
}
