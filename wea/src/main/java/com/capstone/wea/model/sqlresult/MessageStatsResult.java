package com.capstone.wea.model.sqlresult;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Time;

public class MessageStatsResult {
    @JsonProperty("averageTime")
    private Time avgTime;

    @JsonProperty("shortestTime")
    private Time shortTime;

    @JsonProperty("longestTime")
    private Time longTime;

    @JsonProperty("averageDelay")
    private Time avgDelay;

    @JsonProperty("deviceCount")
    private int deviceCount;

    @JsonProperty("receivedOutsideCount")
    private int receivedOutsideCount;

    @JsonProperty("displayedOutsideCount")
    private int displayedOutsideCount;

    /**
     * Sets the average time between when a message
     * was sent and when all the devices received it
     *
     * @param avgTime
     */
    public void setAvgTime(Time avgTime) {
        this.avgTime = avgTime;
    }

    /**
     * Sets the shortest difference in time between
     * all devices received a message and when it
     * was sent
     *
     * @param shortTime
     */
    public void setShortTime(Time shortTime) {
        this.shortTime = shortTime;
    }

    /**
     * Sets the longest difference in time between
     * all devices received a message and when it
     * was sent
     *
     * @param longTime
     */
    public void setLongTime(Time longTime) {
        this.longTime = longTime;
    }

    /**
     * Sets the average amount of time between
     * when all devices received a message and
     * when it was displayed on the device
     *
     * @param avgDelay
     */
    public void setAvgDelay(Time avgDelay) {
        this.avgDelay = avgDelay;
    }

    /**
     * Sets the number of devices that received a message
     *
     * @param deviceCount
     */
    public void setDeviceCount(int deviceCount) {
        this.deviceCount = deviceCount;
    }

    /**
     * Sets the number of devices that were outside the
     * message's target area when the message was received
     *
     * @param receivedOutsideCount
     */
    public void setReceivedOutsideCount(int receivedOutsideCount) {
        this.receivedOutsideCount = receivedOutsideCount;
    }

    /**
     * Sets the number of devices that were outside the
     * message's target area when the message was displayed
     *
     * @param displayedOutsideCount
     */
    public void setDisplayedOutsideCount(int displayedOutsideCount) {
        this.displayedOutsideCount = displayedOutsideCount;
    }
}
