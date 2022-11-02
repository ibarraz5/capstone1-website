package com.capstone.wea.model.sqlresult;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Time;

public class MessageStatsResult {
    @JsonProperty("messageNumber")
    private String messageNumber;

    @JsonProperty("date")
    private String date;
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

    @JsonIgnoreProperties
    private int receivedInsideCount;

    @JsonIgnoreProperties
    private int displayedInsideCount;

    public MessageStatsResult(String messageNumber) {
        this.messageNumber = messageNumber;
    }

    /**
     * Sets the CMAC_message number for this message
     *
     * @param messageNumber the message number
     */
    public void setMessageNumber(String messageNumber) {
        this.messageNumber = messageNumber;
    }

    /**
     * Sets the date that this message was issued by
     * the AO
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Sets the average time between when a message
     * was sent and when all the devices received it
     *
     * @param avgTime the average time
     */
    public void setAvgTime(Time avgTime) {
        this.avgTime = avgTime;
    }

    /**
     * Sets the shortest difference in time between
     * all devices received a message and when it
     * was sent
     *
     * @param shortTime the shortest time
     */
    public void setShortTime(Time shortTime) {
        this.shortTime = shortTime;
    }

    /**
     * Sets the longest difference in time between
     * all devices received a message and when it
     * was sent
     *
     * @param longTime the longest time
     */
    public void setLongTime(Time longTime) {
        this.longTime = longTime;
    }

    /**
     * Sets the average amount of time between
     * when all devices received a message and
     * when it was displayed on the device
     *
     * @param avgDelay the average delay
     */
    public void setAvgDelay(Time avgDelay) {
        this.avgDelay = avgDelay;
    }

    /**
     * Sets the number of devices that received a message
     *
     * @param deviceCount the number of devices
     */
    public void setDeviceCount(int deviceCount) {
        this.deviceCount = deviceCount;
    }

    /**
     * Sets the number of devices that were inside the
     * message's target area when the message was received
     *
     * @param receivedInsideCount the number of devices
     */
    public void setReceivedInsideCount(int receivedInsideCount) {
        this.receivedInsideCount = receivedInsideCount;
    }

    /**
     * Sets the number of devices that were inside the
     * message's target area when the message was displayed
     *
     * @param displayedInsideCount the number of devices
     */
    public void setDisplayedInsideCount(int displayedInsideCount) {
        this.displayedInsideCount = displayedInsideCount;
    }

    /**
     * Gets the number of devices for which the message
     * was received while the device was outside the
     * target area
     *
     * @return The number of devices
     */
    @JsonProperty("receivedOutsideCount")
    public int getReceivedOutsideCount() {
        return deviceCount - receivedInsideCount;
    }

    /**
     * Gets the number of devices for which the message
     * was received while the device was outside the
     * target area
     *
     * @return The number of devices
     */
    @JsonProperty("displayedOutsideCount")
    public int getDisplayedOutsideCount() {
        return deviceCount - displayedInsideCount;
    }
}
