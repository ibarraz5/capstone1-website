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

    @JsonProperty("totalDevices")
    private int totalDevices;

    @JsonProperty("totalDevicesOutside")
    private int devicesOutside;
}
